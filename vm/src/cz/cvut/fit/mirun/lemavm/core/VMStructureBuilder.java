package cz.cvut.fit.mirun.lemavm.core;

import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenRewriteStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.stringtemplate.StringTemplate;
import org.apache.log4j.Logger;

import cz.cvut.fit.mirun.lemavm.antlr.LeMaVMLexer;
import cz.cvut.fit.mirun.lemavm.antlr.LeMaVMParser;
import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMClass;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMField;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMMethod;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMVisibilityModifier;

public class VMStructureBuilder {
	private static final Logger LOG = Logger.getLogger(VMStructureBuilder.class);
	
	private CommonTree tree;
	private CharStream cs;
	
	public VMStructureBuilder(CharStream cs){
		this.cs = cs;
	}
	
	private void buildASTTree() throws RecognitionException{
		LeMaVMLexer lexer = new LeMaVMLexer(cs);
		TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		LeMaVMParser parser = new LeMaVMParser(tokens);
		parser.enableErrorMessageCollection(true);
		
		tree = (CommonTree)parser.javaSource().getTree();
		
		if(parser.getMessages().size() > 0){
			throw new VMParsingException(parser.getMessages().toString());
		}
	}
	
	/**
	 * Print tree graph to console in standardized .dot format
	 * on-linux$ dot -Tpng -o output.png input.dot
	 */
	public void printTreeToDot(){
		DOTTreeGenerator gen = new DOTTreeGenerator();
        StringTemplate st = gen.toDOT(tree);
        System.out.println(st);
	}
	
	private String buildTypeFromTree(CommonTree node){
		if(node.getChild(0).getChildCount() == 0){
			return node.getChild(0).toString();
		}else{
			return node.getChild(0).getChild(0).toString();
		}
	}
	
	/**
	 * Read variable structure from given node and VMClass.addField
	 * @param node
	 * @param cls
	 */
	private void buildVarFromTree(CommonTree node, VMClass cls){
		CommonTree child = null;
		VMVisibilityModifier visibility = VMVisibilityModifier.getDefault();
		boolean isStatic = false;
		String type = null, name = null, strVal = null;
		Object val = null;
		
		for(Object o : node.getChildren()){
			child = (CommonTree) o;
			
			switch(child.toString()){
			case "MODIFIER_LIST":
				if(child.getChildCount() > 0){
					visibility = VMVisibilityModifier.fromString(child.getChild(0).toString());
					isStatic = (child.getChildren().indexOf("static") != -1);
				}
				break;
			case "TYPE":
				type = buildTypeFromTree(child);
				break;
			// TODO support for expressions like int a = 5 + 5 * 8;
			case "VAR_DECLARATOR_LIST":
				for(Object o1 : child.getChildren()){
					child = (CommonTree) o1;
					if(child.toString().equals("VAR_DECLARATOR") && child.getChildCount() == 2){
						name = child.getChild(0).toString();
						try{
							strVal = child.getChild(1).getChild(0).toString();
							val = VMUtils.castValue(type, strVal);
						}catch(NumberFormatException e){
							throw new VMParsingException("Can not assign value '"+strVal+
									"' to the type '"+type+"' in class '"+cls.getName()+"'");
						}
					}else if(child.toString().equals("VAR_DECLARATOR") && child.getChildCount() == 1){
						name = child.getChild(0).toString();
						val = VMUtils.getTypeDefaultValue(type);
					}else{
						throw new VMParsingException("Unexpected program syntax '"+child.toString()+
								"' in class '"+cls.getName()+"'");
					}
					cls.addField(new VMField(name, isStatic, visibility, type, val));
				}
				break;
			default:
				throw new VMParsingException(
						"Unexpected program syntax '"+child.toString()+"' in class '"+cls.getName()+"'");
			}
		}
	}
	
//	/**
//	 * Read constructor structure from given node and build it
//	 * @param node
//	 * @param cls
//	 */
//	private void buildConstructor(CommonTree node, VMClass cls){
//	}

	/**
	 * Read method/constructor structure from given node and build VMMethod
	 * @param node
	 * @param cls
	 */
	private void buildMethodFromTree(CommonTree node, VMClass cls){
		CommonTree child = null, block = null;
		VMVisibilityModifier visibility = VMVisibilityModifier.getDefault();
		boolean isStatic = false;
		String returnType = "void", name = cls.getName(), argType = null, argName = null;
		Map<String, String> args = null;
		
		for(Object o : node.getChildren()){
			child = (CommonTree) o;
			
			switch(child.toString()){
			case "MODIFIER_LIST":
				if(child.getChildCount() > 0){
					visibility = VMVisibilityModifier.fromString(child.getChild(0).toString());
					isStatic = (child.getChildren().indexOf("static") != -1);
				}
				break;
			case "TYPE":
				type = buildTypeFromTree(child);
				break;
			case "FORMAL_PARAM_LIST":
				if(child.getChildCount() > 0){
					args = new HashMap<>();
					
					for(Object o1 : child.getChildren()){
						child = (CommonTree) o1;
						if(child.toString().equals("FORMAL_PARAM_STD_DECL")){
							argType = child.getChild(1).getChild(0).toString();
							argName = child.getChild(2).toString();
							args.put(argName, argType);
						}else{
							throw new VMParsingException("Unexpected program syntax '"+child.toString()+
									"' in class '"+cls.getName()+"', method '"+name+"'");
						}
					}
				}
				break;
			case "BLOCK_SCOPE":
				block = child;
				break;
			default:
				// TODO error detection
				name = child.toString();
			}
		}
		
		VMMethod method = new VMMethod(name, cls, isStatic, visibility, returnType, args, block);
		cls.addMethod(method);
	}
	
	/**
	 * Read structure from given node and build variables, constructors and methods for given class
	 * @param node
	 * @param cls
	 */
	private void buildVarsAndMethodsFromTree(CommonTree node, VMClass cls){
		CommonTree child = null;
		
		for(Object o : node.getChildren()){
			child = (CommonTree) o;
			
			switch(child.toString()){
			case "VAR_DECLARATION":
				buildVarFromTree(child, cls);
				break;
			case "CONSTRUCTOR_DECL":
//				buildConstructor(child, cls);
//				break;
			case "FUNCTION_METHOD_DECL":
			case "VOID_METHOD_DECL":
				buildMethodFromTree(child, cls);
				break;
			default:
				throw new VMParsingException(
						"Unexpected program syntax '"+child.toString()+"' in class '"+cls.getName()+"'");
			}
		}
	}
	
	/**
	 * Read class structure from node and build VMClass
	 * @param node
	 */
	private void buildClassFromTree(CommonTree node){
		CommonTree child = null;
		VMClass cls = null;
		String name = null;
		VMVisibilityModifier visibility = VMVisibilityModifier.getDefault();
		boolean isStatic = false;
		
		for(Object o : node.getChildren()){
			child = (CommonTree) o;
			
			// TODO extend switch in case of class inheritance
			switch(child.toString()){
			case "MODIFIER_LIST":
				// TODO if has more than two children, throw exception? (i.e. public, static)
				if(child.getChildCount() > 0){
					visibility = VMVisibilityModifier.fromString(child.getChild(0).toString());
					isStatic = (child.getChildren().indexOf("static") != -1);
				}
				break;
			case "CLASS_TOP_LEVEL_SCOPE":
				// null == no parent
				cls = VMClass.createClass(name, null, isStatic, visibility);
				buildVarsAndMethodsFromTree(child, cls);
				break;
			default:
				if(name == null){
					name = child.toString();
				}else{
					throw new VMParsingException(
							"Unexpected program syntax '"+child.toString()+"' in class '"+name+"'");
				}
				break;
			}
		}
	}
	
	/**
	 * Build Meta classes, their variables, constructors and methods from tree structure
	 */
	private void buildBaseStructureFromTree(){
		for(Object o : tree.getChildren()){
			if(o.toString().equals("class")){
				buildClassFromTree((CommonTree) o);
			}else{
				throw new VMParsingException(
						"Unexpected program syntax '" + o.toString()+"', expecting class");
			}
		}
	}
	
	public void build() throws RecognitionException{
		buildASTTree();
		buildBaseStructureFromTree();
	}
}

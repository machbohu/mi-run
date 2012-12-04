package cz.cvut.fit.mirun.lemavm.builder;

import java.text.ParseException;
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
import cz.cvut.fit.mirun.lemavm.structures.VMCodeBlock;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMClass;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMField;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMMethod;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMVisibilityModifier;
import cz.cvut.fit.mirun.lemavm.utils.VMUtils;

public class VMBaseStructureBuilder extends VMBuilder {
	private static final Logger LOG = Logger.getLogger(VMBaseStructureBuilder.class);
	
	private CommonTree tree;
	private CharStream cs;
	
	public VMBaseStructureBuilder(CharStream cs){
		this.cs = cs;
	}
	
	/**
	 * Parse CharStream with ANTLR LeMaVMLexer and LeMaVMParser
	 * and get AST tree
	 * @throws RecognitionException
	 */
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
	
//	/**
//	 * Read constructor structure from given node and build it
//	 * @param node
//	 * @param cls
//	 */
//	private void buildConstructor(CommonTree node, VMClass cls){
//	}

	/**
	 * Read method/constructor structure from given node and build VMMethod;
	 * AST tree nodes [CONSTRUCTOR_DECL], [FUNCTION_METHOD_DECL], [VOID_METHOD_DECL]
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
				returnType = buildTypeFromTree(child);
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
	 * Read structure from given node and build variables, constructors and methods for given class;
	 * AST tree node [CLASS_TOP_LEVEL_SCOPE]
	 * @param node
	 * @param cls
	 */
	private void buildVarsAndMethodsFromTree(CommonTree node, VMClass cls){
		CommonTree child = null;
		
		for(Object o : node.getChildren()){
			child = (CommonTree) o;
			
			switch(child.toString()){
			case "VAR_DECLARATION":
				for(VMField f : buildVarFromTree(child)){
					try{
						if(f.getVal() == null){
							f.setVal(VMUtils.getTypeDefaultValue(f.getType()));
						}else{
							// TODO what will happen with VMOperator instead of String val?
							f.setVal(VMUtils.getTypeProperValue(f.getType(), f.getVal().toString()));
						}
						cls.addField(f);
					}catch(ParseException e){
						throw new VMParsingException("Class '"+cls.toString()
								+"': Can not assign value '" + f.getVal()
								+ "' to the type '"+f.getType()+"'");
					}
				}
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
						"Class '"+cls.getName()+"': Unexpected program syntax '"+child.toString()+"'");
			}
		}
	}
	
	/**
	 * Read class structure from node and build VMClass;
	 * AST tree node [class]
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
				cls = VMClass.createClass(name, null);
				buildVarsAndMethodsFromTree(child, cls);
				break;
			default:
				if(name == null){
					name = child.toString();
				}else{
					throw new VMParsingException(
							"Class '"+name+"': Unexpected program syntax '"+child.toString()+"'");
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
	
	public VMCodeBlock getCodeBlock(){
		return null;
	}
}

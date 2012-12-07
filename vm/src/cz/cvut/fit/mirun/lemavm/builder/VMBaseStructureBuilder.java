package cz.cvut.fit.mirun.lemavm.builder;

import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.antlr.runtime.ANTLRFileStream;
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
	
	public VMBaseStructureBuilder(String filename){
		try{
			final ANTLRFileStream fs = new ANTLRFileStream(filename);
			this.cs = fs;
		} catch (IOException e) {
			LOG.error("Unable to read the specified file.", e);
			System.exit(2);
		}
	}
	
	/**
	 * Parse CharStream with ANTLR LeMaVMLexer and LeMaVMParser
	 * and get AST tree
	 * @throws RecognitionException
	 */
	private void buildASTTree(){
		LeMaVMLexer lexer = new LeMaVMLexer(cs);
		TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		LeMaVMParser parser = new LeMaVMParser(tokens);
		parser.enableErrorMessageCollection(true);
		
		try {
			tree = (CommonTree)parser.javaSource().getTree();
		} catch (RecognitionException e) {
			throw new VMParsingException(e.getMessage());
		}
		
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
					isStatic = buildIsStatic(child);
				}
				break;
			case "TYPE":
				returnType = buildTypeFromTree(child);
				break;
			case "FORMAL_PARAM_LIST":
				if(child.getChildCount() > 0){
					args = new LinkedHashMap<>();
					
					for(Object o1 : child.getChildren()){
						child = (CommonTree) o1;
						if(child.toString().equals("FORMAL_PARAM_STD_DECL")){
							argType = buildTypeFromTree((CommonTree) child.getChild(1));
							argName = child.getChild(2).toString();
							args.put(argName, argType);
						}else{
							throw new VMParsingException("Class'"+cls.getName()+"': method '"
									+name+"': Unexpected program syntax '"+child.toString()+"'");
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
		
		if(cls.getName().equals(name)){
			cls.addConstructor(method);
		}else{
			cls.addMethod(method);
		}
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
						// TODO what will happen with VMOperator instead of String val?
						f.setVal(VMUtils.getTypeProperValue(f.getType(), f.getVal().toString()));
						cls.addField(f);
					}catch(NumberFormatException | ParseException e){
						throw new VMParsingException("Class '"+cls
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
				// TODO if has more than three children, throw exception? (i.e. public, static, final)
				if(child.getChildCount() > 0){
					visibility = VMVisibilityModifier.fromString(child.getChild(0).toString());
					isStatic = buildIsStatic(child);
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
	
	public void build(){
		buildASTTree();
		buildBaseStructureFromTree();
	}
	
	public VMCodeBlock getCodeBlock(){
		return null;
	}
}

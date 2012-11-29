package cz.cvut.fit.mirun.lemavm.core;

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
import cz.cvut.fit.mirun.lemavm.structures.classes.VMVisibilityModifier;

public class VMStructureBuilder {
	private static final Logger LOG = Logger.getLogger(VMStructureBuilder.class);
	
	private CommonTree tree;
	
	public VMStructureBuilder(CharStream cs) throws RecognitionException{
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
	
	/**
	 * Read variable structure from given node and build it
	 * @param node
	 * @param cls
	 */
	private void buildVar(CommonTree node, VMClass cls){
		CommonTree child = null;
		VMVisibilityModifier visibility = VMVisibilityModifier.getDefault();
		boolean isStatic = false;
		String type = null, name = null;
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
				type = child.toString();
				break;
			// TODO support for expressions like int a = 5 + 5 * 8;
			case "VAR_DECLARATOR_LIST":
				for(Object o1 : child.getChildren()){
					child = (CommonTree) o1;
					if(child.toString().equals("VAR_DECLARATOR") && child.getChildCount() == 2){
						name = child.getChild(0).toString();
						// TODO cast value according to type if possible
						val = child.getChild(1).getChild(0).toString();
//						System.out.println(child.getChild(1).getChild(0).getType());
					}else if(child.toString().equals("VAR_DECLARATOR") && child.getChildCount() == 1){
						name = child.getChild(0).toString();
					}else{
						throw new VMParsingException(
								"Unexpected program syntax "+child.toString()+" in class "+cls.getName());
					}
				}
				break;
			default:
				throw new VMParsingException(
						"Unexpected program syntax "+child.toString()+" in class "+cls.getName());
			}
		}
	}
	
	/**
	 * Read constructor structure from given node and build it
	 * @param node
	 * @param cls
	 */
	private void buildConstructor(CommonTree node, VMClass cls){
		
	}

	/**
	 * Read method structure from given node and build it
	 * @param node
	 * @param cls
	 */
	private void buildMethod(CommonTree node, VMClass cls){
		String returnType = "void";
	}
	
	/**
	 * Read structure from given node and build variables, constructors and methods for given class
	 * @param node
	 * @param cls
	 */
	private void buildVarsAndMethods(CommonTree node, VMClass cls){
		CommonTree child = null;
		
		for(Object o : node.getChildren()){
			child = (CommonTree) o;
			
			switch(child.toString()){
			case "VAR_DECLARATION":
				buildVar(child, cls);
				break;
			case "CONSTRUCTOR_DECL":
				buildConstructor(child, cls);
				break;
			case "FUNCTION_METHOD_DECL":
			case "VOID_METHOD_DECL":
				buildMethod(child, cls);
				break;
			default:
				throw new VMParsingException(
						"Unexpected program syntax "+child.toString()+" in class "+cls.getName());
			}
		}
	}
	
	/**
	 * Read class structure from node and build it
	 * @param node
	 */
	private void buildClass(CommonTree node){
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
				buildVarsAndMethods(child, cls);
				break;
			default:
				if(name == null){
					name = child.toString();
				}else{
					throw new VMParsingException("Unexpected program syntax: " + child.toString());
				}
				break;
			}
		}
	}
	
	/**
	 * Build Meta classes, their variables, constructors and methods from tree structure
	 */
	private void buildClasses(){
		for(Object o : tree.getChildren()){
			if(o.toString().equals("class")){
				buildClass((CommonTree) o);
			}else{
				throw new VMParsingException("Unexpected program syntax: " + o.toString());
			}
		}
	}
	
	public void run(){
		printTreeToDot();
		buildClasses();
	}
}

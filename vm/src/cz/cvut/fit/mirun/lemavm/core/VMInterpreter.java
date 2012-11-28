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

public class VMInterpreter {
	private static final Logger LOG = Logger.getLogger(VMInterpreter.class);
	
	private CommonTree tree;
	
	public VMInterpreter(CharStream cs) throws RecognitionException{
		LeMaVMLexer lexer = new LeMaVMLexer(cs);
		TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		LeMaVMParser parser = new LeMaVMParser(tokens);
		parser.enableErrorMessageCollection(true);
		
		tree = (CommonTree)parser.javaSource().getTree();
		
		if(parser.getMessages().size() > 0){
			throw new VMParsingException(parser.getMessages().toString());
		}
	}
	
	public void printTreeToDot(){
		DOTTreeGenerator gen = new DOTTreeGenerator();
        StringTemplate st = gen.toDOT(tree);
        System.out.println(st);
	}
	
	private void buildVar(CommonTree node, VMClass cls){
		
	}
	
	private void buildConstructor(CommonTree node, VMClass cls){
		
	}

	private void buildMethod(CommonTree node, VMClass cls){
		String returnType = "void";
	}
	
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
				buildMethod(child, cls);
				break;
			case "VOID_METHOD_DECL":
				buildMethod(child, cls);
				break;
			default:
				throw new VMParsingException(
						"Unexpected program syntax "+o.toString()+" in class "+cls.getName());
			}
		}
	}
	
	private void buildClass(CommonTree node){
		CommonTree child = null;
		VMClass cls = null;
		String name = null;
		VMVisibilityModifier visibility = VMVisibilityModifier.PROTECTED;
		boolean isStatic = false;
		
		for(Object o : node.getChildren()){
			child = (CommonTree) o;
			
			// TODO extend switch in case of class inheritance
			switch(child.toString()){
			case "MODIFIER_LIST":
				// TODO if has more than two children, throw exception? (i.e. public, static)
				if(child.getChildCount() > 0){
					visibility = VMVisibilityModifier.fromString(child.getChildren().get(0).toString());
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
					throw new VMParsingException("Unexpected program syntax: " + o.toString());
				}
				break;
			}
		}
	}
	
	private void buildClassesAndMethods(){
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
		buildClassesAndMethods();
	}
}

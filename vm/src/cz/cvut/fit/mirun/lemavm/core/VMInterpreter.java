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
	
	private void buildClass(CommonTree node){
		VMClass cls = null;
		
		
		for(Object o : node.getChildren()){
			switch(o.toString()){
			case "MODIFIER_LIST":
				break;
			case "CLASS_TOP_LEVEL_SCOPE":
				break;
			default:
				
//				throw new VMParsingException("Unexpected program syntax: " + o.toString());
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

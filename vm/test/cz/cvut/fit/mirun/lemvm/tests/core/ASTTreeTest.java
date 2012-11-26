package cz.cvut.fit.mirun.lemvm.tests.core;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenRewriteStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;
import org.antlr.runtime.tree.TreeAdaptor;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.antlr.LeMaVMLexer;
import cz.cvut.fit.mirun.lemavm.antlr.LeMaVMParser;

public class ASTTreeTest {

	public void printTree(CommonTree t, int indent) {
		if ( t != null ) {
			StringBuffer sb = new StringBuffer(indent);
			
			if (t.getParent() == null){
				System.out.println(sb.toString() + t.getText());	
			}
			for ( int i = 0; i < indent; i++ )
				sb = sb.append("   ");
			for ( int i = 0; i < t.getChildCount(); i++ ) {
				System.out.println(sb.toString() + t.getChild(i).toString());
				printTree((CommonTree)t.getChild(i), indent+1);
			}
		}
	}
	
	@Test
	public void test() {
		CharStream chs = new ANTLRStringStream(
			"package test;\nclass Test {\n" +
			"    int b = 5 + 6 + 6; \n" +
			"    class Inside {\n" +
			"    }\n" +
			"}"
		);
		LeMaVMLexer lex = new LeMaVMLexer(chs);
		TokenRewriteStream tokens = new TokenRewriteStream(lex);
		LeMaVMParser grammar = new LeMaVMParser(tokens);
		
		
		
		final TreeAdaptor adaptor = new CommonTreeAdaptor() {
			public Object create(Token payload) {
				return new CommonTree(payload);
			}
		};
		
		try{
			grammar.setTreeAdaptor(adaptor);
			LeMaVMParser.javaSource_return ret = grammar.javaSource();
			CommonTree tree = (CommonTree)ret.getTree();
			
			 CommonTreeNodeStream nodes = new CommonTreeNodeStream((Tree)ret.getTree());
			
			System.out.println(tree.getChildCount());
			printTree(tree, 0);
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
	}

}

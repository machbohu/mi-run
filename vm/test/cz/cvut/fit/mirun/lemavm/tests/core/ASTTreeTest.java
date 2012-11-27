package cz.cvut.fit.mirun.lemavm.tests.core;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenRewriteStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.stringtemplate.StringTemplate;
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
//			"public static int a = 5;\n" +
			"public class Test {\n" +
			"    int b = 5 + 6 * 6 + 2; \n" +
			"    int testMethod(int a) {\n" +
			"        if(a == 0){\n" +
			"            a = 1;\n" +
			"        }\n" +
			"        return a;\n" +
			"    }\n" +
			"    public int testMethod2(int a, int b) {\n" +
			"        int c = a + b;\n" +
			"        testMethod(a);\n" +
			"        b = testMethod(a);\n" +
			"        return c;\n" +
			"    }\n" +
			"    int a = 5 + 6 * 6 + 2; \n" +
			"    public class Inside{\n" +
			"        private int insideMethod(int a, int b) {\n" +
			"            int c = a + b;\n" +
			"            return c;\n" +
			"        }\n" +
			"    }\n" +
			"}\n" +
			"\n" +
			"public class Main {\n" +
			"\n" +
			"    public void main() {\n" +
			"        int a = 5, b = 2;\n" +
			"        Test t = new Test();\n" +
			"        t.testMethod(a, b);\n" +
			"        return 0;\n" +
			"    }\n" +
			"}"
		);
		LeMaVMLexer lexer = new LeMaVMLexer(chs);
		TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		LeMaVMParser parser = new LeMaVMParser(tokens);
		parser.enableErrorMessageCollection(true);
		
        try {
			CommonTree tree = (CommonTree)parser.javaSource().getTree();
//			System.out.println(parser.getMessages().toString()); // print errors
//			printTree(tree, 0);
	        DOTTreeGenerator gen = new DOTTreeGenerator();
	        StringTemplate st = gen.toDOT(tree);
	        System.out.println(st);
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
	}

}

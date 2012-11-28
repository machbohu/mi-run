package cz.cvut.fit.mirun.lemavm.tests.core;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.core.VMInterpreter;
import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;

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
			"    public static int str = \"a\"; \n" +
			"    int char = 'a'; \n" +
			"    int num = 5; \n" +
//			"    int f = ; \n" +
//			"    int g = 5 \n" +
			"    public Test(int a) {\n" +
			"        this.b = a;\n" +
			"    }\n" +
			"    static int testMethod(int a) {\n" +
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
			"}\n" +
			"\n" +
			"public static class Main {\n" +
			"\n" +
			"    public void main() {\n" +
			"        int a = 5, b = 2;\n" +
			"        Test t = new Test();\n" +
			"        t.testMethod(a, b);\n" +
			"        return 0;\n" +
			"    }\n" +
			"}"
		);
		
        try {
        	VMInterpreter interpreter = new VMInterpreter(chs);
        	interpreter.run();
		} catch (RecognitionException e) {
			e.printStackTrace();
		} catch (VMParsingException e) {
			System.out.println(e.getMessage());
		}
	}

}

package cz.cvut.fit.mirun.lemavm.tests.core;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.builder.VMBaseStructureBuilder;
import cz.cvut.fit.mirun.lemavm.core.VMUtils;
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
//			"    int b = 5 + 6 * 6 + 2; \n" +
			"    public static string str = \"a\"; \n" +
			"    Test char = a; \n" +
			"    int num = 5; \n" +
			"    double num1 = 5.2; \n" +
			"    int num2; \n" +
//			"    int num1 = 5,2; \n" +
//			"    error static f = 5; \n" +
//			"    f = 5; \n" +
//			"    int f = ; \n" +
//			"    int g = 5 \n" +
			"    public Test(int a) {\n" +
			"        this.b = a;\n" +
			"        return a;\n" +
			"    }\n" +
			"    static int testMethod(int a) {\n" +
			"        if(a == 0){\n" +
			"            a = 1;\n" +
			"        }\n" +
			"        return a;\n" +
			"    }\n" +
			"    public non testMethod2(int a, int b) {\n" +
			"        int c = a + b;\n" +
			"        testMethod(a);\n" +
			"        b = testMethod(a);\n" +
			"        return c;\n" +
			"    }\n" +
			"}\n" +
			"\n" +
			"public static class Main {\n" +
			"\n" +
			"    public void main() {\n" +
			"        int a = 5, b = 2;\n" +
			"        c = 2;\n" +
			"        Test t = new Test();\n" +
			"        t.testMethod(a, b);\n" +
			"        while(a == 5){\n" +
			"            if(a + 5){\n" +
			"                int aa = 5 + 6 * 6 + 2;\n"+
			"            }else{\n" +
			"                a = 5 + 6 * 6 + 2;\n" +
			"            }\n" +
			"        }\n" +
			"        if(a == 5){\n" +
			"            int aa = 5 + 6 * 6 + 2;\n"+
			"            return a;\n"+
			"        }else{\n" +
			"            a = 5 + 6 * 6 + 2;\n" +
			"        }\n" +
			"        for(int ii=0;ii<5;ii++){\n" +
			"            if(a + 5){\n" +
			"                int aa = 5 + 6 * 6 + 2;\n"+
			"            }else{\n" +
			"                a = 5 + 6 * 6 + 2;\n" +
			"            }\n" +
			"        }\n" +
			"        for(ii=0;ii<5;2*ii){\n" +
			"            if(a + 5){\n" +
			"                int aa = 5 + 6 * 6 + 2;\n"+
			"            }else{\n" +
			"                a = 5 + 6 * 6 + 2;\n" +
			"            }\n" +
			"        }\n" +
			"        for(ii;ii;ii){\n" +
			"            if(a + 5){\n" +
			"                int aa = 5 + 6 * 6 + 2;\n"+
			"            }else{\n" +
			"                a = 5 + 6 * 6 + 2;\n" +
			"            }\n" +
			"        }\n" +
			"        for(;;){\n" +
			"            if(a + 5){\n" +
			"                int aa = 5 + 6 * 6 + 2;\n"+
			"            }else{\n" +
			"                a = 5 + 6 * 6 + 2;\n" +
			"            }\n" +
			"        }\n" +
			"        return 0;\n" +
			"    }\n" +
			"}"
		);
		
        try {
        	VMBaseStructureBuilder b = new VMBaseStructureBuilder(chs);
        	b.build();
        	b.printTreeToDot();
		} catch (RecognitionException e) {
			e.printStackTrace();
		} catch (VMParsingException e) {
			System.err.println(e.getMessage());
		}
	}

}

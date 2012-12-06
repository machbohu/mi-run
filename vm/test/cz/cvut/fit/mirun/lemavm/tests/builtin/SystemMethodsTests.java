package cz.cvut.fit.mirun.lemavm.tests.builtin;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.builder.VMCreator;
import cz.cvut.fit.mirun.lemavm.core.VMInterpreter;

public class SystemMethodsTests {
	private static CharStream cs;
	VMInterpreter i = VMInterpreter.getInstance();
	
	@Test
	public void testPrint(){
		cs = new ANTLRStringStream(
			"public class Main {\n" +
			"    public static void main(string[] args) {\n" +
			"        System.print(\"Print!\");\n" +
			"        System.print(5);\n" +
			"        System.print(5.5);\n" +
			"    }\n" +
			"}"
		);
		
    	VMCreator.createBaseStructureFromTree(cs); 
		i.executeApplication(null);
		i.resetVM();
	}
	
	@Test
	public void testPrintln(){
		cs = new ANTLRStringStream(
			"public class Main {\n" +
			"    public static void main(string[] args) {\n" +
			"        System.println(\"Println!\");\n" +
			"    }\n" +
			"}"
		);
		
    	VMCreator.createBaseStructureFromTree(cs); 
		i.executeApplication(null);
		i.resetVM();
	}
	
	@Test
	public void testErrorln(){
		cs = new ANTLRStringStream(
			"public class Main {\n" +
			"    public static void main(string[] args) {\n" +
			"        System.errorln(\"Errorln!\");\n" +
			"    }\n" +
			"}"
		);
		
    	VMCreator.createBaseStructureFromTree(cs); 
		i.executeApplication(null);
		i.resetVM();
	}
}

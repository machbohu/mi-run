package cz.cvut.fit.mirun.lemavm.tests.builtin;

import static org.junit.Assert.assertEquals;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.builder.VMCreator;
import cz.cvut.fit.mirun.lemavm.core.VMInterpreter;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMSystem;
import cz.cvut.fit.mirun.lemavm.tests.TestOutput;

public class SystemMethodsTests {
	private CharStream cs;
	private static VMInterpreter i;
	private static TestOutput out;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		i = VMInterpreter.getInstance();
		out = new TestOutput();
		VMSystem.addObserver(out);
	}
	
	@After
	public void setUpAfterTest(){
		out.clearVals();
		i.resetVM();
	}
	
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
		assertEquals("Print!", out.getVal(0));
		assertEquals("5", out.getVal(1));
		assertEquals("5.5", out.getVal(2));
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
		assertEquals("Println!", out.getVal(0));
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
		assertEquals("Errorln!", out.getVal(0));
	}
}
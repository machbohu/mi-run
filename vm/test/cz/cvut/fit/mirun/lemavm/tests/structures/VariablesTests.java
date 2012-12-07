package cz.cvut.fit.mirun.lemavm.tests.structures;

import static org.junit.Assert.assertEquals;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.core.VirtualMachine;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMSystem;
import cz.cvut.fit.mirun.lemavm.tests.TestOutput;

public class VariablesTests {
	private CharStream cs;
	private static TestOutput out;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		out = new TestOutput();
		VMSystem.addObserver(out);
	}
	
	@After
	public void clearAfterTest(){
		out.clearVals();
		VirtualMachine.reset();
	}
	
	@Test
	public void testStaticVariable(){
		cs = new ANTLRStringStream(
			"public class Test {\n" +
			"    static int a = 10;\n" +
			"    public Test(){\n" +
			"        System.print(a);\n" +
			"    }\n" +
			
			"    public void testMethod(){\n" +
//			"        a--;\n" +
			"        a = a - 1;\n" +
			"        System.print(a);\n" +
			"    }\n" +
			"}\n" +
			
			"public class Main {\n" +
			"    public static void main(string[] args) {\n" +
			"        Test t1 = new Test();\n" +
			"        t1.testMethod();\n" +
			"        t1.testMethod();\n" +
			"        Test t2 = new Test();\n" +
			"        t2.testMethod();\n" +
			"        t2.testMethod();\n" +
			"    }\n" +
			"}"
		);
		
		VirtualMachine.initAndLaunch(cs);

		assertEquals("10", out.getVal(0));
		assertEquals("9", out.getVal(1));
		assertEquals("8", out.getVal(2));
		assertEquals("8", out.getVal(3));
		assertEquals("7", out.getVal(4));
		assertEquals("6", out.getVal(5));
	}
	
	@Test
	public void testInstanceVariable(){
		cs = new ANTLRStringStream(
			"public class Test {\n" +
			"    int a = 10;\n" +
			"    public Test(){\n" +
			"        System.print(a);\n" +
			"    }\n" +
			
			"    public void testMethod(){\n" +
			"        a--;\n" +
			"        a = a - 1;\n" +
			"        System.print(a);\n" +
			"    }\n" +
			"}\n" +
			
			"public class Main {\n" +
			"    public static void main(string[] args) {\n" +
			"        Test t1 = new Test();\n" +
			"        t1.testMethod();\n" +
			"        t1.testMethod();\n" +
			"        Test t2 = new Test();\n" +
			"        t2.testMethod();\n" +
			"        t2.testMethod();\n" +
			"        t1.testMethod();\n" +
			"        t2.testMethod();\n" +
			"    }\n" +
			"}"
		);
		
		VirtualMachine.initAndLaunch(cs);

		assertEquals("10", out.getVal(0));
		assertEquals("8", out.getVal(1));
		assertEquals("6", out.getVal(2));
		assertEquals("10", out.getVal(3));
		assertEquals("8", out.getVal(4));
		assertEquals("6", out.getVal(5));
		assertEquals("4", out.getVal(6));
		assertEquals("4", out.getVal(7));
	}
}

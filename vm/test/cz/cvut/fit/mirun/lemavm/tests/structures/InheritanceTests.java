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

public class InheritanceTests {
	private CharStream cs;
	private static TestOutput out;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		VirtualMachine.reset();
		out = new TestOutput();
		VMSystem.addObserver(out);
	}
	
	@After
	public void setUpAfterTest(){
		out.clearVals();
		VirtualMachine.reset();
	}
	
	@Test
	public void testNew(){
		cs = new ANTLRStringStream(
			"public class TestParent {\n" +
			"    public TestParent(){\n" +
			"        System.print(\"Constructor\");\n" +
			"    }\n" +
			
			"    public void testMethodParent(){\n" +
			"        System.print(\"MethodParent\");\n" +
			"    }\n" +
			"}\n" +
			"public class Test extends TestParent {\n" +
			"    public Test(){\n" +
			"        System.print(\"Constructor\");\n" +
			"    }\n" +
			
			"    public void testMethod(){\n" +
			"        System.print(\"Method\");\n" +
			"    }\n" +
			"}\n" +
			
			"public class Main {\n" +
			"    public static void main(string[] args) {\n" +
			"        Test t = new Test();\n" +
			"        t.testMethodParent();\n" +
			"    }\n" +
			"}"
		);
		
		VirtualMachine.initAndLaunch(cs);

		assertEquals("Constructor", out.getVal(0));
		assertEquals("MethodParent", out.getVal(1));
	}
}

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

public class ReturnTests {
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
	public void testSimpleReturn(){
		cs = new ANTLRStringStream(
			"public class Test {\n" +
			"    public Test(){\n" +
			"    }\n" +
			
			"    public int testMethod(){\n" +
			"        return 5;\n" +
			"    }\n" +
			"}\n" +
			
			"public class Main {\n" +
			"    public static void main(string[] args) {\n" +
			"        Test t = new Test();\n" +
			"        System.print(t.testMethod());\n" +
			"    }\n" +
			"}"
		);
		
		VirtualMachine.initAndLaunch(cs);

		assertEquals("5", out.getVal(0));
	}
}

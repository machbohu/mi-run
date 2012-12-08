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

public class MethodCallTests {
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
	public void testStaticMethodLaunch() {
		cs = new ANTLRStringStream(
			"public static class Main {\n"+
			"    public static void test() {\n"+
			"        System.println(\"test\");\n"+
			"    }\n"+

			"    public static void main(string[] args) {\n"+ 
			"        Main.test();\n" + 
			"    }\n" + 
			"}"
		);

		VirtualMachine.initAndLaunch(cs);
		assertEquals("test", out.getVal(0));
	}
}

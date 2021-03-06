package cz.cvut.fit.mirun.lemavm.tests.core;

import static org.junit.Assert.assertEquals;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.core.VMInterpreter;
import cz.cvut.fit.mirun.lemavm.core.VirtualMachine;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMSystem;
import cz.cvut.fit.mirun.lemavm.tests.TestOutput;

public class WithInlineCacheTests {
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
	public void testWithInlineCache(){
		cs = new ANTLRStringStream(
			"public class Test {\n" +
			"    public Test(int a){\n" +
			"    }\n" +
			
			"    public void testMethod(int a){\n" +
			"        a = a + 1;\n" +
			"    }\n" +
			"}\n" +
			
			"public class Main {\n" +
			"    public static void main(string[] args) {\n" +
			"        int a = 5;\n" +
			"        Test t = new Test(a);\n" +
			"        for(int ii=0;ii<1000000;ii++){\n" +
			"            t.testMethod(a);\n" +
			"        }\n" +
			"    }\n" +
			"}"
		);
		
		long start = System.currentTimeMillis();
		VirtualMachine.initAndLaunch(cs);
		long end = System.currentTimeMillis();
		
		System.out.println("Execution time (ilc) was "+(end-start)+" ms.");
	}
}

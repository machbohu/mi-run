package cz.cvut.fit.mirun.lemavm.tests.structures;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.core.VirtualMachine;
import cz.cvut.fit.mirun.lemavm.core.memory.VMMemoryManager;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMSystem;
import cz.cvut.fit.mirun.lemavm.tests.TestOutput;

public class ForTests {
	private CharStream cs;
	private static TestOutput out;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		VMMemoryManager.resetMemoryManager();
		out = new TestOutput();
		VMSystem.addObserver(out);
	}
	
	@After
	public void setUpAfterTest(){
		out.clearVals();
		VirtualMachine.reset();
	}
	
	@Test
	public void testForTrue(){
		cs = new ANTLRStringStream(
			"public class Main {\n" +
			"    public static void main(string[] args) {\n" +
			"        int b = 0;\n" +
			"        for(int a=0;a < 5;a++){\n" +
			"            b = a;\n" +
			"        }\n" +
			
			"        System.println(b);\n" +
			"    }\n" +
			"}"
		);
		
		VirtualMachine.initAndLaunch(cs);

		assertEquals("4", out.getVal(0));
	}
	
	@Test
	public void testForFalse(){
		cs = new ANTLRStringStream(
			"public class Main {\n" +
			"    public static void main(string[] args) {\n" +
			"        for(int a=0;a > 5;a++){\n" +
			"            a = a + 1;\n" +
			"        }\n" +
			"    }\n" +
			"}"
		);
		
		VirtualMachine.initAndLaunch(cs);

		assertTrue(out.isEmpty());
	}
}

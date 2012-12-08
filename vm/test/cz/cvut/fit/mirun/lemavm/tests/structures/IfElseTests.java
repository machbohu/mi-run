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

public class IfElseTests {
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
	public void testIf(){
		cs = new ANTLRStringStream(
			"public class Main {\n" +
			"    public static void main(string[] args) {\n" +
			"        if(5 == 5){\n" +
			"            System.println(\"if\");\n" +
			"        }\n" +
			"    }\n" +
			"}"
		);
		
		VirtualMachine.initAndLaunch(cs);

		assertEquals("if", out.getVal(0));
	}
	
	@Test
	public void testElse(){
		cs = new ANTLRStringStream(
			"public class Main {\n" +
			"    public static void main(string[] args) {\n" +
			"        if(5 != 5){\n" +
			"            System.println(\"if\");\n" +
			"        }else{\n" +
			"            System.println(\"else\");\n" +
			"        }\n" +
			"    }\n" +
			"}"
		);
		
		VirtualMachine.initAndLaunch(cs);

		assertEquals("else", out.getVal(0));
	}
	
	@Test
	public void testThen(){
		cs = new ANTLRStringStream(
			"public class Main {\n" +
			"    public static void main(string[] args) {\n" +
			"        if(5 != 5){\n" +
			"            System.println(\"if\");\n" +
			"        }\n" +
			"    }\n" +
			"}"
		);
		
		VirtualMachine.initAndLaunch(cs);

		assertTrue(out.isEmpty());
	}
}

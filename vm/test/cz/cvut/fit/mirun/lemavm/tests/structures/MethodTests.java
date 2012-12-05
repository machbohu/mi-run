package cz.cvut.fit.mirun.lemavm.tests.structures;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.builder.VMCreator;
import cz.cvut.fit.mirun.lemavm.core.VMInterpreter;

public class MethodTests {
	private static CharStream cs;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cs = new ANTLRStringStream(
			"public static class Main {\n" +
			"\n" +
			"    public static void main(string[] args) {\n" +
			"    }\n" +
			"}"
		);
		
    	VMCreator.createBaseStructureFromTree(cs); 
	}
	
	@Test
	public void testMainMethodLaunch(){
		VMInterpreter.getInstance().executeApplication(null);
	}
}

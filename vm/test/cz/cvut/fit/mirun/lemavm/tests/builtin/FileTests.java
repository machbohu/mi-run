package cz.cvut.fit.mirun.lemavm.tests.builtin;

import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.core.VirtualMachine;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMSystem;
import cz.cvut.fit.mirun.lemavm.tests.TestOutput;

public class FileTests {
	private CharStream cs;
	private static File tmp;
	private static TestOutput out;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		out = new TestOutput();
		VMSystem.addObserver(out);
		tmp = File.createTempFile("vmfile", ".java");
		System.out.println("Your temp file is " + tmp.getCanonicalPath());
		BufferedWriter bw = new BufferedWriter(new FileWriter(tmp));
	    bw.write("line1");
	    bw.write("line2");
	    bw.write("line3 lorem ipsum       dolor");
	    bw.close();
	}
	
	@AfterClass
	public static void clearAfterClass() {
		tmp.deleteOnExit();
	}
	
	@After
	public void setUpAfterTest(){
		out.clearVals();
		VirtualMachine.reset();
	}
	
	@Test
	public void testFileRead() throws IOException{
		cs = new ANTLRStringStream(
			"public class Main {\n" +
			"    public static void main(string[] args) {\n" +
			"        File f = new File(\""+tmp.getCanonicalPath().toString()+"\");\n" +
			"        \n" +
			"    }\n" +
			"}"
		);
		
		VirtualMachine.initAndLaunch(cs);

		assertEquals("Constructor", out.getVal(0));
		assertEquals("Method", out.getVal(1));
	}
}

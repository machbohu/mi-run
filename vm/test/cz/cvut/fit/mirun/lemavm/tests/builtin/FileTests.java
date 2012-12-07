package cz.cvut.fit.mirun.lemavm.tests.builtin;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.core.VirtualMachine;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMSystem;
import cz.cvut.fit.mirun.lemavm.tests.TestOutput;

public class FileTests {
	private CharStream cs;
	private BufferedReader br;
	private static File tmp;
	private static TestOutput out;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		out = new TestOutput();
		VMSystem.addObserver(out);
	}
	
	@Before
	public void setUpBeforeTest() throws IOException{
		tmp = File.createTempFile("vmfile", ".java");
		br = new BufferedReader(new FileReader(tmp));
	}
	
	@After
	public void clearAfterTest() throws IOException{
		out.clearVals();
		VirtualMachine.reset();
		br.close();
		tmp.deleteOnExit();
	}
	
	@Test
	public void testFileRead() throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(tmp));
	    bw.write("line1\n");
	    bw.write("line2\n");
	    bw.write("line3 lorem ipsum       dolor\n");
	    bw.close();
		
		cs = new ANTLRStringStream(
			"public class Main {\n" +
			"    public static void main(string[] args) {\n" +
			"        File f = new File(\""+tmp.getCanonicalPath().toString()+"\");\n" +
			"        System.println(f.doesFileExist());\n" +
			"        System.println(f.canRead());\n" +
			"        System.println(f.readLine());\n" +
			"        System.println(f.readLine());\n" +
			"        System.println(f.readLine());\n" +
			"        System.println(f.readLine());\n" +
			"        f.close();\n" +
			"        \n" +
			"    }\n" +
			"}"
		);
		
		VirtualMachine.initAndLaunch(cs);

		assertEquals("true", out.getVal(0));
		assertEquals("true", out.getVal(1));
		assertEquals(br.readLine(), out.getVal(2));
		assertEquals(br.readLine(), out.getVal(3));
		assertEquals(br.readLine(), out.getVal(4));
		assertEquals("null", out.getVal(5));
	}
	
	@Test
	public void testFileWrite() throws IOException{
		String filename = tmp.getCanonicalPath().toString();
		
		cs = new ANTLRStringStream(
			"public class Main {\n" +
			"    public static void main(string[] args) {\n" +
			"        File f = new File(\""+filename+"\");\n" +
			"        f.createFile();\n" +
			"        System.println(f.doesFileExist());\n" +
			"        System.println(f.canWrite() && f.canRead());\n" +
			"        f.writeLine(\"Out1\");\n" +
			"        f.writeLine(\"Out2\");\n" +
			"        f.writeLine(\"Out3 lorem ipsum        dolor\");\n" +
			"        f.closeWriter();\n" +
			"        System.println(f.readLine());\n" +
			"        System.println(f.readLine());\n" +
			"        System.println(f.readLine());\n" +
			"        System.println(f.readLine());\n" +
			"        f.closeReader();\n" +
			"        \n" +
			"    }\n" +
			"}"
		);
		
		VirtualMachine.initAndLaunch(cs);

		assertEquals("true", out.getVal(0));
		assertEquals("true", out.getVal(1));
		assertEquals(br.readLine(), out.getVal(2));
		assertEquals(br.readLine(), out.getVal(3));
		assertEquals(br.readLine(), out.getVal(4));
		assertEquals("null", out.getVal(5));
	}
	
	@Test
	public void testFileCreate() throws IOException{
		String filename = tmp.getCanonicalPath().toString();
		tmp.deleteOnExit();

		cs = new ANTLRStringStream(
			"public class Main {\n" +
			"    public static void main(string[] args) {\n" +
			"        File f = new File(\""+filename+"\");\n" +
			"        f.createFile();\n" +
			"        System.println(f.doesFileExist());\n" +
			"        System.println(f.canWrite() && f.canRead());\n" +
			"        f.writeLine(\"Out1\");\n" +
			"        f.writeLine(\"Out2\");\n" +
			"        f.writeLine(\"Out3 lorem ipsum        dolor\");\n" +
			"        f.closeWriter();\n" +
			"        System.println(f.readLine());\n" +
			"        System.println(f.readLine());\n" +
			"        System.println(f.readLine());\n" +
			"        System.println(f.readLine());\n" +
			"        f.closeReader();\n" +
			"        \n" +
			"    }\n" +
			"}"
		);
		
		VirtualMachine.initAndLaunch(cs);

		assertEquals("true", out.getVal(0));
		assertEquals("true", out.getVal(1));
		assertEquals(br.readLine(), out.getVal(2));
		assertEquals(br.readLine(), out.getVal(3));
		assertEquals(br.readLine(), out.getVal(4));
		assertEquals("null", out.getVal(5));
		
		tmp = new File(filename);
	}
}

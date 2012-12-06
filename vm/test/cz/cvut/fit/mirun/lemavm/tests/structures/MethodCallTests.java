package cz.cvut.fit.mirun.lemavm.tests.structures;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.builder.VMCreator;
import cz.cvut.fit.mirun.lemavm.core.VMInterpreter;
import cz.cvut.fit.mirun.lemavm.core.VirtualMachine;

public class MethodCallTests {
	private static CharStream cs;

	@Test
	public void testStaticMethodLaunch() {
		cs = new ANTLRStringStream("public static class Main {\n"
				+ "    public static void test() {\n" + "    }\n" +

				"    public static void main(string[] args) {\n"
				+ "        Main.test();\n" + "    }\n" + "}");

		VirtualMachine.initAndLaunch(cs);
	}
}

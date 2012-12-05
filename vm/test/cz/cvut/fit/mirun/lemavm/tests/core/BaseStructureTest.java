package cz.cvut.fit.mirun.lemavm.tests.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognitionException;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.builder.VMCreator;
import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMNull;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMClass;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMVisibilityModifier;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;

public class BaseStructureTest {
	private static CharStream cs;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cs = new ANTLRStringStream(
			"public class Test {\n" +
			"    string strDef; \n" +
			"    string strNull = null; \n" +
			"    public static string str = \"str\"; \n" +
			"    Test testDef; \n" +
			"    Test test = null; \n" +
			"    int iDef; \n" +
			"    int i = 5; \n" +
			"    long lDef; \n" +
			"    long l = 5; \n" +
			"    short sDef; \n" +
			"    short s = 5; \n" +
			"    double dDef; \n" +
			"    double d = 5.5d; \n" +
			"    boolean bDef; \n" +
			"    boolean b = true; \n" +
			
			"    public Test(int a) {\n" +
			"        this.b = a;\n" +
			"        return a;\n" +
			"    }\n" +
			
			"    static int testMethod(int a) {\n" +
			"    }\n" +
			
			"    private double testMethod(double a) {\n" +
			"    }\n" +
			
			"    public Test testMethod2(int a, int b) {\n" +
			"    }\n" +
			"}\n" +
			"\n" +
			"public static class Main {\n" +
			"\n" +
			"    public void main() {\n" +
			"    }\n" +
			"}"
		);
		
		try {
        	VMCreator.createBaseStructureFromTree(cs); 
		} catch (VMParsingException e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void testClasses(){
		assertTrue(VMClass.getClasses().containsKey("Test"));
		
		assertTrue(VMClass.getClasses().containsKey("Main"));
	}
	
	@Test
	public void testAttrs(){
		VMClass cls = VMClass.getClasses().get("Test");
		assertTrue(cls.getFields().containsKey("strDef"));
		assertTrue(cls.getFields().containsKey("strNull"));
		assertTrue(cls.getFields().containsKey("str"));
		assertTrue(cls.getFields().containsKey("testDef"));
		assertTrue(cls.getFields().containsKey("test"));
		assertTrue(cls.getFields().containsKey("iDef"));
		assertTrue(cls.getFields().containsKey("i"));
		assertTrue(cls.getFields().containsKey("lDef"));
		assertTrue(cls.getFields().containsKey("l"));
		assertTrue(cls.getFields().containsKey("sDef"));
		assertTrue(cls.getFields().containsKey("s"));
		assertTrue(cls.getFields().containsKey("dDef"));
		assertTrue(cls.getFields().containsKey("d"));
		assertTrue(cls.getFields().containsKey("bDef"));
		assertTrue(cls.getFields().containsKey("b"));
		
		assertEquals(VMNull.getInstance(), cls.getFields().get("strDef").getVal());
		assertEquals(VMNull.getInstance(), cls.getFields().get("strNull").getVal());
		assertTrue(cls.getFields().get("str").getVal() instanceof VMString);
		assertTrue(new VMString("str").valueEquals((VMString) cls.getFields().get("str").getVal()));
		assertEquals(VMNull.getInstance(), cls.getFields().get("testDef").getVal());
		assertEquals(VMNull.getInstance(), cls.getFields().get("test").getVal());
		assertEquals(0, cls.getFields().get("iDef").getVal());
		assertEquals(5, cls.getFields().get("i").getVal());
		assertEquals(0L, cls.getFields().get("lDef").getVal());
		assertEquals(5L, cls.getFields().get("l").getVal());
		assertEquals(Short.parseShort("0"), cls.getFields().get("sDef").getVal());
		assertEquals(Short.parseShort("5"), cls.getFields().get("s").getVal());
		assertEquals(0.0d, cls.getFields().get("dDef").getVal());
		assertEquals(5.5d, cls.getFields().get("d").getVal());
		assertEquals(false, cls.getFields().get("bDef").getVal());
		assertEquals(true, cls.getFields().get("b").getVal());
	}
	
	@Test
	public void testMethods(){
		VMClass cls = VMClass.getClasses().get("Test");
		
		assertEquals(1, cls.getDeclaredConstructors().size());
		
		// static int testMethod(int a)
		assertTrue(cls.getMethods().containsKey("testMethod"));
		assertTrue(cls.getMethods().get("testMethod").get(0).getArguments().containsKey("a"));
		assertEquals(VMConstants.INT, cls.getMethods().get("testMethod").get(0).getArguments().get("a"));
		assertEquals(VMConstants.INT, cls.getMethods().get("testMethod").get(0).getReturnType());
		assertEquals(VMVisibilityModifier.PROTECTED, cls.getMethods().get("testMethod").get(0).getVisibility());
		assertEquals(true, cls.getMethods().get("testMethod").get(0).isMethodStatic());
		
		// private double testMethod(double a)
		assertTrue(cls.getMethods().get("testMethod").get(1).getArguments().containsKey("a"));
		assertEquals(VMConstants.DOUBLE, cls.getMethods().get("testMethod").get(1).getArguments().get("a"));
		assertEquals(VMConstants.DOUBLE, cls.getMethods().get("testMethod").get(1).getReturnType());
		assertEquals(VMVisibilityModifier.PRIVATE, cls.getMethods().get("testMethod").get(1).getVisibility());
		assertEquals(false, cls.getMethods().get("testMethod").get(1).isMethodStatic());
		
		// public Test testMethod2(int a, int b)
		assertTrue(cls.getMethods().containsKey("testMethod2"));
		assertTrue(cls.getMethods().get("testMethod2").get(0).getArguments().containsKey("a"));
		assertEquals(VMConstants.INT, cls.getMethods().get("testMethod2").get(0).getArguments().get("a"));
		assertTrue(cls.getMethods().get("testMethod2").get(0).getArguments().containsKey("b"));
		assertEquals(VMConstants.INT, cls.getMethods().get("testMethod2").get(0).getArguments().get("b"));		
		assertEquals("Test", cls.getMethods().get("testMethod2").get(0).getReturnType());
		assertEquals(VMVisibilityModifier.PUBLIC, cls.getMethods().get("testMethod2").get(0).getVisibility());
		assertEquals(false, cls.getMethods().get("testMethod2").get(0).isMethodStatic());
		
		cls = VMClass.getClasses().get("Main");
		
		// public void main()
		assertTrue(cls.getMethods().containsKey("main"));
		assertTrue(cls.getMethods().get("main").get(0).getArguments().isEmpty());
		assertEquals(VMConstants.VOID, cls.getMethods().get("main").get(0).getReturnType());
		assertEquals(VMVisibilityModifier.PUBLIC, cls.getMethods().get("main").get(0).getVisibility());
		assertEquals(false, cls.getMethods().get("main").get(0).isMethodStatic());
	}
}

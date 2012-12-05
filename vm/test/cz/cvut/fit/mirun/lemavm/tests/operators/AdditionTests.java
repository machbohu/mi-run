package cz.cvut.fit.mirun.lemavm.tests.operators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMBinaryPlusOperatorFactory;

public class AdditionTests {

	private static VMBinaryPlusOperatorFactory factory;

	private static VMEnvironment env;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		factory = new VMBinaryPlusOperatorFactory();
	}

	@Before
	public void setUp() throws Exception {
		env = new VMEnvironment();
	}

	@Test
	public void testAddSmple() {
		final int exp = 20; // 8 + 12
		final VMOperator op = factory.createOperator("8", "12");
		final int res = op.evaluateInt(null);
		assertEquals(exp, res);
	}

	@Test
	public void testAddHierarchical() {
		final short exp = 20; // 9 + -1 + 1 + 2 + 9
		final VMOperator op = factory.createOperator("9", factory
				.createOperator(factory.createOperator("-1", "1"),
						factory.createOperator("2", "9")));
		final short res = op.evaluateShort(null);
		assertEquals(exp, res);
	}

	@Test
	public void testAddWithMixedTypes() {
		final double exp = 99.99; // 0.98 + 0.01 - 5 + 104
		final VMOperator op = factory.createOperator(
				factory.createOperator("0.98",
						factory.createOperator("0.01", "-5")), "104L");
		final double res = op.evaluateDouble(null);
		assertTrue(Double.compare(exp, res) == 0);
	}

	@Test
	public void testAddWithZero() {
		final long exp = 0;
		final VMOperator op = factory.createOperator("-100L",
				factory.createOperator("0", "100"));
		final long res = op.evaluateLong(null);
		assertEquals(exp, res);
	}

	@Test
	public void testAddTwoStrings() {
		final String exp = "OneTwo";
		final VMOperator op = factory.createOperator("\"One\"", "\"Two\"");
		final Object res = op.evaluateString(null);
		assertTrue(res instanceof VMString);
		assertEquals(exp, ((VMString) res).getValue());
	}

	@Test
	public void testAddStringAndNumber() {
		final String exp = "One1";
		final VMOperator op = factory.createOperator("\"One\"", "1");
		final Object res = op.evaluate(null);
		assertTrue(res instanceof VMString);
		assertEquals(exp, ((VMString) res).getValue());
	}

	@Test
	public void testAddStringAndOp() {
		final String exp = "One2";
		final VMOperator op = factory.createOperator("\"One\"",
				factory.createOperator("1", "1"));
		final Object res = op.evaluate(null);
		assertTrue(res instanceof VMString);
		assertEquals(exp, ((VMString) res).getValue());
	}

	@Test(expected = NullPointerException.class)
	public void testAddNull() {
		@SuppressWarnings("unused")
		final VMOperator op = factory.createOperator("0.8", (VMOperator) null);
		fail("This line should not have been reached.");
	}

	@Test
	public void testAddNumberAndVariable() {
		final int exp = 20;
		env.addPrimitiveBinding("a", Integer.valueOf(10), "int");
		final VMOperator op = factory.createOperator("a", "10");
		final Object res = op.evaluate(env);
		assertTrue(res instanceof Integer);
		assertEquals(exp, ((Integer) res).intValue());
	}

	@Test
	public void testAddVariables() {
		final int exp = 20;
		env.addPrimitiveBinding("a", Integer.valueOf(10), "int");
		env.addPrimitiveBinding("b", Integer.valueOf(10), "int");
		final VMOperator op = factory.createOperator("a", "b");
		final Object res = op.evaluate(env);
		assertTrue(res instanceof Integer);
		assertEquals(exp, ((Integer) res).intValue());
	}

	@Test
	public void testAddVarsStringAndInt() {
		final String exp = "1010";
		env.addBinding("a", new VMString("10"), "string");
		env.addPrimitiveBinding("b", Integer.valueOf(10), "int");
		final VMOperator op = factory.createOperator("a", "b");
		final Object res = op.evaluate(env);
		assertTrue(res instanceof VMString);
		assertEquals(exp, ((VMString) res).getValue());
	}

	@Test
	public void testAddVarIntAndDouble() {
		final double exp = 13.33;
		env.addPrimitiveBinding("a", Integer.valueOf(10), "int");
		final VMOperator op = factory.createOperator("a", "3.33");
		final Object res = op.evaluateDouble(env);
		assertTrue(res instanceof Double);
		assertEquals(exp, res);
	}

	@Test
	public void testAddMultipleExprs() {
		final String exp = "101010";
		env.addPrimitiveBinding("a", Integer.valueOf(10), "int");
		env.addBinding("b", new VMString("10"), "string");
		final VMOperator op = factory.createOperator("a",
				factory.createOperator("b", factory.createOperator("5", "5")));
		final Object res = op.evaluate(env);
		assertTrue(res instanceof VMString);
		assertEquals(exp, ((VMString) res).getValue());
	}
}

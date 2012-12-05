package cz.cvut.fit.mirun.lemavm.tests.operators;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMMultiplicationOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public class MultiplicationTests {

	private static VMMultiplicationOperatorFactory factory;

	private static VMEnvironment env;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		factory = new VMMultiplicationOperatorFactory();
	}

	@Before
	public void setUp() throws Exception {
		env = new VMEnvironment();
	}

	@Test
	public void testMultiplySimple() {
		final Integer exp = 169;
		final VMOperator op = factory.createOperator("13", "13");
		final Object res = op.evaluate(env);
		assertTrue(res instanceof Integer);
		assertEquals(exp, (Integer) res);
	}

	@Test
	public void testMultiplyMixed() {
		final Double exp = 101.0;
		final VMOperator op = factory.createOperator("10", "10.1");
		final Object res = op.evaluate(env);
		assertTrue(res instanceof Double);
		assertEquals(0, exp.compareTo((Double) res));
	}

	@Test
	public void testMultiplyVariable() {
		final Integer exp = 24;
		env.addPrimitiveFinalBinding("a", Integer.valueOf(4), "int");
		env.addPrimitiveFinalBinding("b", Integer.valueOf(3), "int");
		final VMOperator op = factory.createOperator(
				factory.createOperator("a", "b"),
				factory.createOperator("2", "1"));
		final Object res = op.evaluate(env);
		assertTrue(res instanceof Integer);
		assertEquals(exp, (Integer) res);
	}

	@Test(expected = NullPointerException.class)
	public void testMultiplyNull() {
		@SuppressWarnings("unused")
		final VMOperator op = factory.createOperator("1", null);
		fail("This line should not have been reached.");
	}
}

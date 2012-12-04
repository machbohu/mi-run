package cz.cvut.fit.mirun.lemavm.tests.operators;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMBinaryMinusOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public class SubtractionTests {

	private static VMBinaryMinusOperatorFactory factory;

	private static VMEnvironment env;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		factory = new VMBinaryMinusOperatorFactory();
	}

	@Before
	public void setUp() throws Exception {
		env = new VMEnvironment();
	}

	@Test
	public void testSimpleSubtract() {
		final Integer exp = 0;
		final VMOperator op = factory.createOperator("10", "10");
		final Integer res = op.evaluateInt(env);
		assertEquals(exp, res);
	}

	@Test
	public void testSubtractVariable() {
		final Integer exp = 100;
		env.addPrimitiveFinalBinding("a", Integer.valueOf(100), "int");
		final VMOperator op = factory.createOperator("a", "0");
		final Object res = op.evaluate(env);
		assertTrue(res instanceof Integer);
		assertEquals(exp, (Integer) res);
	}

	@Test
	public void testSubtractDouble() {
		final Double exp = 55.5;
		env.addPrimitiveBinding("a", Double.valueOf(100.0), "double");
		env.addPrimitiveBinding("b", Double.valueOf("44.5"), "double");
		final VMOperator op = factory.createOperator("a", "b");
		final Double res = op.evaluateDouble(env);
		assertEquals(0, exp.compareTo(res));
	}
}

package cz.cvut.fit.mirun.lemavm.tests.operators;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.exceptions.VMDivisionByZeroException;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMDivisionOperatorFactory;

public class DivisionTests {

	private static VMDivisionOperatorFactory factory;

	private static VMEnvironment env;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		factory = new VMDivisionOperatorFactory();
	}

	@Before
	public void setUp() throws Exception {
		env = new VMEnvironment();
	}

	@Test
	public void testDivideSimple() {
		final Integer exp = 2;
		final VMOperator op = factory.createOperator("10", "5");
		final Object res = op.evaluate(env);
		assertTrue(res instanceof Integer);
		assertEquals(exp, (Integer) res);
	}

	@Test(expected = VMDivisionByZeroException.class)
	public void testDivideByZero() {
		final VMOperator op = factory.createOperator(
				factory.createOperator("10", "5"), "0");
		op.evaluate(env);
		fail("This line should not have been reached.");
	}

	@Test
	public void testDivideMixed() {
		final Double exp = 2.6;
		final VMOperator op = factory.createOperator("10.4", "4");
		final Object res = op.evaluate(env);
		assertTrue(res instanceof Double);
		assertEquals(0, exp.compareTo((Double) res));
	}

	@Test
	public void testDivideVariables() {
		final Double exp = 1.0;
		env.addPrimitiveBinding("a", Double.valueOf(10.0), "double");
		env.addPrimitiveFinalBinding("b", Integer.valueOf(5), "int");
		env.addPrimitiveBinding("c", Integer.valueOf(2), "int");
		final VMOperator op = factory.createOperator(
				factory.createOperator("a", "b"), "c");
		final Object res = op.evaluate(env);
		assertTrue(res instanceof Double);
		assertEquals(0, exp.compareTo((Double) res));
	}
}

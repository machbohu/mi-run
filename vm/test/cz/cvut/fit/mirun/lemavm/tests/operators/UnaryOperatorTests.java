package cz.cvut.fit.mirun.lemavm.tests.operators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMFinalBindingExistsException;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMPostfixDecrementOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMPostfixIncrementOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMPrefixDecrementOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMPrefixIncrementOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMUnaryMinusOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMUnaryNegationOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMUnaryPlusOperatorFactory;

public class UnaryOperatorTests {

	private static VMPrefixDecrementOperatorFactory prefDecr;
	private static VMPrefixIncrementOperatorFactory prefIncr;
	private static VMPostfixDecrementOperatorFactory postDecr;
	private static VMPostfixIncrementOperatorFactory postIncr;
	private static VMUnaryMinusOperatorFactory minus;
	private static VMUnaryPlusOperatorFactory plus;
	private static VMUnaryNegationOperatorFactory negation;

	private static VMEnvironment env;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		prefDecr = new VMPrefixDecrementOperatorFactory();
		prefIncr = new VMPrefixIncrementOperatorFactory();
		postDecr = new VMPostfixDecrementOperatorFactory();
		postIncr = new VMPostfixIncrementOperatorFactory();
		minus = new VMUnaryMinusOperatorFactory();
		plus = new VMUnaryPlusOperatorFactory();
		negation = new VMUnaryNegationOperatorFactory();
	}

	@Before
	public void setUp() throws Exception {
		env = new VMEnvironment();
	}

	@Test
	public void testUnaryMinus() {
		final Integer exp = -1;
		final VMOperator op = minus.createOperator("1");
		final Object res = op.evaluate(env);
		assertTrue(res instanceof Integer);
		assertEquals(exp, (Integer) exp);
	}

	@Test
	public void testUnaryMinusVariable() {
		final Double exp = 10.5;
		env.addPrimitiveFinalBinding("a", Double.valueOf(-10.5), "double");
		final VMOperator op = minus.createOperator("a");
		final Object res = op.evaluate(env);
		assertTrue(res instanceof Double);
		assertEquals(0, exp.compareTo((Double) res));
	}

	@Test
	public void testUnaryPlusVariable() {
		final Long exp = -155000L;
		env.addPrimitiveFinalBinding("a", Long.valueOf(-155000L), "long");
		final VMOperator op = plus.createOperator("a");
		final Object res = op.evaluate(env);
		assertTrue(res instanceof Long);
		assertEquals(exp, (Long) res);
	}

	@Test
	public void testNegation() {
		final Boolean exp = Boolean.TRUE;
		final VMOperator op = negation.createOperator("false");
		final Object res = op.evaluate(env);
		assertTrue(res instanceof Boolean);
		assertEquals(exp, (Boolean) res);
	}

	@Test
	public void testVariableNegation() {
		final Boolean exp = Boolean.FALSE;
		env.addPrimitiveBinding("a", Boolean.TRUE, "boolean");
		final VMOperator op = negation.createOperator("a");
		final Object res = op.evaluate(env);
		assertTrue(res instanceof Boolean);
		assertEquals(exp, (Boolean) res);
	}

	@Test(expected = VMEvaluationException.class)
	public void testVariableNegationIncompatibleType() {
		env.addPrimitiveBinding("a", Integer.valueOf(10), "int");
		final VMOperator op = negation.createOperator("a");
		@SuppressWarnings("unused")
		final Object res = op.evaluate(env);
		fail("This line should not have been reached.");
	}

	@Test
	public void testPrefixDecrement() {
		final Integer exp = 0;
		env.addPrimitiveBinding("a", Integer.valueOf(1), "int");
		final VMOperator op = prefDecr.createOperator("a");
		final Object res = op.evaluate(env);
		assertTrue(res instanceof Integer);
		assertEquals(exp, (Integer) res);
		final Integer i = env.getBinding("a", Integer.class);
		assertEquals(exp, i);
	}

	@Test
	public void testPostfixDecrement() {
		final Integer exp = 1;
		final Integer expEnv = 0;
		env.addPrimitiveBinding("a", Integer.valueOf(1), "int");
		final VMOperator op = postDecr.createOperator("a");
		final Object res = op.evaluate(env);
		assertTrue(res instanceof Integer);
		assertEquals(exp, (Integer) res);
		final Integer i = env.getBinding("a", Integer.class);
		assertEquals(expEnv, i);
	}

	@Test
	public void testPrefixIncrement() {
		final Integer exp = 2;
		env.addPrimitiveBinding("a", Integer.valueOf(1), "int");
		final VMOperator op = prefIncr.createOperator("a");
		final Object res = op.evaluate(env);
		assertTrue(res instanceof Integer);
		assertEquals(exp, (Integer) res);
	}

	@Test
	public void testPostfixIncrement() {
		final Integer exp = 1;
		final Integer envExp = 2;
		env.addPrimitiveBinding("a", Integer.valueOf(1), "int");
		final VMOperator op = postIncr.createOperator("a");
		final Object res = op.evaluate(env);
		assertTrue(res instanceof Integer);
		assertEquals(exp, (Integer) res);
		final Integer i = env.getBinding("a", Integer.class);
		assertEquals(envExp, i);
	}

	@Test(expected = VMFinalBindingExistsException.class)
	public void testPostfixIncrementOnFinal() {
		env.addPrimitiveFinalBinding("a", Integer.valueOf(1), "int");
		final VMOperator op = postIncr.createOperator("a");
		@SuppressWarnings("unused")
		final Object res = op.evaluate(env);
		fail("This line should not have been reached.");
	}
}

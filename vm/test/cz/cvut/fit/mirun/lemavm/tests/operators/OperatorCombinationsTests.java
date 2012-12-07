package cz.cvut.fit.mirun.lemavm.tests.operators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMBinaryMinusOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMBinaryOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMBinaryPlusOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMDivisionOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMMultiplicationOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMPostfixDecrementOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMPostfixIncrementOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMPrefixDecrementOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMPrefixIncrementOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMUnaryMinusOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMUnaryNegationOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMUnaryOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMUnaryPlusOperatorFactory;

@SuppressWarnings("unused")
public class OperatorCombinationsTests {

	private static VMBinaryOperatorFactory minusFactory;
	private static VMBinaryOperatorFactory plusFactory;
	private static VMBinaryOperatorFactory divisionFactory;
	private static VMBinaryOperatorFactory multiplicationFactory;
	private static VMUnaryOperatorFactory postfixDecrementFactory;
	private static VMUnaryOperatorFactory postfixIncrementFactory;
	private static VMUnaryOperatorFactory prefixDecrementFactory;
	private static VMUnaryOperatorFactory prefixIncrementFactory;
	private static VMUnaryOperatorFactory unaryMinusFactory;
	private static VMUnaryOperatorFactory unaryPlusFactory;
	private static VMUnaryOperatorFactory unaryNegationFactory;

	private static VMEnvironment env;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		minusFactory = new VMBinaryMinusOperatorFactory();
		plusFactory = new VMBinaryPlusOperatorFactory();
		divisionFactory = new VMDivisionOperatorFactory();
		multiplicationFactory = new VMMultiplicationOperatorFactory();
		postfixDecrementFactory = new VMPostfixDecrementOperatorFactory();
		postfixIncrementFactory = new VMPostfixIncrementOperatorFactory();
		prefixDecrementFactory = new VMPrefixDecrementOperatorFactory();
		prefixIncrementFactory = new VMPrefixIncrementOperatorFactory();
		unaryMinusFactory = new VMUnaryMinusOperatorFactory();
		unaryPlusFactory = new VMUnaryPlusOperatorFactory();
		unaryNegationFactory = new VMUnaryNegationOperatorFactory();
	}

	@Before
	public void setUp() throws Exception {
		env = new VMEnvironment();
	}

	@Test
	public void testPlusMinusPrefixIncr() {
		final Integer exp = 100; // 115 + (++a - b)
		final Integer envExp = 5;
		env.addPrimitiveBinding("a", Integer.valueOf(4), "int");
		env.addPrimitiveBinding("b", Integer.valueOf(20), "int");
		final VMOperator op = plusFactory.createOperator(
				"115",
				minusFactory.createOperator(
						prefixIncrementFactory.createOperator("a"), "b"));
		final Object res = op.evaluate(env);
		assertTrue(res instanceof Integer);
		assertEquals(exp, (Integer) res);
		final Integer a = env.getBinding("a", Integer.class);
		assertEquals(envExp, a);
	}

	@Test
	public void testPlusStringMultiply() {
		final String exp = "20 Test"; // a*b + " " + s
		env.addFinalBinding("s", new VMString("Test"), "string");
		env.addPrimitiveFinalBinding("a", Integer.valueOf(4), "int");
		env.addPrimitiveFinalBinding("b", Long.valueOf(5), "long");
		final VMOperator op = plusFactory.createOperator(
				multiplicationFactory.createOperator("a", "b"),
				plusFactory.createOperator("\" \"", "s"));
		final Object res = op.evaluate(env);
		assertTrue(res instanceof VMString);
		assertEquals(exp, ((VMString) res).getValue());
	}

	@Test
	public void testPlusStringNegation() {
		final String exp = "Test false"; // s + " " + !b
		env.addBinding("s", new VMString("Test"), "string");
		env.addPrimitiveFinalBinding("b", Boolean.TRUE, "boolean");
		final VMOperator op = plusFactory.createOperator(
				"s",
				plusFactory.createOperator("\" \"",
						unaryNegationFactory.createOperator("b")));
		final Object res = op.evaluate(env);
		assertTrue(res instanceof VMString);
		assertEquals(exp, ((VMString) res).getValue());
	}

	@Test
	public void testMinusDivisionPostfixDecrement() {
		final Double exp = 12.5; // c - b / a--
		final Integer envExp = 3;
		env.addPrimitiveBinding("a", Integer.valueOf(4), "int");
		env.addPrimitiveBinding("b", Double.valueOf(10.0), "double");
		env.addPrimitiveFinalBinding("c", Long.valueOf(15), "long");
		final VMOperator op = minusFactory.createOperator(
				"c",
				divisionFactory.createOperator("b",
						postfixDecrementFactory.createOperator("a")));
		final Object res = op.evaluate(env);
		assertTrue(res instanceof Double);
		assertEquals(0, exp.compareTo((Double) res));
		final Integer a = env.getBinding("a", Integer.class);
		assertEquals(envExp, a);
	}
}

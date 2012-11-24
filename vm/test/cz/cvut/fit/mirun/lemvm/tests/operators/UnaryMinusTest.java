package cz.cvut.fit.mirun.lemvm.tests.operators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.core.VMNullPointerException;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMUnaryMinus;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMDouble;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMInteger;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMShort;

public class UnaryMinusTest {

	private static VMShort testShort;
	private static VMDouble testDouble;
	private static VMInteger testInteger;
	private static VMInteger negInt;

	private static VMUnaryMinus minus;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testShort = new VMShort(123);
		testDouble = new VMDouble(113.5d);
		testInteger = new VMInteger(458028);
		negInt = new VMInteger(-3813123);
	}

	@Test
	public void testEvaluateShort() {
		final short exp = (short) -testShort.getValue();
		minus = new VMUnaryMinus(testShort);
		final VMShort res = (VMShort) minus.evaluate();
		assertNotNull(minus);
		assertEquals(exp, res.getValue());
	}

	@Test
	public void testEvaluateDouble() {
		final double exp = -testDouble.getValue();
		minus = new VMUnaryMinus(testDouble);
		final VMDouble res = (VMDouble) minus.evaluate();
		assertNotNull(res);
		assertEquals(0, Double.compare(exp, res.getValue()));
	}

	@Test
	public void testEvaluateInteger() {
		final int exp = -testInteger.getValue();
		minus = new VMUnaryMinus(testInteger);
		final VMInteger res = (VMInteger) minus.evaluate();
		assertNotNull(res);
		assertEquals(exp, res.getValue());
	}

	@Test
	public void testEvaluateNegativeInteger() {
		final int exp = Math.abs(negInt.getValue());
		minus = new VMUnaryMinus(negInt);
		final VMInteger res = (VMInteger) minus.evaluate();
		assertNotNull(res);
		assertEquals(exp, res.getValue());
	}

	@Test(expected = VMNullPointerException.class)
	public void testConstructor() {
		minus = new VMUnaryMinus(null);
		fail("This line should not have been reached.");
	}
}

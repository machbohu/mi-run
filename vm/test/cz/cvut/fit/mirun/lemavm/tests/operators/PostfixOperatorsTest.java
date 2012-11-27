package cz.cvut.fit.mirun.lemavm.tests.operators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMPostfixDecrement;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMPostfixIncrement;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMInteger;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMLong;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMShort;

public class PostfixOperatorsTest {

	private static VMShort shortTest;
	private static VMInteger intTest;
	private static VMLong longTest;

	private static VMPostfixIncrement increment;
	private static VMPostfixDecrement decrement;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		shortTest = new VMShort(4442);
		intTest = new VMInteger(Integer.MIN_VALUE);
		longTest = new VMLong(9282338L);
	}

	@Test
	public void testIncrementShort() {
		final short expRes = shortTest.getValue();
		final short expAfter = (short) (expRes + 1);
		increment = new VMPostfixIncrement(shortTest);
		final VMShort res = (VMShort) increment.evaluate();
		assertNotNull(res);
		assertEquals(expRes, res.getValue());
		assertEquals(expAfter, shortTest.getValue());
	}

	@Test
	public void testIncrementLong() {
		final long expRes = longTest.getValue();
		final long expAfter = expRes + 1L;
		increment = new VMPostfixIncrement(longTest);
		final VMObject res = increment.evaluate();
		assertNotNull(res);
		assertTrue(res instanceof VMLong);
		assertEquals(expRes, ((VMLong) res).getValue());
		assertEquals(expAfter, longTest.getValue());
	}

	@Test
	public void testDecrementInteger() {
		final int expRes = intTest.getValue();
		final int expAfter = expRes - 1;
		decrement = new VMPostfixDecrement(intTest);
		final VMInteger res = (VMInteger) decrement.evaluate();
		assertNotNull(res);
		assertEquals(expRes, res.getValue());
		assertEquals(expAfter, intTest.getValue());
	}

}

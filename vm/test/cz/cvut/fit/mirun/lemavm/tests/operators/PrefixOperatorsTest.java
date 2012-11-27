package cz.cvut.fit.mirun.lemavm.tests.operators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.exceptions.VMNullPointerException;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMPrefixDecrement;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMPrefixIncrement;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMInteger;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMLong;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMShort;

public class PrefixOperatorsTest {

	private static VMShort shortTest;
	private static VMInteger intTest;
	private static VMLong longTest;

	private static VMPrefixIncrement increment;
	private static VMPrefixDecrement decrement;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		shortTest = new VMShort("31432");
		intTest = new VMInteger(Integer.MAX_VALUE);
		longTest = new VMLong(Long.MAX_VALUE);
	}

	@Test
	public void testIncrementInt() {
		final int exp = intTest.getValue() + 1;
		increment = new VMPrefixIncrement(intTest);
		final VMInteger res = (VMInteger) increment.evaluate();
		assertNotNull(res);
		assertEquals(exp, res.getValue());
		assertEquals(exp, intTest.getValue());
	}

	@Test
	public void testDecrementShort() {
		final short exp = (short) (shortTest.getValue() - 1);
		decrement = new VMPrefixDecrement(shortTest);
		final VMShort res = (VMShort) decrement.evaluate();
		assertNotNull(res);
		assertEquals(exp, res.getValue());
		assertEquals(exp, shortTest.getValue());
	}

	@Test
	public void testDecrementLong() {
		final long exp = longTest.getValue() - 1L;
		decrement = new VMPrefixDecrement(longTest);
		final VMLong res = (VMLong) decrement.evaluate();
		assertNotNull(res);
		assertEquals(exp, res.getValue());
		assertEquals(exp, longTest.getValue());
	}

	@Test(expected = VMNullPointerException.class)
	public void testConstructor() {
		increment = new VMPrefixIncrement(null);
		fail("This line should not have been reached.");
	}
}

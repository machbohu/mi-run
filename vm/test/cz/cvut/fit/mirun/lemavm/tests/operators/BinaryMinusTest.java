package cz.cvut.fit.mirun.lemavm.tests.operators;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.structures.operators.VMBinaryMinus;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMDouble;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMInteger;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMLong;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMNumber;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMShort;

public class BinaryMinusTest {

	private static VMShort sOne;
	private static VMInteger iOne;
	private static VMInteger iTwo;
	private static VMLong lOne;
	private static VMDouble dOne;

	private static VMBinaryMinus minus;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sOne = new VMShort(1);
		iOne = new VMInteger(-3231);
		iTwo = new VMInteger(3231);
		lOne = new VMLong(553432L);
		dOne = new VMDouble(222.004);
	}

	@Test
	public void testSubShortAndInt() {
		final int exp = sOne.getValue() - iOne.getValue();
		minus = new VMBinaryMinus(sOne, iOne);
		final VMNumber res = (VMNumber) minus.evaluate();
		assertNotNull(res);
		assertTrue(res instanceof VMInteger);
		assertEquals(exp, res.intValue());
	}

	@Test
	public void testSubIntegers() {
		final int exp = iTwo.getValue() - iOne.getValue();
		minus = new VMBinaryMinus(iTwo, iOne);
		final VMInteger res = (VMInteger) minus.evaluate();
		assertNotNull(res);
		assertEquals(exp, res.getValue());
	}

	@Test
	public void testSubDoubleAndLong() {
		final double exp = lOne.getValue() - dOne.getValue();
		minus = new VMBinaryMinus(lOne, dOne);
		final VMNumber res = (VMNumber) minus.evaluate();
		assertTrue(res instanceof VMDouble);
		assertEquals(0, Double.compare(exp, res.doubleValue()));
	}
}

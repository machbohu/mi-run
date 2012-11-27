package cz.cvut.fit.mirun.lemvm.tests.operators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.exceptions.VMDivisionByZeroException;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMBinaryDivision;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMBinaryModulo;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMBinaryMultiplication;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMDouble;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMInteger;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMLong;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMNumber;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMShort;

public class BinaryMultiplicationAndDivisionTest {

	private static VMShort sOne;
	private static VMInteger iOne;
	private static VMLong lOne;
	private static VMDouble dOne;
	private static VMDouble dTwo;

	private static VMBinaryMultiplication times;
	private static VMBinaryDivision divide;
	private static VMBinaryModulo modulo;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sOne = new VMShort(0);
		iOne = new VMInteger(Integer.MAX_VALUE);
		lOne = new VMLong(-31231L);
		dOne = new VMDouble(20.0);
		dTwo = new VMDouble(33.33);
	}

	@Test
	public void testDivideShortByInt() {
		final int exp = sOne.getValue() / iOne.getValue();
		divide = new VMBinaryDivision(sOne, iOne);
		final VMInteger res = (VMInteger) divide.evaluate();
		assertNotNull(res);
		assertEquals(exp, res.getValue());
	}

	@Test
	public void testMultiplyIntAndLong() {
		final long exp = iOne.getValue() * lOne.getValue();
		times = new VMBinaryMultiplication(iOne, lOne);
		final VMNumber res = (VMNumber) times.evaluate();
		assertNotNull(res);
		assertTrue(res instanceof VMLong);
		assertEquals(exp, res.longValue());
	}

	@Test
	public void testDivideDoubles() {
		final double exp = dOne.getValue() / dTwo.getValue();
		divide = new VMBinaryDivision(dOne, dTwo);
		final VMDouble res = (VMDouble) divide.evaluate();
		assertNotNull(res);
		assertEquals(0, Double.compare(exp, res.getValue()));
	}

	@Test(expected = VMDivisionByZeroException.class)
	public void testDivideByZero() {
		divide = new VMBinaryDivision(dOne, sOne);
		divide.evaluate();
		fail("This line should not have been reached.");
	}

	@Test
	public void testModulo() {
		final long exp = lOne.getValue() % iOne.getValue();
		modulo = new VMBinaryModulo(lOne, iOne);
		final VMLong res = (VMLong) modulo.evaluate();
		assertNotNull(res);
		assertEquals(exp, res.getValue());
		assertTrue(res.getValue() < 0);
	}
}

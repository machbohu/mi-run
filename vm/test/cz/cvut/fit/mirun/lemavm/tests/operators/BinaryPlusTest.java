package cz.cvut.fit.mirun.lemavm.tests.operators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.exceptions.VMNullPointerException;
import cz.cvut.fit.mirun.lemavm.structures.Printable;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMBinaryPlus;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMDouble;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMInteger;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMLong;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMNumber;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMShort;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

public class BinaryPlusTest {

	private static VMShort sOne;
	private static VMShort sTwo;
	private static VMInteger iOne;
	private static VMLong lOne;
	private static VMDouble dOne;
	private static VMString strOne;

	private static VMBinaryPlus plus;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sOne = new VMShort(154);
		sTwo = new VMShort(4444);
		iOne = new VMInteger(55678);
		lOne = new VMLong(80423423424L);
		dOne = new VMDouble(534324.434);
		strOne = new VMString("testString");
	}

	@Test
	public void testAddShorts() {
		final short exp = (short) (sOne.getValue() + sTwo.getValue());
		plus = new VMBinaryPlus(sOne, sTwo);
		final VMShort res = (VMShort) plus.evaluate();
		assertNotNull(res);
		assertEquals(exp, res.getValue());
	}

	@Test
	public void testAddShortAndInt() {
		final int exp = sOne.getValue() + iOne.getValue();
		plus = new VMBinaryPlus(sOne, iOne);
		final VMNumber res = (VMNumber) plus.evaluate();
		assertNotNull(res);
		assertTrue(res instanceof VMInteger);
		assertEquals(exp, res.intValue());
	}

	@Test
	public void testAddIntAndLong() {
		final long exp = iOne.getValue() + lOne.getValue();
		plus = new VMBinaryPlus(iOne, lOne);
		final VMNumber res = (VMNumber) plus.evaluate();
		assertNotNull(res);
		assertTrue(res instanceof VMLong);
		assertEquals(exp, res.longValue());
	}

	@Test
	public void testAddDouble() {
		final double exp = dOne.getValue() + dOne.getValue();
		plus = new VMBinaryPlus(dOne, dOne);
		final VMNumber res = (VMNumber) plus.evaluate();
		assertNotNull(res);
		assertTrue(res instanceof VMDouble);
		assertEquals(0, Double.compare(exp, res.doubleValue()));
	}

	@Test
	public void testAddStrings() {
		final String exp = strOne.getValue().concat(strOne.getValue());
		plus = new VMBinaryPlus(strOne, strOne);
		final VMObject res = plus.evaluate();
		assertNotNull(res);
		assertTrue(res instanceof VMString);
		assertEquals(exp, ((Printable) res).printValue());
	}

	@Test
	public void testAddMixed() {
		final String exp = strOne.getValue() + iOne.printValue();
		plus = new VMBinaryPlus(strOne, iOne);
		final VMObject res = plus.evaluate();
		assertNotNull(res);
		assertTrue(res instanceof VMString);
		assertEquals(exp, ((Printable) res).printValue());
	}

	@Test(expected = VMNullPointerException.class)
	public void testConstructor() {
		plus = new VMBinaryPlus(null, strOne);
		fail("This line should not have been reached.");
	}
}

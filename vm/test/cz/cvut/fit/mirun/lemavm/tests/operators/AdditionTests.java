package cz.cvut.fit.mirun.lemavm.tests.operators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.structures.operators.VMBinaryPlusOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public class AdditionTests {

	private static VMBinaryPlusOperatorFactory factory;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		factory = new VMBinaryPlusOperatorFactory();
	}

	@Test
	public void testAddSmple() {
		final int exp = 20; // 8 + 12
		final VMOperator op = factory.createOperator(8, 12);
		final int res = op.evaluateInt(null);
		assertEquals(exp, res);
	}

	@Test
	public void testAddHierarchical() {
		final short exp = 20; // 9 + -1 + 1 + 2 + 9
		final VMOperator op = factory.createOperator(
				9,
				factory.createOperator(factory.createOperator(-1, 1),
						factory.createOperator(2, 9)));
		final short res = op.evaluateShort(null);
		assertEquals(exp, res);
	}

	@Test
	public void testAddWithMixedTypes() {
		final double exp = 99.99; // 0.98 + 0.01 - 5 + 104
		final VMOperator op = factory.createOperator(
				factory.createOperator(0.98, factory.createOperator(0.01, -5)),
				104L);
		final double res = op.evaluateDouble(null);
		assertTrue(Double.compare(exp, res) == 0);
	}

	@Test
	public void testAddWithZero() {
		final long exp = 0;
		final VMOperator op = factory.createOperator(-100L,
				factory.createOperator(0, 100));
		final long res = op.evaluateLong(null);
		assertEquals(exp, res);
	}

	@Test(expected = NullPointerException.class)
	public void testAddNull() {
		@SuppressWarnings("unused")
		final VMOperator op = factory.createOperator(0.8, (VMOperator) null);
		fail("This line should not have been reached.");
	}
}

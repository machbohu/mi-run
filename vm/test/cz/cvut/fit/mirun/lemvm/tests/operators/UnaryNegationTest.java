package cz.cvut.fit.mirun.lemvm.tests.operators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.structures.operators.VMUnaryNegation;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMBoolean;

public class UnaryNegationTest {

	private static VMBoolean t;
	private static VMBoolean f;

	private static VMUnaryNegation negation;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		t = VMBoolean.valueOf("true");
		f = VMBoolean.valueOf("false");
	}

	@Test
	public void testVMUnaryNegation() {
		final boolean exp = !(t.getValue());
		negation = new VMUnaryNegation(t);
		final VMBoolean res = (VMBoolean) negation.evaluate();
		assertNotNull(res);
		assertEquals(exp, res.getValue());
	}

	@Test
	public void testAssertSingleton() {
		final boolean exp = !(f.getValue());
		negation = new VMUnaryNegation(f);
		final VMBoolean resOne = (VMBoolean) negation.evaluate();
		assertNotNull(resOne);
		assertEquals(exp, resOne.getValue());
		final VMBoolean resTwo = (VMBoolean) negation.evaluate();
		assertNotNull(resTwo);
		assertTrue(resOne == resTwo);
	}

	@Test(expected = NullPointerException.class)
	public void testConstructor() {
		negation = new VMUnaryNegation(null);
	}

}

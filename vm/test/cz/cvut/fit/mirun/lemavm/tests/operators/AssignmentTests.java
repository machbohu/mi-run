package cz.cvut.fit.mirun.lemavm.tests.operators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.assignment.AssignOperatorFactory;
import cz.cvut.fit.mirun.lemavm.assignment.VMAssignOperator;
import cz.cvut.fit.mirun.lemavm.core.memory.VMMemoryManager;
import cz.cvut.fit.mirun.lemavm.exceptions.VMFinalBindingExistsException;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.structures.operators.control.VMEqualsOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMBinaryPlusOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMMultiplicationOperatorFactory;

public class AssignmentTests {

	private static AssignOperatorFactory factory;
	private static VMBinaryPlusOperatorFactory plusFactory;
	private static VMMultiplicationOperatorFactory multiplyFactory;
	private static VMEqualsOperatorFactory equalsFactory;

	private static VMEnvironment env;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		VMMemoryManager.resetMemoryManager();
		factory = new AssignOperatorFactory();
		plusFactory = new VMBinaryPlusOperatorFactory();
		multiplyFactory = new VMMultiplicationOperatorFactory();
		equalsFactory = new VMEqualsOperatorFactory();
	}

	@Before
	public void setUp() throws Exception {
		env = new VMEnvironment();
	}

	@Test
	public void testSimpleAssignment() {
		final Integer exp = 10;
		final VMAssignOperator op = factory.createOperator("a", "int", false,
				"10");
		op.evaluate(env);
		final Integer res = env.getBinding("a", Integer.class);
		assertNotNull(res);
		assertEquals(exp, res);
	}

	@Test
	public void testSimpleStringAssignment() {
		final String exp = "test";
		final VMAssignOperator op = factory.createOperator("a", "string", true,
				new VMString("test"));
		op.evaluate(env);
		final VMString res = env.getBinding("a", VMString.class);
		assertNotNull(res);
		assertEquals(exp, res.getValue());
	}

	@Test
	public void testAssignToExisting() {
		final String exp = "newTest";
		env.addBinding("a", new VMString("test"), "string");
		final VMAssignOperator op = factory.createOperator("a", null, false,
				new VMString("newTest"));
		op.evaluate(env);
		final VMString res = env.getBinding("a", VMString.class);
		assertNotNull(res);
		assertEquals(exp, res.getValue());
	}

	@Test(expected = VMFinalBindingExistsException.class)
	public void testAssignToExistingFinal() {
		env.addFinalBinding("a", new VMString("test"), "string");
		final VMAssignOperator op = factory.createOperator("a", null, false,
				new VMString("newTest"));
		op.evaluate(env);
		fail("This line should not have been reached.");
	}

	@Test
	public void testAssignExpressionResult() {
		final Integer exp = 20; // c = 10 + a * b
		env.addPrimitiveBinding("a", Integer.valueOf(5), "int");
		env.addPrimitiveFinalBinding("b", Integer.valueOf(2), "int");
		final VMOperator expr = plusFactory.createOperator("10",
				multiplyFactory.createOperator("a", "b"));
		final VMAssignOperator op = factory.createOperator("c", "int", true,
				expr);
		op.evaluate(env);
		final Integer res = env.getBinding("c", Integer.class);
		assertNotNull(res);
		assertEquals(exp, res);
	}

	@Test
	public void testAssignBooleanExpressionResult() {
		final Boolean exp = Boolean.TRUE; // b = a == true
		env.addPrimitiveFinalBinding("a", Boolean.TRUE, "boolean");
		final VMOperator expr = equalsFactory.createOperator("a", "true");
		final VMAssignOperator op = factory.createOperator("b", "boolean",
				false, expr);
		op.evaluate(env);
		final Boolean res = env.getBinding("b", Boolean.class);
		assertNotNull(res);
		assertEquals(exp, res);
	}

	@Test
	public void testAssignStringExpressionResult() {
		final String exp = "Test false"; // d = c + " " + a == b
		env.addPrimitiveBinding("a", Integer.valueOf(5), "int");
		env.addPrimitiveFinalBinding("b", Integer.valueOf(7), "int");
		env.addFinalBinding("c", new VMString("Test"), "string");
		final VMOperator expr = plusFactory.createOperator(
				plusFactory.createOperator("c", "\" \""),
				equalsFactory.createOperator("a", "b"));
		final VMAssignOperator op = factory.createOperator("d", "string", true,
				expr);
		op.evaluate(env);
		final VMString res = env.getBinding("d", VMString.class);
		assertNotNull(res);
		assertEquals(exp, res.getValue());
	}
}

package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.core.VMNullPointerException;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;

public abstract class VMBinaryOperator extends VMOperator {

	private final VMObject operandOne;
	private final VMObject operandTwo;

	public VMBinaryOperator(VMObject operandOne, VMObject operandTwo) {
		super();
		if (operandOne == null) {
			throw new VMNullPointerException("Operand one is null.");
		}
		if (operandTwo == null) {
			throw new VMNullPointerException("Operand two is null.");
		}
		this.operandOne = operandOne;
		this.operandTwo = operandTwo;
	}

	@Override
	public VMObject evaluate() {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Evaluating binary operator.");
		}
		final VMObject opOneRes = operandOne.evaluate();
		final VMObject opTwoRes = operandTwo.evaluate();
		assert opOneRes != null;
		assert opTwoRes != null;
		return evaluateImpl(opOneRes, opTwoRes);
	}

	/**
	 * Evaluate this operator. </p>
	 * 
	 * @param opOne
	 *            First operand
	 * @param opTwo
	 *            Second operand
	 * @return Result of the evaluation
	 */
	protected abstract VMObject evaluateImpl(VMObject opOne, VMObject opTwo);
}

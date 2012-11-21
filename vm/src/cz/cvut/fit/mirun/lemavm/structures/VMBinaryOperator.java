package cz.cvut.fit.mirun.lemavm.structures;

public abstract class VMBinaryOperator extends VMOperator {

	private final VMObject operandOne;
	private final VMObject operandTwo;

	public VMBinaryOperator(VMObject operandOne, VMObject operandTwo) {
		super();
		this.operandOne = operandOne;
		this.operandTwo = operandTwo;
	}

	@Override
	public VMObject evaluate() {
		final VMObject opOneRes = operandOne.evaluate();
		final VMObject opTwoRes = operandTwo.evaluate();
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

package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.structures.VMObject;

public abstract class VMUnaryOperator extends VMOperator {

	private final VMObject operand;

	public VMUnaryOperator(VMObject operand) {
		super();
		if (operand == null) {
			throw new NullPointerException("Operand is null.");
		}
		this.operand = operand;
	}

	@Override
	public VMObject evaluate() {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Evaluating unary operator.");
		}
		final VMObject op = operand.evaluate();
		assert op != null;
		return evaulateImpl(op);
	}

	/**
	 * Evaluate this operator. </p>
	 * 
	 * @param op
	 *            The operand
	 * @return Result of the evaluation
	 */
	protected abstract VMObject evaulateImpl(VMObject op);
}

package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.core.VMNullPointerException;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMNull;

public abstract class VMUnaryOperator extends VMOperator {

	private final VMObject operand;

	public VMUnaryOperator(VMObject operand) {
		super();
		if (operand == null) {
			throw new VMNullPointerException("Operand is null.");
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
		if (op.equals(VMNull.getInstance())) {
			throw new VMNullPointerException();
		}
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

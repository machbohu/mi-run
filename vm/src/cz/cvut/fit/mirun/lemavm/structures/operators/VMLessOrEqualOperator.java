package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMBoolean;

public final class VMLessOrEqualOperator extends VMBinaryOperator {

	private final VMLessThanOperator less;
	private final VMEqualsOperator equals;

	public VMLessOrEqualOperator(VMObject operandOne, VMObject operandTwo) {
		super(operandOne, operandTwo);
		this.less = new VMLessThanOperator(operandOne, operandTwo);
		this.equals = new VMEqualsOperator(operandOne, operandTwo);
	}

	@Override
	protected VMBoolean evaluateImpl(VMObject opOne, VMObject opTwo) {
		if (LOG.isTraceEnabled()) {
			LOG.trace("Less than or equal operator evaluating: " + opOne
					+ " <= " + opTwo);
		}
		final VMBoolean lt = (VMBoolean) less.evaluate();
		final VMBoolean eq = (VMBoolean) equals.evaluate();
		final boolean lq = lt.getValue() || eq.getValue();
		return (VMBoolean.valueOf(lq));
	}
}

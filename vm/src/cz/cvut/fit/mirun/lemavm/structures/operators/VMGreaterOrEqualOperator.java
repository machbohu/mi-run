package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMBoolean;

public final class VMGreaterOrEqualOperator extends VMBinaryOperator {

	private final VMLessThanOperator less;

	public VMGreaterOrEqualOperator(VMObject operandOne, VMObject operandTwo) {
		super(operandOne, operandTwo);
		this.less = new VMLessThanOperator(operandOne, operandTwo);
	}

	@Override
	protected VMObject evaluateImpl(VMObject opOne, VMObject opTwo) {
		if (LOG.isTraceEnabled()) {
			LOG.trace("Greater than or equal operator evaluating: " + opOne
					+ " >= " + opTwo);
		}
		final VMBoolean lt = (VMBoolean) less.evaluate();
		return VMBoolean.valueOf(!lt.getValue());
	}
}

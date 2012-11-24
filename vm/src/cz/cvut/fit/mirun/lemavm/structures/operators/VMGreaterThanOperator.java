package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMBoolean;

public final class VMGreaterThanOperator extends VMBinaryOperator {

	private final VMLessThanOperator less;
	private final VMEqualsOperator equals;

	public VMGreaterThanOperator(VMObject operandOne, VMObject operandTwo) {
		super(operandOne, operandTwo);
		this.less = new VMLessThanOperator(operandOne, operandTwo);
		this.equals = new VMEqualsOperator(operandOne, operandTwo);
	}

	@Override
	protected VMObject evaluateImpl(VMObject opOne, VMObject opTwo) {
		if (LOG.isTraceEnabled()) {
			LOG.trace("Greater than operator evaluating: " + opOne + " > "
					+ opTwo);
		}
		final VMBoolean lt = (VMBoolean) less.evaluate();
		final VMBoolean eq = (VMBoolean) equals.evaluate();
		final boolean gt = !(lt.getValue() || eq.getValue());
		return (VMBoolean.valueOf(gt));
	}
}

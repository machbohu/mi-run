package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMBoolean;

public final class VMNotEqualsOperator extends VMBinaryOperator {

	private final VMEqualsOperator equals;

	public VMNotEqualsOperator(VMObject operandOne, VMObject operandTwo) {
		super(operandOne, operandTwo);
		equals = new VMEqualsOperator(operandOne, operandTwo);
	}

	@Override
	protected VMBoolean evaluateImpl(VMObject opOne, VMObject opTwo) {
		if (LOG.isTraceEnabled()) {
			LOG.trace("Non-equality operator evaluating: " + opOne + " != "
					+ opTwo);
		}
		VMBoolean res = (VMBoolean) equals.evaluate();
		return (res.equals(VMBoolean.TRUE) ? VMBoolean.FALSE : VMBoolean.TRUE);
	}

}

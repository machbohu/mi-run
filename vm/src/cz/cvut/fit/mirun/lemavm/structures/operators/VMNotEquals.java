package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMBoolean;

public final class VMNotEquals extends VMBinaryOperator {

	private final VMEquals equals;

	public VMNotEquals(VMObject operandOne, VMObject operandTwo) {
		super(operandOne, operandTwo);
		equals = new VMEquals(operandOne, operandTwo);
	}

	@Override
	protected VMObject evaluateImpl(VMObject opOne, VMObject opTwo) {
		if (LOG.isTraceEnabled()) {
			LOG.trace("Non-equality operator evaluating: " + opOne + " != "
					+ opTwo);
		}
		VMBoolean res = (VMBoolean) equals.evaluate();
		return (res.equals(VMBoolean.TRUE) ? VMBoolean.FALSE : VMBoolean.TRUE);
	}

}

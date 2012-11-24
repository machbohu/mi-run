package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMBoolean;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMPrimitive;

public final class VMEqualsOperator extends VMBinaryOperator {

	public VMEqualsOperator(VMObject operandOne, VMObject operandTwo) {
		super(operandOne, operandTwo);
	}

	@Override
	protected VMBoolean evaluateImpl(VMObject opOne, VMObject opTwo) {
		if (LOG.isTraceEnabled()) {
			LOG.trace("Equality operator evaluating: " + opOne + " == " + opTwo);
		}
		if (opOne instanceof VMPrimitive && opTwo instanceof VMPrimitive) {
			final VMPrimitive pOne = (VMPrimitive) opOne;
			final VMPrimitive pTwo = (VMPrimitive) opTwo;
			return (pOne.valueEquals(pTwo) ? VMBoolean.TRUE : VMBoolean.FALSE);
		}
		if (opOne.equals(opTwo)) {
			return VMBoolean.TRUE;
		} else {
			return VMBoolean.FALSE;
		}
	}

}

package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.core.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMBoolean;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMNumber;

public final class VMLessThanOperator extends VMBinaryOperator {

	public VMLessThanOperator(VMObject operandOne, VMObject operandTwo) {
		super(operandOne, operandTwo);
	}

	@Override
	protected VMBoolean evaluateImpl(VMObject opOne, VMObject opTwo) {
		if (LOG.isTraceEnabled()) {
			LOG.trace("Less than operator evaluating: " + opOne + " < " + opTwo);
		}
		if (opOne instanceof VMNumber && opTwo instanceof VMNumber) {
			final VMNumber nOne = (VMNumber) opOne;
			final VMNumber nTwo = (VMNumber) opTwo;
			final boolean res = nOne.doubleValue() < nTwo.doubleValue();
			return VMBoolean.valueOf(res);
		} else {
			throw new VMEvaluationException(
					"Operator < is not applicable for operands of type "
							+ opOne.getType() + " and " + opTwo.getType());
		}
	}

}

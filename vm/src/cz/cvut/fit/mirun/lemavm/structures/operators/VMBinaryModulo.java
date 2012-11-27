package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMNullPointerException;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMDouble;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMInteger;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMLong;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMNull;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMNumber;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMShort;

public final class VMBinaryModulo extends VMBinaryOperator {

	public VMBinaryModulo(VMObject operandOne, VMObject operandTwo) {
		super(operandOne, operandTwo);
	}

	@Override
	protected VMObject evaluateImpl(VMObject opOne, VMObject opTwo) {
		if (LOG.isTraceEnabled()) {
			LOG.trace("BinaryModulo evaluating: " + opOne + " % " + opTwo);
		}
		VMObject toReturn = null;
		if (opOne instanceof VMNumber && opTwo instanceof VMNumber) {
			final VMNumber nOne = (VMNumber) opOne;
			final VMNumber nTwo = (VMNumber) opTwo;
			if (nOne instanceof VMDouble || nTwo instanceof VMDouble) {
				double result = nOne.doubleValue() % nTwo.doubleValue();
				toReturn = new VMDouble(result);
			} else if (nOne instanceof VMLong || nTwo instanceof VMLong) {
				toReturn = new VMLong(nOne.longValue() % nTwo.longValue());
			} else if (nOne instanceof VMInteger || nTwo instanceof VMInteger) {
				toReturn = new VMInteger(nOne.intValue() % nTwo.intValue());
			} else {
				toReturn = new VMShort(nOne.shortValue() % nTwo.shortValue());
			}
		} else {
			if (opOne.equals(VMNull.getInstance())
					|| opTwo.equals(VMNull.getInstance())) {
				throw new VMNullPointerException();
			}
			throw new VMEvaluationException(
					"BinaryModulo is not applicable for operands of type "
							+ opOne.getType() + " and " + opTwo.getType());
		}
		return toReturn;
	}

}

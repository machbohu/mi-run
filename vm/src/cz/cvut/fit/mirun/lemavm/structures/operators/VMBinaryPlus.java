package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMNullPointerException;
import cz.cvut.fit.mirun.lemavm.structures.Printable;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMDouble;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMInteger;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMLong;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMNull;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMNumber;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMShort;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

public final class VMBinaryPlus extends VMBinaryOperator {

	public VMBinaryPlus(VMObject operandOne, VMObject operandTwo) {
		super(operandOne, operandTwo);
	}

	@Override
	protected VMObject evaluateImpl(VMObject opOne, VMObject opTwo) {
		if (LOG.isTraceEnabled()) {
			LOG.trace("BinaryPlus evaluating: " + opOne + " + " + opTwo);
		}
		VMObject toReturn = null;
		if ((opOne instanceof VMString && opTwo instanceof Printable)
				|| (opTwo instanceof VMString && opOne instanceof Printable)) {
			// Concatenate strings
			final Printable strOne = (Printable) opOne;
			final Printable strTwo = (Printable) opTwo;
			toReturn = new VMString(strOne.printValue() + strTwo.printValue());
		} else if ((opOne instanceof VMNumber) && (opTwo instanceof VMNumber)) {
			// Add numbers
			final VMNumber nOne = (VMNumber) opOne;
			final VMNumber nTwo = (VMNumber) opTwo;
			if (nOne instanceof VMDouble || nTwo instanceof VMDouble) {
				toReturn = new VMDouble(nOne.doubleValue() + nTwo.doubleValue());
			} else if (nOne instanceof VMLong || nTwo instanceof VMLong) {
				toReturn = new VMLong(nOne.longValue() + nTwo.longValue());
			} else if (nOne instanceof VMInteger || nTwo instanceof VMInteger) {
				toReturn = new VMInteger(nOne.intValue() + nTwo.intValue());
			} else {
				toReturn = new VMShort(nOne.shortValue() + nTwo.shortValue());
			}
		} else {
			if (opOne.equals(VMNull.getInstance())
					|| opTwo.equals(VMNull.getInstance())) {
				throw new VMNullPointerException();
			}
			throw new VMEvaluationException(
					"BinaryPlus is not applicable for operands of type "
							+ opOne.getType() + " and " + opTwo.getType());
		}
		return toReturn;
	}
}

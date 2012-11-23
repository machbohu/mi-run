package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.core.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMDouble;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMInteger;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMLong;
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
		if ((opOne instanceof VMString) && (opTwo instanceof VMString)) {
			final VMString strOne = (VMString) opOne;
			final VMString strTwo = (VMString) opTwo;
			toReturn = new VMString(strOne.getValue() + strTwo.getValue());
		} else if ((opOne instanceof VMNumber) && (opTwo instanceof VMNumber)) {
			if ((opOne instanceof VMShort) && (opTwo instanceof VMShort)) {
				final short sOne = ((VMShort) opOne).getValue();
				final short sTwo = ((VMShort) opTwo).getValue();
				toReturn = new VMShort((short) (sOne + sTwo));
			} else if ((opOne instanceof VMInteger)
					&& (opTwo instanceof VMInteger)) {
				final int sOne = ((VMInteger) opOne).getValue();
				final int sTwo = ((VMInteger) opTwo).getValue();
				toReturn = new VMInteger(sOne + sTwo);
			} else if ((opOne instanceof VMLong) && (opTwo instanceof VMLong)) {
				final long sOne = ((VMLong) opOne).getValue();
				final long sTwo = ((VMLong) opTwo).getValue();
				toReturn = new VMLong(sOne + sTwo);
			} else if ((opOne instanceof VMDouble)
					&& (opTwo instanceof VMDouble)) {
				final double sOne = ((VMDouble) opOne).getValue();
				final double sTwo = ((VMDouble) opTwo).getValue();
				toReturn = new VMDouble(sOne + sTwo);
			} else {
				// TODO mixed types addition + isn't there a better way of
				// implementing this?
			}
		} else {
			throw new VMEvaluationException(
					"BinaryPlus is not applicable for operators of type "
							+ opOne.getType() + " and " + opTwo.getType());
		}
		return toReturn;
	}
}

package cz.cvut.fit.mirun.lemavm.structures.operators.mixed;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class VMDoubleCompMultiply extends VMBinaryDoubleCompOperator {

	public VMDoubleCompMultiply(double opOne, VMOperator opTwo) {
		super(opOne, opTwo);
	}

	public VMDoubleCompMultiply(VMOperator opOne, double opTwo) {
		super(opOne, opTwo);
	}

	@Override
	public double evaluateDouble() {
		if (operOne != null) {
			double d = operOne.evaluateDouble();
			return (d * opTwo);
		} else {
			double d = operTwo.evaluateDouble();
			return opOne * d;
		}
	}

	@Override
	public long evaluateLong() {
		if (operOne != null) {
			long d = operOne.evaluateLong();
			return (long) (d * opTwo);
		} else {
			long d = operTwo.evaluateLong();
			return (long) (opOne * d);
		}
	}

	@Override
	public int evaluateInt() {
		if (operOne != null) {
			int d = operOne.evaluateInt();
			return (int) (d * opTwo);
		} else {
			int d = operTwo.evaluateInt();
			return (int) (opOne * d);
		}
	}

	@Override
	public short evaluateShort() {
		if (operOne != null) {
			int d = operOne.evaluateInt();
			return (short) (d * opTwo);
		} else {
			int d = operTwo.evaluateInt();
			return (short) (opOne * d);
		}
	}

	@Override
	public boolean evaluateBoolean() {
		throw new VMEvaluationException("Operator cannot return boolean value.");
	}

	@Override
	public String evaluateString() {
		return ("" + opOne + " * " + opTwo);
	}
}

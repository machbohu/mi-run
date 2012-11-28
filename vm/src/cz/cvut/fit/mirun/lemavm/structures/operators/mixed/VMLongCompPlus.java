package cz.cvut.fit.mirun.lemavm.structures.operators.mixed;

import cz.cvut.fit.mirun.lemavm.exceptions.VMDivisionByZeroException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class VMLongCompPlus extends VMBinaryLongCompOperator {

	public VMLongCompPlus(long opOne, VMOperator operTwo) {
		super(opOne, operTwo);
	}

	public VMLongCompPlus(VMOperator operOne, long opTwo) {
		super(operOne, opTwo);
	}

	@Override
	public double evaluateDouble() {
		if (operOne != null) {
			long d = operOne.evaluateLong();
			if (opTwo == 0) {
				throw new VMDivisionByZeroException();
			}
			return (double) (d + opTwo);
		} else {
			long d = operTwo.evaluateLong();
			if (d == 0) {
				throw new VMDivisionByZeroException();
			}
			return (double) (opOne + d);
		}
	}

	@Override
	public long evaluateLong() {
		if (operOne != null) {
			long d = operOne.evaluateLong();
			if (opTwo == 0) {
				throw new VMDivisionByZeroException();
			}
			return (long) (d + opTwo);
		} else {
			long d = operTwo.evaluateLong();
			if (d == 0) {
				throw new VMDivisionByZeroException();
			}
			return (long) (opOne + d);
		}
	}

	@Override
	public int evaluateInt() {
		if (operOne != null) {
			long d = operOne.evaluateLong();
			if (opTwo == 0) {
				throw new VMDivisionByZeroException();
			}
			return (int) (d + opTwo);
		} else {
			long d = operOne.evaluateLong();
			if (d == 0) {
				throw new VMDivisionByZeroException();
			}
			return (int) (opOne + d);
		}
	}

	@Override
	public short evaluateShort() {
		if (operOne != null) {
			long d = operOne.evaluateLong();
			if (opTwo == 0) {
				throw new VMDivisionByZeroException();
			}
			return (short) (d + opTwo);
		} else {
			long d = operOne.evaluateLong();
			if (d == 0) {
				throw new VMDivisionByZeroException();
			}
			return (short) (opOne + d);
		}
	}

	@Override
	public boolean evaluateBoolean() {
		throw new VMEvaluationException("Operator cannot return boolean value.");
	}

	@Override
	public String evaluateString() {
		return ("" + opOne + " + " + opTwo);
	}
}

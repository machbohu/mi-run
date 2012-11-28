package cz.cvut.fit.mirun.lemavm.structures.operators.mixed;

import cz.cvut.fit.mirun.lemavm.exceptions.VMDivisionByZeroException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class VMShortCompDivide extends VMBinaryShortCompOperator {

	public VMShortCompDivide(short opOne, VMOperator operTwo) {
		super(opOne, operTwo);
	}

	public VMShortCompDivide(VMOperator operOne, short opTwo) {
		super(operOne, opTwo);
	}

	@Override
	public double evaluateDouble() {
		if (operOne != null) {
			double d = operOne.evaluateDouble();
			if (opTwo == 0) {
				throw new VMDivisionByZeroException();
			}
			return (double) (d / opTwo);
		} else {
			double d = operTwo.evaluateDouble();
			if (d == 0) {
				throw new VMDivisionByZeroException();
			}
			return (double) (opOne / d);
		}
	}

	@Override
	public long evaluateLong() {
		if (operOne != null) {
			long d = operOne.evaluateLong();
			if (opTwo == 0) {
				throw new VMDivisionByZeroException();
			}
			return (long) (d / opTwo);
		} else {
			long d = operTwo.evaluateLong();
			if (d == 0) {
				throw new VMDivisionByZeroException();
			}
			return (long) (opOne / d);
		}
	}

	@Override
	public int evaluateInt() {
		if (operOne != null) {
			int d = operOne.evaluateInt();
			if (opTwo == 0) {
				throw new VMDivisionByZeroException();
			}
			return (int) (d / opTwo);
		} else {
			int d = operTwo.evaluateInt();
			if (d == 0) {
				throw new VMDivisionByZeroException();
			}
			return (int) (opOne / d);
		}
	}

	@Override
	public short evaluateShort() {
		if (operOne != null) {
			int d = operOne.evaluateInt();
			if (opTwo == 0) {
				throw new VMDivisionByZeroException();
			}
			return (short) (d / opTwo);
		} else {
			int d = operTwo.evaluateInt();
			if (d == 0) {
				throw new VMDivisionByZeroException();
			}
			return (short) (opOne / d);
		}
	}

	@Override
	public boolean evaluateBoolean() {
		throw new VMEvaluationException("Operator cannot return boolean value.");
	}

	@Override
	public String evaluateString() {
		return ("" + opOne + " / " + opTwo);
	}
}

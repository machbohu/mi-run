package cz.cvut.fit.mirun.lemavm.structures.operators.doubles;

import cz.cvut.fit.mirun.lemavm.exceptions.VMDivisionByZeroException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;

public final class VMDoubleDivide extends VMBinaryDoubleOperator {

	public VMDoubleDivide(double opOne, double opTwo) {
		super(opOne, opTwo);
	}

	@Override
	public double evaluateDouble() {
		return (opOne / opTwo);
	}

	@Override
	public long evaluateLong() {
		if (opTwo == 0) {
			throw new VMDivisionByZeroException();
		}
		return (long) (opOne / opTwo);
	}

	@Override
	public int evaluateInt() {
		if (opTwo == 0) {
			throw new VMDivisionByZeroException();
		}
		return (int) (opOne / opTwo);
	}

	@Override
	public short evaluateShort() {
		if (opTwo == 0) {
			throw new VMDivisionByZeroException();
		}
		return (short) (opOne / opTwo);
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

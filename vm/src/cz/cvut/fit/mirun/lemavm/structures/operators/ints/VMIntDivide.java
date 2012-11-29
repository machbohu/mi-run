package cz.cvut.fit.mirun.lemavm.structures.operators.ints;

import cz.cvut.fit.mirun.lemavm.exceptions.VMDivisionByZeroException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

public final class VMIntDivide extends VMBinaryIntOperator {

	public VMIntDivide(int opOne, int opTwo) {
		super(opOne, opTwo);
	}

	@Override
	public double evaluateDouble() {
		if (opTwo == 0) {
			throw new VMDivisionByZeroException();
		}
		return (opOne / opTwo);
	}

	@Override
	public long evaluateLong() {
		if (opTwo == 0) {
			throw new VMDivisionByZeroException();
		}
		return (opOne / opTwo);
	}

	@Override
	public int evaluateInt() {
		if (opTwo == 0) {
			throw new VMDivisionByZeroException();
		}
		return (opOne / opTwo);
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
	public VMString evaluateString() {
		return new VMString("" + evaluateInt());
	}
}

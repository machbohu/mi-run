package cz.cvut.fit.mirun.lemavm.structures.operators.compounds;

import cz.cvut.fit.mirun.lemavm.exceptions.VMDivisionByZeroException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

public final class VMCompoundDivide extends VMBinaryComposedOperator {

	public VMCompoundDivide(VMOperator opOne, VMOperator opTwo) {
		super(opOne, opTwo);
	}

	@Override
	public double evaluateDouble() {
		double dOne = opOne.evaluateDouble();
		double dTwo = opTwo.evaluateDouble();
		return (dOne / dTwo);
	}

	@Override
	public long evaluateLong() {
		long dOne = opOne.evaluateLong();
		long dTwo = opTwo.evaluateLong();
		if (dTwo == 0) {
			throw new VMDivisionByZeroException();
		}
		return (dOne / dTwo);
	}

	@Override
	public int evaluateInt() {
		int dOne = opOne.evaluateInt();
		int dTwo = opTwo.evaluateInt();
		if (dTwo == 0) {
			throw new VMDivisionByZeroException();
		}
		return (dOne / dTwo);
	}

	@Override
	public short evaluateShort() {
		short dOne = opOne.evaluateShort();
		short dTwo = opTwo.evaluateShort();
		if (dTwo == 0) {
			throw new VMDivisionByZeroException();
		}
		return (short) (dOne / dTwo);
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

package cz.cvut.fit.mirun.lemavm.structures.operators.shorts;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;

public final class VMShortMinus extends VMBinaryShortOperator {

	public VMShortMinus(short opOne, short opTwo) {
		super(opOne, opTwo);
	}

	@Override
	public double evaluateDouble() {
		return (opOne - opTwo);
	}

	@Override
	public long evaluateLong() {
		return (opOne - opTwo);
	}

	@Override
	public int evaluateInt() {
		return (opOne - opTwo);
	}

	@Override
	public short evaluateShort() {
		return (short) (opOne - opTwo);
	}

	@Override
	public boolean evaluateBoolean() {
		throw new VMEvaluationException("Operator cannot return boolean value.");
	}

	@Override
	public String evaluateString() {
		return ("" + opOne + " - " + opTwo);
	}
}
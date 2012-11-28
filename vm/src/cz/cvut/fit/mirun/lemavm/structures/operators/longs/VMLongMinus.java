package cz.cvut.fit.mirun.lemavm.structures.operators.longs;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;

public final class VMLongMinus extends VMBinaryLongOperator {

	public VMLongMinus(long opOne, long opTwo) {
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
		return (int) (opOne - opTwo);
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

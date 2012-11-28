package cz.cvut.fit.mirun.lemavm.structures.operators.longs;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;

public class VMUnaryLongMinus extends VMUnaryLongOperator {

	public VMUnaryLongMinus(long op) {
		super(op);
	}

	@Override
	public double evaluateDouble() {
		return (-op);
	}

	@Override
	public long evaluateLong() {
		return (-op);
	}

	@Override
	public int evaluateInt() {
		return (int) (-op);
	}

	@Override
	public short evaluateShort() {
		return (short) (-op);
	}

	@Override
	public boolean evaluateBoolean() {
		throw new VMEvaluationException("Operator cannot return boolean value.");
	}

	@Override
	public String evaluateString() {
		return ("-" + op);
	}
}

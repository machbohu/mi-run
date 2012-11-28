package cz.cvut.fit.mirun.lemavm.structures.operators.doubles;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;

public final class VMUnaryDoubleMinus extends VMUnaryDoubleOperator {

	public VMUnaryDoubleMinus(double op) {
		super(op);
	}

	@Override
	public double evaluateDouble() {
		return (-op);
	}

	@Override
	public long evaluateLong() {
		return (long) (-op);
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
		return (Double.toString(op));
	}
}

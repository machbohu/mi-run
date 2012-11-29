package cz.cvut.fit.mirun.lemavm.structures.operators.ints;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;

public class VMUnaryIntMinus extends VMUnaryIntOperator {

	public VMUnaryIntMinus(int op) {
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
		return (-op);
	}

	@Override
	public short evaluateShort() {
		return (short) (-op);
	}

	@Override
	public boolean evaluateBoolean() {
		throw new VMEvaluationException("Operator cannot return boolean value.");
	}
}

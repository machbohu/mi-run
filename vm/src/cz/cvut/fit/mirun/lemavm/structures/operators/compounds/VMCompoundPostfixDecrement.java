package cz.cvut.fit.mirun.lemavm.structures.operators.compounds;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class VMCompoundPostfixDecrement extends VMUnaryCompoundOperator {

	public VMCompoundPostfixDecrement(VMOperator op) {
		super(op);
	}

	@Override
	public double evaluateDouble() {
		double d = op.evaluateDouble();
		return (d--);
	}

	@Override
	public long evaluateLong() {
		long d = op.evaluateLong();
		return (d--);
	}

	@Override
	public int evaluateInt() {
		int d = op.evaluateInt();
		return (d--);
	}

	@Override
	public short evaluateShort() {
		short d = op.evaluateShort();
		return (short) (d--);
	}

	@Override
	public boolean evaluateBoolean() {
		throw new VMEvaluationException("Operator cannot return boolean value.");
	}

	@Override
	public String evaluateString() {
		return ("" + op + "--");
	}
}

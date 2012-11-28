package cz.cvut.fit.mirun.lemavm.structures.operators.compounds;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class VMCompoundNegation extends VMUnaryCompoundOperator {

	public VMCompoundNegation(VMOperator op) {
		super(op);
	}

	@Override
	public double evaluateDouble() {
		throw new VMEvaluationException(
				"Operator is not applicable for type double.");
	}

	@Override
	public long evaluateLong() {
		throw new VMEvaluationException(
				"Operator is not applicable for type long.");
	}

	@Override
	public int evaluateInt() {
		throw new VMEvaluationException(
				"Operator is not applicable for type int.");
	}

	@Override
	public short evaluateShort() {
		throw new VMEvaluationException(
				"Operator is not applicable for type short.");
	}

	@Override
	public boolean evaluateBoolean() {
		boolean res = op.evaluateBoolean();
		return (!res);
	}

	@Override
	public String evaluateString() {
		throw new VMEvaluationException(
				"Operator is not applicable for type string.");
	}

}

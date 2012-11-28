package cz.cvut.fit.mirun.lemavm.structures.operators.control;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public abstract class VMRelationalOperator extends VMOperator {

	@Override
	public double evaluateDouble() {
		throw new VMEvaluationException(
				"Relational operator cannot return double.");
	}

	@Override
	public long evaluateLong() {
		throw new VMEvaluationException(
				"Relational operator cannot return double.");
	}

	@Override
	public int evaluateInt() {
		throw new VMEvaluationException(
				"Relational operator cannot return double.");
	}

	@Override
	public short evaluateShort() {
		throw new VMEvaluationException(
				"Relational operator cannot return double.");
	}

	@Override
	public String evaluateString() {
		throw new VMEvaluationException(
				"Relational operator cannot return double.");
	}

}

package cz.cvut.fit.mirun.lemavm.structures.operators.control;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

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
	public VMString evaluateString() {
		throw new VMEvaluationException(
				"Relational operator cannot return double.");
	}

}

package cz.cvut.fit.mirun.lemavm.structures.operators.compounds;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class VMCompoundNegation extends VMUnaryCompoundOperator {

	public VMCompoundNegation(VMOperator op) {
		super(op);
	}

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		throw new VMEvaluationException(
				"Operator is not applicable for type double.");
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		throw new VMEvaluationException(
				"Operator is not applicable for type long.");
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		throw new VMEvaluationException(
				"Operator is not applicable for type int.");
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		throw new VMEvaluationException(
				"Operator is not applicable for type short.");
	}

	@Override
	public Boolean evaluateBoolean(VMEnvironment env) {
		boolean res = op.evaluateBoolean(env);
		return (!res);
	}

	@Override
	public VMString evaluateString(VMEnvironment env) {
		return new VMString(evaluateBoolean(env).toString());
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		return evaluateBoolean(env);
	}
}

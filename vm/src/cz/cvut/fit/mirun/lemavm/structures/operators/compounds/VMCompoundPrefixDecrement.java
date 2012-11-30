package cz.cvut.fit.mirun.lemavm.structures.operators.compounds;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

public final class VMCompoundPrefixDecrement extends VMUnaryCompoundOperator {

	public VMCompoundPrefixDecrement(VMOperator op) {
		super(op);
	}

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		Double d = op.evaluateDouble(env);
		return (--d);
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		Long d = op.evaluateLong(env);
		return (--d);
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		Integer d = op.evaluateInt(env);
		return (--d);
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		Short d = op.evaluateShort(env);
		return (short) (--d);
	}

	@Override
	public Boolean evaluateBoolean(VMEnvironment env) {
		throw new VMEvaluationException("Operator cannot return boolean value.");
	}

	@Override
	public VMString evaluateString(VMEnvironment env) {
		return new VMString(evaluateInt(env).toString());
	}
}

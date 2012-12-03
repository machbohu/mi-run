package cz.cvut.fit.mirun.lemavm.structures.operators.plus;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public abstract class AbstractBinaryPlus extends VMOperator {

	@Override
	public Boolean evaluateBoolean(VMEnvironment env) {
		throw new VMEvaluationException("Operator + cannot return boolean.");
	}

	@Override
	public VMString evaluateString(VMEnvironment env) {
		return new VMString(evaluateInt(env).toString());
	}

}

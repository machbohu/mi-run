package cz.cvut.fit.mirun.lemavm.structures.operators.minus;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

public abstract class AbstractBinaryMinus extends VMOperator {

	@Override
	public Boolean evaluateBoolean(VMEnvironment env) {
		throw new VMEvaluationException("Operator - cannot return boolean.");
	}

	@Override
	public VMString evaluateString(VMEnvironment env) {
		return new VMString(evaluateInt(env).toString());
	}

}

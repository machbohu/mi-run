package cz.cvut.fit.mirun.lemavm.structures.operators.multiplication;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public abstract class AbstractBinaryMultiplication extends VMOperator {

	@Override
	public Boolean evaluateBoolean(VMEnvironment env) {
		throw new VMEvaluationException("Operator * cannot return boolean.");
	}

	@Override
	public VMString evaluateString(VMEnvironment env) {
		return new VMString(evaluateInt(env).toString());
	}

	protected Number multiplyNumbers(Number nOne, Number nTwo) {
		assert nOne != null;
		assert nTwo != null;
		if (nOne instanceof Double || nTwo instanceof Double) {
			return Double.valueOf(nOne.doubleValue() * nTwo.doubleValue());
		} else if (nOne instanceof Long || nTwo instanceof Long) {
			return Long.valueOf(nOne.longValue() * nTwo.longValue());
		} else {
			return Integer.valueOf(nOne.intValue() * nTwo.intValue());
		}
	}
}

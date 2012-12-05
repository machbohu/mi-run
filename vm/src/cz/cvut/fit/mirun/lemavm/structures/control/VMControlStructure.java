package cz.cvut.fit.mirun.lemavm.structures.control;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.Evaluable;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

public abstract class VMControlStructure implements Evaluable {

	public VMControlStructure() {
	}

	protected boolean checkCondition(Evaluable condition, VMEnvironment env) {
		Object res = condition.evaluate(env);

		if (!(res instanceof Boolean)) {
			throw new VMEvaluationException("Cannot evaluate condition "
					+ condition + " with result " + res);
		}

		return (Boolean) res;
	}
}

package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;

public final class VMAssignString extends VMAssignOperator {

	private final String value;

	public VMAssignString(String name, String type, boolean isFinal,
			String value) {
		super(name, type, isFinal);
		this.value = value;
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		String str = value.substring(1, value.length() - 1);
		resolveType(env);
		if (!type.equals(VMConstants.STRING)) {
			throw new VMEvaluationException(
					"Incompatible types found. Expected " + type
							+ ", but got string.");
		}
		final VMString newStr = new VMString(str);
		if (isFinal) {
			env.addFinalBinding(name, newStr, type);
		} else {
			env.addBinding(name, newStr, type);
		}
		return null;
	}
}

package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;

public final class VMAssignString extends VMAssignOperator {

	private final VMString value;

	public VMAssignString(String name, String type, boolean isFinal,
			VMString value) {
		super(name, type, isFinal);
		this.value = value;
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		resolveType(env);
		checkTypeCompatibility(type, VMConstants.STRING);
		if (isFinal) {
			env.addFinalBinding(name, value, type);
		} else {
			env.addBinding(name, value, type);
		}
		return null;
	}

}

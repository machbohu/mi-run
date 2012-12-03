package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;

public final class VMAssignString extends VMAssignOperator {

	private final VMString value;

	public VMAssignString(String name, String type, VMEnvironment environment,
			boolean isFinal, VMString value) {
		super(name, type, environment, isFinal);
		this.value = value;
	}

	@Override
	public void evaluate() {
		resolveType();
		checkTypeCompatibility(type, VMConstants.STRING);
		if (isFinal) {
			environment.addFinalBinding(name, value, type);
		} else {
			environment.addBinding(name, value, type);
		}
	}

}

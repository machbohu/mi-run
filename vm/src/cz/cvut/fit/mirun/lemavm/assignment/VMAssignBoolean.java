package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.core.VMConstants;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

public final class VMAssignBoolean extends VMAssignOperator {

	private final boolean value;

	public VMAssignBoolean(String name, String type, VMEnvironment environment,
			boolean isFinal, boolean value) {
		super(name, type, environment, isFinal);
		this.value = value;
	}

	@Override
	public void evaluate() {
		resolveType();
		checkTypeCompatibility(type, VMConstants.BOOLEAN);
		if (isFinal) {
			environment.addPrimitiveFinalBinding(name, Boolean.valueOf(value),
					type);
		} else {
			environment.addPrimitiveBinding(name, Boolean.valueOf(value), type);
		}
	}
}

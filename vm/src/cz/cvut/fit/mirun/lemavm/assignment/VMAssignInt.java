package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.core.VMConstants;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

public final class VMAssignInt extends VMAssignOperator {

	private final int value;

	public VMAssignInt(String name, String type, VMEnvironment environment,
			boolean isFinal, int value) {
		super(name, type, environment, isFinal);
		this.value = value;
	}

	@Override
	public void evaluate() {
		resolveType();
		checkTypeCompatibility(type, VMConstants.INT);
		if (isFinal) {
			environment.addPrimitiveFinalBinding(name, Integer.valueOf(value),
					type);
		} else {
			environment.addPrimitiveBinding(name, Integer.valueOf(value), type);
		}
	}
}

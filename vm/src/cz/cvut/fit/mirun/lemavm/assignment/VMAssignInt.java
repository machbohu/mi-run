package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;

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

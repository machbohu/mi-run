package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.core.VMConstants;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

public final class VMAssignShort extends VMAssignOperator {

	private final short value;

	public VMAssignShort(String name, String type, VMEnvironment environment,
			boolean isFinal, short value) {
		super(name, type, environment, isFinal);
		this.value = value;
	}

	@Override
	public void evaluate() {
		resolveType();
		checkTypeCompatibility(type, VMConstants.SHORT);
		if (isFinal) {
			environment.addPrimitiveFinalBinding(name, Short.valueOf(value),
					type);
		} else {
			environment.addPrimitiveBinding(name, Short.valueOf(value), type);
		}
	}

}

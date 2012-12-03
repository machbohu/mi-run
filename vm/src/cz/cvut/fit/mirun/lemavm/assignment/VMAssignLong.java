package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;

public final class VMAssignLong extends VMAssignOperator {

	private final long value;

	public VMAssignLong(String name, String type, VMEnvironment environment,
			boolean isFinal, long value) {
		super(name, type, environment, isFinal);
		this.value = value;
	}

	@Override
	public void evaluate() {
		resolveType();
		checkTypeCompatibility(type, VMConstants.LONG);
		if (isFinal) {
			environment.addPrimitiveFinalBinding(name, Long.valueOf(value),
					type);
		} else {
			environment.addPrimitiveBinding(name, Long.valueOf(value), type);
		}
	}
}

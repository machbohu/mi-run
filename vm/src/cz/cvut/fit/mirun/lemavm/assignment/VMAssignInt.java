package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;

public final class VMAssignInt extends VMAssignOperator {

	private final int value;

	public VMAssignInt(String name, String type, boolean isFinal, int value) {
		super(name, type, isFinal);
		this.value = value;
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		resolveType(env);
		checkTypeCompatibility(type, VMConstants.INT);
		if (isFinal) {
			env.addPrimitiveFinalBinding(name, Integer.valueOf(value), type);
		} else {
			env.addPrimitiveBinding(name, Integer.valueOf(value), type);
		}
		return null;
	}
}

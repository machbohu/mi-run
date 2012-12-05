package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;

public final class VMAssignBoolean extends VMAssignOperator {

	private final boolean value;

	public VMAssignBoolean(String name, String type, boolean isFinal,
			boolean value) {
		super(name, type, isFinal);
		this.value = value;
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		resolveType(env);
		checkReferenceTypeCompatibility(type, VMConstants.BOOLEAN);
		if (isFinal) {
			env.addPrimitiveFinalBinding(name, Boolean.valueOf(value), type);
		} else {
			env.addPrimitiveBinding(name, Boolean.valueOf(value), type);
		}
		return null;
	}
}

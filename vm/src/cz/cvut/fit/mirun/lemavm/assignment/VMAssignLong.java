package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;

public final class VMAssignLong extends VMAssignOperator {

	private final long value;

	public VMAssignLong(String name, String type, boolean isFinal, long value) {
		super(name, type, isFinal);
		this.value = value;
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		resolveType(env);
		checkTypeCompatibility(type, VMConstants.LONG);
		if (isFinal) {
			env.addPrimitiveFinalBinding(name, Long.valueOf(value), type);
		} else {
			env.addPrimitiveBinding(name, Long.valueOf(value), type);
		}
		return null;
	}
}

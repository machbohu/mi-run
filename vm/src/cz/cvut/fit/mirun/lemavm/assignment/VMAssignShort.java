package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;

public final class VMAssignShort extends VMAssignOperator {

	private final short value;

	public VMAssignShort(String name, String type, boolean isFinal, short value) {
		super(name, type, isFinal);
		this.value = value;
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		resolveType(env);
		checkTypeCompatibility(type, VMConstants.SHORT);
		if (isFinal) {
			env.addPrimitiveFinalBinding(name, Short.valueOf(value), type);
		} else {
			env.addPrimitiveBinding(name, Short.valueOf(value), type);
		}
		return null;
	}

}

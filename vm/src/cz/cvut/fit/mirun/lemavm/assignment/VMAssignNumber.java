package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;

public final class VMAssignNumber extends VMAssignOperator {

	private final Number value;

	public VMAssignNumber(String name, String type, boolean isFinal,
			Number value) {
		super(name, type, isFinal);
		this.value = value;
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		resolveType(env);
		if (value instanceof Double) {
			checkTypeCompatibility(type, VMConstants.DOUBLE);
		} else if (value instanceof Long) {
			checkTypeCompatibility(type, VMConstants.LONG);
		} else if (value instanceof Integer) {
			checkTypeCompatibility(type, VMConstants.INT);
		} else {
			checkTypeCompatibility(type, VMConstants.SHORT);
		}
		if (isFinal) {
			env.addPrimitiveFinalBinding(name, value, type);
		} else {
			env.addPrimitiveBinding(name, value, type);
		}
		return null;
	}

}

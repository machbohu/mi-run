package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;

public final class VMAssignDouble extends VMAssignOperator {

	private final double value;

	public VMAssignDouble(String name, String type, boolean isFinal,
			double value) {
		super(name, type, isFinal);
		this.value = value;
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		resolveType(env);
		checkTypeCompatibility(type, VMConstants.DOUBLE);
		if (isFinal) {
			env.addPrimitiveFinalBinding(name, Double.valueOf(value), type);
		} else {
			env.addPrimitiveBinding(name, Double.valueOf(value), type);
		}
		return null;
	}

}

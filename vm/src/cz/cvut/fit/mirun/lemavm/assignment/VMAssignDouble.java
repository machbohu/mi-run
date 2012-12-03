package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;

public final class VMAssignDouble extends VMAssignOperator {

	private final double value;

	public VMAssignDouble(String name, String type, VMEnvironment environment,
			boolean isFinal, double value) {
		super(name, type, environment, isFinal);
		this.value = value;
	}

	@Override
	public void evaluate() {
		resolveType();
		checkTypeCompatibility(type, VMConstants.DOUBLE);
		if (isFinal) {
			environment.addPrimitiveFinalBinding(name, Double.valueOf(value),
					type);
		} else {
			environment.addPrimitiveBinding(name, Double.valueOf(value), type);
		}
	}

}

package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.core.VMConstants;
import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMNull;

public final class VMAssignNull extends VMAssignOperator {

	private final VMNull value;

	public VMAssignNull(String name, String type, VMEnvironment environment,
			boolean isFinal, VMNull value) {
		super(name, type, environment, isFinal);
		this.value = value;
	}

	@Override
	public void evaluate() {
		resolveType();
		switch (type) {
		case VMConstants.DOUBLE:
		case VMConstants.LONG:
		case VMConstants.INT:
		case VMConstants.SHORT:
		case VMConstants.BOOLEAN:
			throw new VMEvaluationException(
					"Incompatible types found. Cannot assign null to a variable of type "
							+ type);
		default:
			if (isFinal) {
				// This is quite curious, who would assign null to a final
				// variable:)
				environment.addFinalBinding(name, value, type);
			} else {
				environment.addBinding(name, value, type);
			}
		}
	}

}

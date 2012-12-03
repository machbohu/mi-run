package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMNull;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;

public final class VMAssignNull extends VMAssignOperator {

	private final VMNull value;

	public VMAssignNull(String name, String type, boolean isFinal, VMNull value) {
		super(name, type, isFinal);
		this.value = value;
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		resolveType(env);
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
				env.addFinalBinding(name, value, type);
			} else {
				env.addBinding(name, value, type);
			}
		}
		return null;
	}

}

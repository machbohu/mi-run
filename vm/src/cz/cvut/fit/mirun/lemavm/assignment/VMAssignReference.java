package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMClassInstance;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;

public final class VMAssignReference extends VMAssignOperator {

	private final VMObject value;

	public VMAssignReference(String name, String type, boolean isFinal,
			VMObject value) {
		super(name, type, isFinal);
		this.value = value;
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		resolveType(env);
		if (value instanceof VMClassInstance) {
			final VMClassInstance inst = (VMClassInstance) value;
			checkTypeCompatibility(type, inst.getTypeName());
			if (isFinal) {
				env.addFinalBinding(name, value, type);
			} else {
				env.addBinding(name, value, type);
			}
		} else {
			switch (value.getTypeName()) {
			case VMConstants.STRING:
				checkTypeCompatibility(type, VMConstants.STRING);
				break;
			case VMConstants.NULL:
				break;
			case VMConstants.ARRAY:
				break;
			default:
				throw new VMEvaluationException(
						"Unknown object encountered in assignment: " + value);
			}
			if (isFinal) {
				env.addFinalBinding(name, value, type);
			} else {
				env.addBinding(name, value, type);
			}
		}
		return null;
	}

}

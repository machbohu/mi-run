package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.VMUtils;

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
		if (!VMUtils.isReferenceTypeCompatible(type, value)) {
			throw new VMEvaluationException(
					"Incompatible types found. Expected " + type + ", but got "
							+ value.getTypeName());
		}
		if (isFinal) {
			env.addFinalBinding(name, value, type);
		} else {
			env.addBinding(name, value, type);
		}
		return null;
	}

}

package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMClass;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMClassInstance;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

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
			final VMClass declClass = VMClass.getClasses().get(type);
			if (declClass.isAssignableFrom(inst.getVMClass())) {
				if (isFinal) {
					env.addFinalBinding(name, value, type);
				} else {
					env.addBinding(name, value, type);
				}
			} else {
				throw new VMEvaluationException(
						"Incompatible types in assignment. The specified value of type "
								+ inst.getVMClass().getName()
								+ " is not assignable to the declared type of "
								+ type);
			}
		} else {
			throw new VMEvaluationException(
					"Unknown object encountered in assignment: " + value);
		}
		return null;
	}

}

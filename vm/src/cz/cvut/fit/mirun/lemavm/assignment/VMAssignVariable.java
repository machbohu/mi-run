package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.VMUtils;

public class VMAssignVariable extends VMAssignOperator {

	private final String value;

	public VMAssignVariable(String name, String type, boolean isFinal,
			String value) {
		super(name, type, isFinal);
		if (value == null) {
			throw new NullPointerException();
		}
		this.value = value;
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		final Object val = env.getBinding(value, Object.class);
		if (val == null) {
			throw new VMEvaluationException("Binding for name " + value
					+ " not found.");
		}
		resolveType(env);
		if (VMUtils.isTypePrimitive(type)) {
			if (!VMUtils.isPrimitiveTypeCompatible(type, val)) {
				throw new VMEvaluationException(
						"Incompatible types found. Expected " + type
								+ ", but got value " + val);
			}
			if (isFinal) {
				env.addPrimitiveFinalBinding(name, val, type);
			} else {
				env.addPrimitiveBinding(name, val, type);
			}
		} else {
			if (!VMUtils.isReferenceTypeCompatible(type, val)) {
				throw new VMEvaluationException(
						"Incompatible types found. Expected " + type
								+ ", but got value " + val);
			}
			if (isFinal) {
				env.addFinalBinding(name, (VMObject) val, type);
			} else {
				env.addBinding(name, (VMObject) val, type);
			}
		}
		return null;
	}

}

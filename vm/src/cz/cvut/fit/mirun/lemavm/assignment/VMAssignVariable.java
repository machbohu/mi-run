package cz.cvut.fit.mirun.lemavm.assignment;

import java.util.Collections;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;
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
		String runtimeType = VMUtils.getArgumentTypes(
				Collections.singletonList(val), env).get(0);
		if (VMUtils.isTypePrimitive(type)) {
			checkPrimitiveTypeCompatibility(type, runtimeType);
			if (isFinal) {
				env.addPrimitiveFinalBinding(name, value, type);
			} else {
				env.addPrimitiveBinding(name, value, type);
			}
		} else {
			if (!runtimeType.equals(VMConstants.NULL)) {
				checkReferenceTypeCompatibility(type, runtimeType, val);
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

package cz.cvut.fit.mirun.lemavm.assignment;

import java.util.Collections;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.Evaluable;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;
import cz.cvut.fit.mirun.lemavm.utils.VMUtils;

public final class VMAssignEvaluationResult extends VMAssignOperator {

	private final Evaluable value;

	public VMAssignEvaluationResult(String name, String type, boolean isFinal,
			Evaluable value) {
		super(name, type, isFinal);
		this.value = value;
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		final Object res = value.evaluate(env);
		if (res == null) {
			throw new VMEvaluationException("Method invocation " + value
					+ " did not return any value.");
		}
		resolveType(env);
		String runtimeType = VMUtils.getArgumentTypes(
				Collections.singletonList(res), env).get(0);
		if (VMUtils.isTypePrimitive(type)) {
			checkTypeCompatibility(type, runtimeType);
			if (isFinal) {
				env.addPrimitiveFinalBinding(name, value, type);
			} else {
				env.addPrimitiveBinding(name, value, type);
			}
		} else {
			if (!runtimeType.equals(VMConstants.NULL)) {
				checkTypeCompatibility(type, runtimeType);
			}
			if (isFinal) {
				env.addFinalBinding(name, (VMObject) res, type);
			} else {
				env.addBinding(name, (VMObject) res, type);
			}
		}
		return null;

	}

}

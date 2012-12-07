package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.Evaluable;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
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
			throw new VMEvaluationException("Method invocation '" + value
					+ "' did not return any value.");
		}
		resolveType(env);
		if (VMUtils.isTypePrimitive(type)) {
			if (!VMUtils.isPrimitiveTypeCompatible(type, res)) {
				throw new VMEvaluationException(
						"Incompatible types found. Expected " + type
								+ ", but got value " + res);
			}
			if (isFinal) {
				env.addPrimitiveFinalBinding(name, res, type);
			} else {
				env.addPrimitiveBinding(name, res, type);
			}
		} else {
			if (!VMUtils.isReferenceTypeCompatible(type, res)) {
				throw new VMEvaluationException(
						"Incompatible types found. Expected " + type
								+ ", but got value " + res);
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

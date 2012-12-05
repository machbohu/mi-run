package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;

public final class VMAssignExpr extends VMAssignOperator {

	private final VMOperator value;

	public VMAssignExpr(String name, String type, boolean isFinal,
			VMOperator value) {
		super(name, type, isFinal);
		this.value = value;
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		resolveType(env);
		switch (type) {
		case VMConstants.BOOLEAN:
			final Boolean b = value.evaluateBoolean(env);
			if (isFinal) {
				env.addPrimitiveFinalBinding(name, b, type);
			} else {
				env.addPrimitiveBinding(name, b, type);
			}
			break;
		case VMConstants.SHORT:
			final Short s = value.evaluateShort(env);
			if (isFinal) {
				env.addPrimitiveFinalBinding(name, s, type);
			} else {
				env.addPrimitiveBinding(name, s, type);
			}
			break;
		case VMConstants.INT:
			final Integer i = value.evaluateInt(env);
			if (isFinal) {
				env.addPrimitiveFinalBinding(name, i, type);
			} else {
				env.addPrimitiveBinding(name, i, type);
			}
			break;
		case VMConstants.LONG:
			final Long l = value.evaluateLong(env);
			if (isFinal) {
				env.addPrimitiveFinalBinding(name, l, type);
			} else {
				env.addPrimitiveBinding(name, l, type);
			}
			break;
		case VMConstants.DOUBLE:
			final Double d = value.evaluateDouble(env);
			if (isFinal) {
				env.addPrimitiveFinalBinding(name, d, type);
			} else {
				env.addPrimitiveBinding(name, d, type);
			}
			break;
		case VMConstants.STRING:
			final VMString str = value.evaluateString(env);
			if (isFinal) {
				env.addFinalBinding(name, str, type);
			} else {
				env.addBinding(name, str, type);
			}
			break;
		default:
			// This shouldn't happen
			throw new VMEvaluationException(
					"Incopatible types in assignment. Expected " + type
							+ ", but got " + value);
		}
		return null;
	}

}

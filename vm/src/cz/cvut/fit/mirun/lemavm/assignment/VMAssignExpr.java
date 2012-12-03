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
			final boolean b = value.evaluateBoolean(env);
			if (isFinal) {
				env.addPrimitiveFinalBinding(name, Boolean.valueOf(b), type);
			} else {
				env.addPrimitiveBinding(name, Boolean.valueOf(b), type);
			}
			break;
		case VMConstants.SHORT:
			final short s = value.evaluateShort(env);
			if (isFinal) {
				env.addPrimitiveFinalBinding(name, Short.valueOf(s), type);
			} else {
				env.addPrimitiveBinding(name, Short.valueOf(s), type);
			}
			break;
		case VMConstants.INT:
			final int i = value.evaluateInt(env);
			if (isFinal) {
				env.addPrimitiveFinalBinding(name, Integer.valueOf(i), type);
			} else {
				env.addPrimitiveBinding(name, Integer.valueOf(i), type);
			}
			break;
		case VMConstants.LONG:
			final long l = value.evaluateLong(env);
			if (isFinal) {
				env.addPrimitiveFinalBinding(name, Long.valueOf(l), type);
			} else {
				env.addPrimitiveBinding(name, Long.valueOf(l), type);
			}
			break;
		case VMConstants.DOUBLE:
			final double d = value.evaluateDouble(env);
			if (isFinal) {
				env.addPrimitiveFinalBinding(name, Double.valueOf(d), type);
			} else {
				env.addPrimitiveBinding(name, Double.valueOf(d), type);
			}
			break;
		case VMConstants.STRING:
			final VMString str = value.evaluateString(env);
			if (isFinal) {
				env.addFinalBinding(name, str, type);
			} else {
				env.addBinding(name, str, type);
			}
		default:
			// This shouldn't happen
			throw new VMEvaluationException(
					"Incopatible types in assignment. Expected " + type
							+ ", but got " + value);
		}
		return null;
	}

}

package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.core.VMConstants;
import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

public final class VMAssignExpr extends VMAssignOperator {

	private final VMOperator value;

	public VMAssignExpr(String name, String type, VMEnvironment environment,
			boolean isFinal, VMOperator value) {
		super(name, type, environment, isFinal);
		this.value = value;
	}

	@Override
	public void evaluate() {
		resolveType();
		switch (type) {
		case VMConstants.BOOLEAN:
			final boolean b = value.evaluateBoolean();
			if (isFinal) {
				environment.addPrimitiveFinalBinding(name, Boolean.valueOf(b),
						type);
			} else {
				environment.addPrimitiveBinding(name, Boolean.valueOf(b), type);
			}
			break;
		case VMConstants.SHORT:
			final short s = value.evaluateShort();
			if (isFinal) {
				environment.addPrimitiveFinalBinding(name, Short.valueOf(s),
						type);
			} else {
				environment.addPrimitiveBinding(name, Short.valueOf(s), type);
			}
			break;
		case VMConstants.INT:
			final int i = value.evaluateInt();
			if (isFinal) {
				environment.addPrimitiveFinalBinding(name, Integer.valueOf(i),
						type);
			} else {
				environment.addPrimitiveBinding(name, Integer.valueOf(i), type);
			}
			break;
		case VMConstants.LONG:
			final long l = value.evaluateLong();
			if (isFinal) {
				environment.addPrimitiveFinalBinding(name, Long.valueOf(l),
						type);
			} else {
				environment.addPrimitiveBinding(name, Long.valueOf(l), type);
			}
			break;
		case VMConstants.DOUBLE:
			final double d = value.evaluateDouble();
			if (isFinal) {
				environment.addPrimitiveFinalBinding(name, Double.valueOf(d),
						type);
			} else {
				environment.addPrimitiveBinding(name, Double.valueOf(d), type);
			}
			break;
		case VMConstants.STRING:
			final VMString str = value.evaluateString();
			if (isFinal) {
				environment.addFinalBinding(name, str, type);
			} else {
				environment.addBinding(name, str, type);
			}
		default:
			// This shouldn't happen
			throw new VMEvaluationException(
					"Incopatible types in assignment. Expected " + type
							+ ", but got " + value);
		}
	}

}

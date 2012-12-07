package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.VMUtils;

public final class VMAssignNumber extends VMAssignOperator {

	private final Number value;

	public VMAssignNumber(String name, String type, boolean isFinal,
			Number value) {
		super(name, type, isFinal);
		this.value = value;
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		resolveType(env);
		if (!VMUtils.isPrimitiveTypeCompatible(type, value)) {
			throw new VMEvaluationException(
					"Incompatible types found. Expected " + type
							+ ", but got value " + value.getClass().toString());
		}
		if (isFinal) {
			env.addPrimitiveFinalBinding(name, value, type);
		} else {
			env.addPrimitiveBinding(name, value, type);
		}
		return null;
	}

}

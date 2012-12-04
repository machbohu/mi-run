package cz.cvut.fit.mirun.lemavm.structures.operators.plus;

import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

public final class VariableVariableBinaryPlus extends AbstractBinaryPlus {

	private final String opOne;
	private final String opTwo;

	public VariableVariableBinaryPlus(String opOne, String opTwo) {
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		final Number valOne = getBindingValue(opOne, Number.class, env);
		final Number valTwo = getBindingValue(opTwo, Number.class, env);
		return (valOne.doubleValue() + valTwo.doubleValue());
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		final Number valOne = getBindingValue(opOne, Number.class, env);
		final Number valTwo = getBindingValue(opTwo, Number.class, env);
		return (valOne.longValue() + valTwo.longValue());
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		final Number valOne = getBindingValue(opOne, Number.class, env);
		final Number valTwo = getBindingValue(opTwo, Number.class, env);
		return (valOne.intValue() + valTwo.intValue());
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		final Number valOne = getBindingValue(opOne, Number.class, env);
		final Number valTwo = getBindingValue(opTwo, Number.class, env);
		return (short) (valOne.shortValue() + valTwo.shortValue());
	}

	@Override
	public VMString evaluateString(VMEnvironment env) {
		final Object valOne = getBindingValue(opOne, Object.class, env);
		final Object valTwo = getBindingValue(opTwo, Object.class, env);
		String res = null;
		if (valOne instanceof VMString) {
			res = ((VMString) valOne).getValue();
		} else {
			res = valOne.toString();
		}
		if (valTwo instanceof VMString) {
			res += ((VMString) valTwo).getValue();
		} else {
			res += valTwo.toString();
		}
		return new VMString(res);
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		final Object valOne = getBindingValue(opOne, Object.class, env);
		final Object valTwo = getBindingValue(opTwo, Object.class, env);
		if (valOne instanceof VMString || valTwo instanceof VMString) {
			return evaluateString(env);
		} else {
			return addNumbers((Number) valOne, (Number) valTwo);
		}
	}
}

package cz.cvut.fit.mirun.lemavm.structures.operators.plus;

import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

public final class NumberVariableBinaryPlus extends AbstractBinaryPlus {

	private final Number opOne;
	private final String opTwo;

	public NumberVariableBinaryPlus(Number opOne, String opTwo) {
		super();
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		final Number n = getBindingValue(opTwo, Number.class, env);
		return (opOne.doubleValue() + n.doubleValue());
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		final Number n = getBindingValue(opTwo, Number.class, env);
		return (opOne.longValue() + n.longValue());
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		final Number n = getBindingValue(opTwo, Number.class, env);
		return (opOne.intValue() + n.intValue());
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		final Number n = getBindingValue(opTwo, Number.class, env);
		return (short) (opOne.shortValue() + n.shortValue());
	}

	@Override
	public VMString evaluateString(VMEnvironment env) {
		final Object ob = getBindingValue(opTwo, Object.class, env);
		String str = null;
		if (ob instanceof VMString) {
			str = ((VMString) ob).getValue();
		} else {
			str = ob.toString();
		}
		return new VMString(opOne.toString() + str);
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		final Object ob = getBindingValue(opTwo, Object.class, env);
		if (ob instanceof VMString) {
			return evaluateString(env);
		}
		return addNumbers(opOne, (Number) ob);
	}

}

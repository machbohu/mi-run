package cz.cvut.fit.mirun.lemavm.structures.operators.plus;

import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

public final class VariableNumberBinaryPlus extends AbstractBinaryPlus {

	private final String opOne;
	private final Number opTwo;

	public VariableNumberBinaryPlus(String opOne, Number opTwo) {
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		final Number n = getBindingValue(opOne, Number.class, env);
		return (n.doubleValue() + opTwo.doubleValue());
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		final Number n = getBindingValue(opOne, Number.class, env);
		return (n.longValue() + opTwo.longValue());
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		final Number n = getBindingValue(opOne, Number.class, env);
		return (n.intValue() + opTwo.intValue());
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		final Number n = getBindingValue(opOne, Number.class, env);
		return (short) (n.shortValue() + opTwo.shortValue());
	}

	@Override
	public VMString evaluateString(VMEnvironment env) {
		final Object ob = getBindingValue(opOne, Object.class, env);
		String str = null;
		if (ob instanceof VMString) {
			str = ((VMString) ob).getValue();
		} else {
			str = ob.toString();
		}
		return new VMString(str + opTwo.toString());
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		final Object ob = getBindingValue(opOne, Object.class, env);
		if (ob instanceof VMString) {
			return evaluateString(env);
		}
		return evaluateInt(env);
	}
}

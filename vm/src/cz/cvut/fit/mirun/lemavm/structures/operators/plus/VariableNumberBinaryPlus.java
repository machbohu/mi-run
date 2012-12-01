package cz.cvut.fit.mirun.lemavm.structures.operators.plus;

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
}

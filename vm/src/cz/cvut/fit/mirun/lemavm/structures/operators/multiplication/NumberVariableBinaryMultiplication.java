package cz.cvut.fit.mirun.lemavm.structures.operators.multiplication;

import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

public final class NumberVariableBinaryMultiplication extends
		AbstractBinaryMultiplication {

	private final Number opOne;
	private final String opTwo;

	public NumberVariableBinaryMultiplication(Number opOne, String opTwo) {
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		final Number n = getBindingValue(opTwo, Number.class, env);
		return (opOne.doubleValue() * n.doubleValue());
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		final Number n = getBindingValue(opTwo, Number.class, env);
		return (opOne.longValue() * n.longValue());
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		final Number n = getBindingValue(opTwo, Number.class, env);
		return (opOne.intValue() * n.intValue());
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		final Number n = getBindingValue(opTwo, Number.class, env);
		return (short) (opOne.shortValue() * n.shortValue());
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		final Number nTwo = getBindingValue(opTwo, Number.class, env);
		return multiplyNumbers(opOne, nTwo);
	}
}

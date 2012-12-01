package cz.cvut.fit.mirun.lemavm.structures.operators.multiplication;

import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

public final class VariableVariableBinaryMultiplication extends AbstractBinaryMultiplication {

	private final String opOne;
	private final String opTwo;

	public VariableVariableBinaryMultiplication(String opOne, String opTwo) {
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		final Number valOne = getBindingValue(opOne, Number.class, env);
		final Number valTwo = getBindingValue(opTwo, Number.class, env);
		return (valOne.doubleValue() * valTwo.doubleValue());
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		final Number valOne = getBindingValue(opOne, Number.class, env);
		final Number valTwo = getBindingValue(opTwo, Number.class, env);
		return (valOne.longValue() * valTwo.longValue());
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		final Number valOne = getBindingValue(opOne, Number.class, env);
		final Number valTwo = getBindingValue(opTwo, Number.class, env);
		return (valOne.intValue() * valTwo.intValue());
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		final Number valOne = getBindingValue(opOne, Number.class, env);
		final Number valTwo = getBindingValue(opTwo, Number.class, env);
		return (short) (valOne.shortValue() * valTwo.shortValue());
	}
}

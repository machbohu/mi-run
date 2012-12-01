package cz.cvut.fit.mirun.lemavm.structures.operators.division;

import cz.cvut.fit.mirun.lemavm.exceptions.VMDivisionByZeroException;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

public final class VariableVariableBinaryDivision extends
		AbstractBinaryDivision {

	private final String opOne;
	private final String opTwo;

	public VariableVariableBinaryDivision(String opOne, String opTwo) {
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		final Number valOne = getBindingValue(opOne, Number.class, env);
		final Number valTwo = getBindingValue(opTwo, Number.class, env);
		return (valOne.doubleValue() / valTwo.doubleValue());
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		final Number valOne = getBindingValue(opOne, Number.class, env);
		final Number valTwo = getBindingValue(opTwo, Number.class, env);
		if (valTwo.longValue() == 0) {
			throw new VMDivisionByZeroException();
		}
		return (valOne.longValue() / valTwo.longValue());
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		final Number valOne = getBindingValue(opOne, Number.class, env);
		final Number valTwo = getBindingValue(opTwo, Number.class, env);
		if (valTwo.intValue() == 0) {
			throw new VMDivisionByZeroException();
		}
		return (valOne.intValue() / valTwo.intValue());
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		final Number valOne = getBindingValue(opOne, Number.class, env);
		final Number valTwo = getBindingValue(opTwo, Number.class, env);
		if (valTwo.shortValue() == 0) {
			throw new VMDivisionByZeroException();
		}
		return (short) (valOne.shortValue() / valTwo.shortValue());
	}
}

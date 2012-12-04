package cz.cvut.fit.mirun.lemavm.structures.operators.division;

import cz.cvut.fit.mirun.lemavm.exceptions.VMDivisionByZeroException;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

public final class NumberVariableBinaryDivision extends AbstractBinaryDivision {

	private final Number opOne;
	private final String opTwo;

	public NumberVariableBinaryDivision(Number opOne, String opTwo) {
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		final Number n = getBindingValue(opTwo, Number.class, env);
		return (opOne.doubleValue() / n.doubleValue());
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		final Number n = getBindingValue(opTwo, Number.class, env);
		if (n.longValue() == 0) {
			throw new VMDivisionByZeroException();
		}
		return (opOne.longValue() / n.longValue());
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		final Number n = getBindingValue(opTwo, Number.class, env);
		if (n.intValue() == 0) {
			throw new VMDivisionByZeroException();
		}
		return (opOne.intValue() / n.intValue());
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		final Number n = getBindingValue(opTwo, Number.class, env);
		if (n.shortValue() == 0) {
			throw new VMDivisionByZeroException();
		}
		return (short) (opOne.shortValue() / n.shortValue());
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		final Number nTwo = getBindingValue(opTwo, Number.class, env);
		return divideNumbers(opOne, nTwo);
	}
}

package cz.cvut.fit.mirun.lemavm.structures.operators.division;

import cz.cvut.fit.mirun.lemavm.exceptions.VMDivisionByZeroException;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

public final class VariableNumberBinaryDivision extends AbstractBinaryDivision {

	private final String opOne;
	private final Number opTwo;

	public VariableNumberBinaryDivision(String opOne, Number opTwo) {
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		final Number n = getBindingValue(opOne, Number.class, env);
		return (n.doubleValue() / opTwo.doubleValue());
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		if (opTwo.longValue() == 0) {
			throw new VMDivisionByZeroException();
		}
		final Number n = getBindingValue(opOne, Number.class, env);
		return (n.longValue() / opTwo.longValue());
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		if (opTwo.intValue() == 0) {
			throw new VMDivisionByZeroException();
		}
		final Number n = getBindingValue(opOne, Number.class, env);
		return (n.intValue() / opTwo.intValue());
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		if (opTwo.shortValue() == 0) {
			throw new VMDivisionByZeroException();
		}
		final Number n = getBindingValue(opOne, Number.class, env);
		return (short) (n.shortValue() / opTwo.shortValue());
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		return evaluateInt(env);
	}
}

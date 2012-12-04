package cz.cvut.fit.mirun.lemavm.structures.operators.division;

import cz.cvut.fit.mirun.lemavm.exceptions.VMDivisionByZeroException;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

public final class NumberNumberBinaryDivision extends AbstractBinaryDivision {

	private final Number opOne;
	private final Number opTwo;

	public NumberNumberBinaryDivision(Number opOne, Number opTwo) {
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		return (opOne.doubleValue() / opTwo.doubleValue());
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		if (opTwo.longValue() == 0) {
			throw new VMDivisionByZeroException();
		}
		return (opOne.longValue() / opTwo.longValue());
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		if (opTwo.intValue() == 0) {
			throw new VMDivisionByZeroException();
		}
		return (opOne.intValue() / opTwo.intValue());
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		if (opTwo.shortValue() == 0) {
			throw new VMDivisionByZeroException();
		}
		return (short) (opOne.intValue() / opTwo.intValue());
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		return divideNumbers(opOne, opTwo);
	}
}

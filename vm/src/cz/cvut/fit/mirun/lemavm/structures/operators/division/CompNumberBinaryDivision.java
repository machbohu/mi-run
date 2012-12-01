package cz.cvut.fit.mirun.lemavm.structures.operators.division;

import cz.cvut.fit.mirun.lemavm.exceptions.VMDivisionByZeroException;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class CompNumberBinaryDivision extends AbstractBinaryDivision {

	private final VMOperator opOne;
	private final Number opTwo;

	public CompNumberBinaryDivision(VMOperator opOne, Number opTwo) {
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		return (opOne.evaluateDouble(env).doubleValue() / opTwo.doubleValue());
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		if (opTwo.longValue() == 0) {
			throw new VMDivisionByZeroException();
		}
		return (opOne.evaluateLong(env).longValue() / opTwo.longValue());
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		if (opTwo.intValue() == 0) {
			throw new VMDivisionByZeroException();
		}
		return (opOne.evaluateInt(env).intValue() / opTwo.intValue());
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		if (opTwo.shortValue() == 0) {
			throw new VMDivisionByZeroException();
		}
		return (short) (opOne.evaluateShort(env).shortValue() / opTwo
				.shortValue());
	}

}

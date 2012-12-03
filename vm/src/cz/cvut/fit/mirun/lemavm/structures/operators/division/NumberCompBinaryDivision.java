package cz.cvut.fit.mirun.lemavm.structures.operators.division;

import cz.cvut.fit.mirun.lemavm.exceptions.VMDivisionByZeroException;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class NumberCompBinaryDivision extends AbstractBinaryDivision {

	private final Number opOne;
	private final VMOperator opTwo;

	public NumberCompBinaryDivision(Number opOne, VMOperator opTwo) {
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		return (opOne.doubleValue() / opTwo.evaluateDouble(env).doubleValue());
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		final long n = opTwo.evaluateLong(env).longValue();
		if (n == 0) {
			throw new VMDivisionByZeroException();
		}
		return (opOne.longValue() / n);
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		final int n = opTwo.evaluateInt(env).intValue();
		if (n == 0) {
			throw new VMDivisionByZeroException();
		}
		return (opOne.intValue() / n);
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		final short n = opTwo.evaluateShort(env).shortValue();
		if (n == 0) {
			throw new VMDivisionByZeroException();
		}
		return (short) (opOne.shortValue() / n);
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		return evaluateInt(env);
	}
}

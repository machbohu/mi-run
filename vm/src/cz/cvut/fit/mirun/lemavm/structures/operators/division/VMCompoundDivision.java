package cz.cvut.fit.mirun.lemavm.structures.operators.division;

import cz.cvut.fit.mirun.lemavm.exceptions.VMDivisionByZeroException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class VMCompoundDivision extends AbstractBinaryDivision {

	private final VMOperator opOne;
	private final VMOperator opTwo;

	public VMCompoundDivision(VMOperator opOne, VMOperator opTwo) {
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		Double dOne = opOne.evaluateDouble(env);
		Double dTwo = opTwo.evaluateDouble(env);
		return Double.valueOf(dOne.doubleValue() / dTwo.doubleValue());
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		Long dOne = opOne.evaluateLong(env);
		Long dTwo = opTwo.evaluateLong(env);
		if (dTwo == 0) {
			throw new VMDivisionByZeroException();
		}
		return Long.valueOf(dOne.longValue() / dTwo.longValue());
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		Integer dOne = opOne.evaluateInt(env);
		Integer dTwo = opTwo.evaluateInt(env);
		if (dTwo == 0) {
			throw new VMDivisionByZeroException();
		}
		return Integer.valueOf(dOne.intValue() / dTwo.intValue());
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		Short dOne = opOne.evaluateShort(env);
		Short dTwo = opTwo.evaluateShort(env);
		if (dTwo == 0) {
			throw new VMDivisionByZeroException();
		}
		return Short.valueOf((short) (dOne.shortValue() / dTwo.shortValue()));
	}

	@Override
	public Boolean evaluateBoolean(VMEnvironment env) {
		throw new VMEvaluationException("Operator cannot return boolean value.");
	}

	@Override
	public VMString evaluateString(VMEnvironment env) {
		return new VMString(evaluate(env).toString());
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		final Number nOne = (Number) opOne.evaluate(env);
		final Number nTwo = (Number) opTwo.evaluate(env);
		return divideNumbers(nOne, nTwo);
	}
}

package cz.cvut.fit.mirun.lemavm.structures.operators.multiplication;

import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class CompNumberBinaryMultiplication extends
		AbstractBinaryMultiplication {

	private final VMOperator opOne;
	private final Number opTwo;

	public CompNumberBinaryMultiplication(VMOperator opOne, Number opTwo) {
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		return (opOne.evaluateDouble(env).doubleValue() * opTwo.doubleValue());
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		return (opOne.evaluateLong(env).longValue() * opTwo.longValue());
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		return (opOne.evaluateInt(env).intValue() * opTwo.intValue());
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		return (short) (opOne.evaluateShort(env).shortValue() * opTwo
				.shortValue());
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		return evaluateInt(env);
	}
}

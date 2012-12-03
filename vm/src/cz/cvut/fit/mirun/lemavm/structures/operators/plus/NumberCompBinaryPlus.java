package cz.cvut.fit.mirun.lemavm.structures.operators.plus;

import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class NumberCompBinaryPlus extends AbstractBinaryPlus {

	private final Number opOne;
	private final VMOperator opTwo;

	public NumberCompBinaryPlus(Number opOne, VMOperator opTwo) {
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		return (opOne.doubleValue() + opTwo.evaluateDouble(env).doubleValue());
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		return (opOne.longValue() + opTwo.evaluateLong(env).longValue());
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		return (opOne.intValue() + opTwo.evaluateInt(env).intValue());
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		return (short) (opOne.shortValue() + opTwo.evaluateShort(env)
				.shortValue());
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		return evaluateInt(env);
	}
}

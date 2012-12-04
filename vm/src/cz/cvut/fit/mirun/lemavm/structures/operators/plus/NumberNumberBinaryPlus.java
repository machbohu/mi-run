package cz.cvut.fit.mirun.lemavm.structures.operators.plus;

import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

public final class NumberNumberBinaryPlus extends AbstractBinaryPlus {

	private final Number opOne;
	private final Number opTwo;

	public NumberNumberBinaryPlus(Number opOne, Number opTwo) {
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		return (opOne.doubleValue() + opTwo.doubleValue());
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		return (opOne.longValue() + opTwo.longValue());
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		return (opOne.intValue() + opTwo.intValue());
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		return (short) (opOne.intValue() + opTwo.intValue());
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		return addNumbers(opOne, opTwo);
	}
}

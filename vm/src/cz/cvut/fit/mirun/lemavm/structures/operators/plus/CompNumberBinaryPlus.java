package cz.cvut.fit.mirun.lemavm.structures.operators.plus;

import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class CompNumberBinaryPlus extends AbstractBinaryPlus {

	private final VMOperator opOne;
	private final Number opTwo;

	public CompNumberBinaryPlus(VMOperator opOne, Number opTwo) {
		super();
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		return (opOne.evaluateDouble(env).doubleValue() + opTwo.doubleValue());
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		return (opOne.evaluateLong(env).longValue() + opTwo.longValue());
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		return (opOne.evaluateInt(env).intValue() + opTwo.intValue());
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		return (short) (opOne.evaluateShort(env).shortValue() + opTwo
				.shortValue());
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		Object res = opOne.evaluate(env);
		if (res instanceof VMString) {
			return new VMString(((VMString) res).getValue() + opTwo.toString());
		}
		return addNumbers((Number) res, opTwo);
	}

}

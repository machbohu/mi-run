package cz.cvut.fit.mirun.lemavm.structures.operators.multiplication;

import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class CompVariableBinaryMultiplication extends
		AbstractBinaryMultiplication {

	private final VMOperator opOne;
	private final String opTwo;

	public CompVariableBinaryMultiplication(VMOperator opOne, String opTwo) {
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		final Number n = getBindingValue(opTwo, Number.class, env);
		return (opOne.evaluateDouble(env).doubleValue() * n.doubleValue());
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		final Number n = getBindingValue(opTwo, Number.class, env);
		return (opOne.evaluateLong(env).longValue() * n.longValue());
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		final Number n = getBindingValue(opTwo, Number.class, env);
		return (opOne.evaluateInt(env).intValue() * n.intValue());
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		final Number n = getBindingValue(opTwo, Number.class, env);
		return (short) (opOne.evaluateShort(env).shortValue() * n.shortValue());
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		final Number nOne = (Number) opOne.evaluate(env);
		final Number nTwo = getBindingValue(opTwo, Number.class, env);
		return multiplyNumbers(nOne, nTwo);
	}
}

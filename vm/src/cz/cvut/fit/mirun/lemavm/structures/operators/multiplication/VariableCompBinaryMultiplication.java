package cz.cvut.fit.mirun.lemavm.structures.operators.multiplication;

import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class VariableCompBinaryMultiplication extends
		AbstractBinaryMultiplication {

	private final String opOne;
	private final VMOperator opTwo;

	public VariableCompBinaryMultiplication(String opOne, VMOperator opTwo) {
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		final Number n = getBindingValue(opOne, Number.class, env);
		return (n.doubleValue() * opTwo.evaluateDouble(env).doubleValue());
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		final Number n = getBindingValue(opOne, Number.class, env);
		return (n.longValue() * opTwo.evaluateLong(env).longValue());
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		final Number n = getBindingValue(opOne, Number.class, env);
		return (n.intValue() * opTwo.evaluateInt(env).intValue());
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		final Number n = getBindingValue(opOne, Number.class, env);
		return (short) (n.shortValue() * opTwo.evaluateShort(env).shortValue());
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		final Number nOne = getBindingValue(opOne, Number.class, env);
		final Number nTwo = (Number) opTwo.evaluate(env);
		return multiplyNumbers(nOne, nTwo);
	}
}

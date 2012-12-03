package cz.cvut.fit.mirun.lemavm.structures.operators.division;

import cz.cvut.fit.mirun.lemavm.exceptions.VMDivisionByZeroException;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class VariableCompBinaryDivision extends AbstractBinaryDivision {

	private final String opOne;
	private final VMOperator opTwo;

	public VariableCompBinaryDivision(String opOne, VMOperator opTwo) {
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		final Number n = getBindingValue(opOne, Number.class, env);
		return (n.doubleValue() / opTwo.evaluateDouble(env).doubleValue());
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		final Number n = getBindingValue(opOne, Number.class, env);
		final long nTwo = opTwo.evaluateLong(env).longValue();
		if (nTwo == 0) {
			throw new VMDivisionByZeroException();
		}
		return (n.longValue() / nTwo);
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		final Number n = getBindingValue(opOne, Number.class, env);
		final int nTwo = opTwo.evaluateInt(env).intValue();
		if (nTwo == 0) {
			throw new VMDivisionByZeroException();
		}
		return (n.intValue() / nTwo);
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		final Number n = getBindingValue(opOne, Number.class, env);
		final short nTwo = opTwo.evaluateShort(env).shortValue();
		if (nTwo == 0) {
			throw new VMDivisionByZeroException();
		}
		return (short) (n.shortValue() / nTwo);
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		return evaluateInt(env);
	}
}

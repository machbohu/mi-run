package cz.cvut.fit.mirun.lemavm.structures.operators.division;

import cz.cvut.fit.mirun.lemavm.exceptions.VMDivisionByZeroException;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class CompVariableBinaryDivision extends AbstractBinaryDivision {

	private final VMOperator opOne;
	private final String opTwo;

	public CompVariableBinaryDivision(VMOperator opOne, String opTwo) {
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		final Number n = getBindingValue(opTwo, Number.class, env);
		return (opOne.evaluateDouble(env).doubleValue() / n.doubleValue());
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		final Number n = getBindingValue(opTwo, Number.class, env);
		if (n.longValue() == 0) {
			throw new VMDivisionByZeroException();
		}
		return (opOne.evaluateLong(env).longValue() / n.longValue());
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		final Number n = getBindingValue(opTwo, Number.class, env);
		if (n.intValue() == 0) {
			throw new VMDivisionByZeroException();
		}
		return (opOne.evaluateInt(env).intValue() / n.intValue());
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		final Number n = getBindingValue(opTwo, Number.class, env);
		if (n.shortValue() == 0) {
			throw new VMDivisionByZeroException();
		}
		return (short) (opOne.evaluateShort(env).shortValue() / n.shortValue());
	}
}

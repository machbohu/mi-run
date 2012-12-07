package cz.cvut.fit.mirun.lemavm.structures.operators.plus;

import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class CompVariableBinaryPlus extends AbstractBinaryPlus {

	private final VMOperator opOne;
	private final String opTwo;

	public CompVariableBinaryPlus(VMOperator opOne, String opTwo) {
		super();
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		final Number n = getBindingValue(opTwo, Number.class, env);
		return (opOne.evaluateDouble(env).doubleValue() + n.doubleValue());
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		final Number n = getBindingValue(opTwo, Number.class, env);
		return (opOne.evaluateLong(env).longValue() + n.longValue());
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		final Number n = getBindingValue(opTwo, Number.class, env);
		return (opOne.evaluateInt(env).intValue() + n.intValue());
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		final Number n = getBindingValue(opTwo, Number.class, env);
		return (short) (opOne.evaluateShort(env).shortValue() + n.shortValue());
	}

	@Override
	public VMString evaluateString(VMEnvironment env) {
		final Object ob = getBindingValue(opTwo, Object.class, env);
		String str = null;
		if (ob instanceof VMString) {
			str = ((VMString) ob).getValue();
		} else {
			str = ob.toString();
		}
		return new VMString(opOne.evaluateString(env).getValue() + str);
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		final Object ob = getBindingValue(opTwo, Object.class, env);
		if (ob instanceof VMString) {
			return evaluateString(env);
		}
		final Object res = opOne.evaluate(env);
		if (res instanceof VMString) {
			return new VMString(((VMString) res).getValue() + ob.toString());
		}
		return addNumbers((Number) res, (Number) ob);
	}

}

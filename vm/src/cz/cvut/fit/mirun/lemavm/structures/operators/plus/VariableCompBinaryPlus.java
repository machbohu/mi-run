package cz.cvut.fit.mirun.lemavm.structures.operators.plus;

import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class VariableCompBinaryPlus extends AbstractBinaryPlus {

	private final String opOne;
	private final VMOperator opTwo;

	public VariableCompBinaryPlus(String opOne, VMOperator opTwo) {
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		final Number n = getBindingValue(opOne, Number.class, env);
		return (n.doubleValue() + opTwo.evaluateDouble(env).doubleValue());
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		final Number n = getBindingValue(opOne, Number.class, env);
		return (n.longValue() + opTwo.evaluateLong(env).longValue());
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		final Number n = getBindingValue(opOne, Number.class, env);
		return (n.intValue() + opTwo.evaluateInt(env).intValue());
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		final Number n = getBindingValue(opOne, Number.class, env);
		return (short) (n.shortValue() + opTwo.evaluateShort(env).shortValue());
	}

	@Override
	public VMString evaluateString(VMEnvironment env) {
		final Object ob = getBindingValue(opOne, Object.class, env);
		String str = null;
		if (ob instanceof VMString) {
			str = ((VMString) ob).getValue();
		} else {
			str = ob.toString();
		}
		return new VMString(str + opTwo.evaluateString(env).getValue());
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		final Object ob = getBindingValue(opOne, Object.class, env);
		if (ob instanceof VMString) {
			return evaluateString(env);
		}
		final Object res = opTwo.evaluate(env);
		if (res instanceof VMString) {
			return new VMString(ob.toString() + ((VMString) res).getValue());
		}
		return addNumbers((Number) ob, (Number) res);
	}
}

package cz.cvut.fit.mirun.lemavm.structures.operators.plus;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class VMStringCompBinaryPlus extends AbstractBinaryPlus {

	private final VMString opOne;
	private final VMOperator opTwo;

	public VMStringCompBinaryPlus(VMString opOne, VMOperator opTwo) {
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		throw new VMEvaluationException(
				"Operand of type String cannot be converted to double.");
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		throw new VMEvaluationException(
				"Operand of type String cannot be converted to long.");
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		throw new VMEvaluationException(
				"Operand of type String cannot be converted to int.");
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		throw new VMEvaluationException(
				"Operand of type String cannot be converted to short.");
	}

	@Override
	public VMString evaluateString(VMEnvironment env) {
		final Double d = opTwo.evaluateDouble(env);
		if (Math.abs(d.doubleValue()) - Math.abs(d.longValue()) != 0) {
			// It is a double
			return new VMString(opOne.getValue() + d.toString());
		}
		// It is an integral number
		return new VMString(opOne.getValue()
				+ opTwo.evaluateLong(env).toString());
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		return evaluateInt(env);
	}
}

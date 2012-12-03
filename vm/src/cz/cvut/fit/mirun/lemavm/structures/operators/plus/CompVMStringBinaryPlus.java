package cz.cvut.fit.mirun.lemavm.structures.operators.plus;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class CompVMStringBinaryPlus extends AbstractBinaryPlus {

	private final VMOperator opOne;
	private final VMString opTwo;

	public CompVMStringBinaryPlus(VMOperator opOne, VMString opTwo) {
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
		final Double d = opOne.evaluateDouble(env);
		if (Math.abs(d.doubleValue()) - Math.abs(d.longValue()) != 0) {
			// It is a double
			return new VMString(d.toString() + opTwo.getValue());
		}
		// It is an integral number
		return new VMString(opOne.evaluateLong(env).toString()
				+ opTwo.getValue());
	}
	
	@Override
	public Object evaluate(VMEnvironment env) {
		return evaluateInt(env);
	}
}

package cz.cvut.fit.mirun.lemavm.structures.operators.plus;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

public final class VMStringNumberBinaryPlus extends AbstractBinaryPlus {

	private final VMString opOne;
	private final Number opTwo;

	public VMStringNumberBinaryPlus(VMString opOne, Number opTwo) {
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
		return new VMString(opOne.getValue() + opTwo.toString());
	}
}

package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.operators.compounds.VMCompoundNegation;

public final class VMUnaryNegationOperatorFactory implements
		VMUnaryOperatorFactory {

	@Override
	public VMOperator createOperator(VMOperator op) {
		return new VMCompoundNegation(op);
	}

	@Override
	public VMOperator createOperator(double op) {
		throw new VMParsingException(
				"The ! operator is not applicable for type double.");
	}

	@Override
	public VMOperator createOperator(long op) {
		throw new VMParsingException(
				"The ! operator is not applicable for type long.");
	}

	@Override
	public VMOperator createOperator(int op) {
		throw new VMParsingException(
				"The ! operator is not applicable for type int.");
	}

	@Override
	public VMOperator createOperator(short op) {
		throw new VMParsingException(
				"The ! operator is not applicable for type short.");
	}

	@Override
	public VMOperator createOperator(boolean op) {
		// TODO Auto-generated method stub
		return null;
	}
}

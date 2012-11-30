package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.operators.compounds.VMCompoundPrefixIncrement;

public final class VMPrefixIncrementOperatorFactory implements
		VMUnaryOperatorFactory {

	@Override
	public VMOperator createOperator(VMOperator op) {
		return new VMCompoundPrefixIncrement(op);
	}

	@Override
	public VMOperator createOperator(boolean op) {
		throw new VMParsingException(
				"The prefix increment operator is not applicable for type boolean.");
	}

	@Override
	public VMOperator createOperator(Number op) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VMOperator createOperator(String op) {
		// TODO Auto-generated method stub
		return null;
	}
}

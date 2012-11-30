package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.operators.compounds.VMCompoundPostfixDecrement;

public final class VMPostfixDecrementOperatorFactory implements
		VMUnaryOperatorFactory {

	@Override
	public VMOperator createOperator(VMOperator op) {
		return new VMCompoundPostfixDecrement(op);
	}

	@Override
	public VMOperator createOperator(boolean op) {
		throw new VMParsingException(
				"The postfix decrement operator is not applicable for type boolean.");
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

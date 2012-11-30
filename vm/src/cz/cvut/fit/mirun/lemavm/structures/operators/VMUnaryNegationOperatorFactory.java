package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.structures.operators.compounds.VMCompoundNegation;

public final class VMUnaryNegationOperatorFactory implements
		VMUnaryOperatorFactory {

	@Override
	public VMOperator createOperator(VMOperator op) {
		return new VMCompoundNegation(op);
	}

	@Override
	public VMOperator createOperator(boolean op) {
		// TODO Auto-generated method stub
		return null;
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

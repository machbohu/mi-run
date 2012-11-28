package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.operators.compounds.VMCompoundPostfixDecrement;
import cz.cvut.fit.mirun.lemavm.structures.operators.doubles.VMDoublePostfixDecrement;
import cz.cvut.fit.mirun.lemavm.structures.operators.ints.VMIntPostfixDecrement;
import cz.cvut.fit.mirun.lemavm.structures.operators.longs.VMLongPostfixDecrement;
import cz.cvut.fit.mirun.lemavm.structures.operators.shorts.VMShortPostfixDecrement;

public final class VMPostfixDecrementOperatorFactory implements
		VMUnaryOperatorFactory {

	@Override
	public VMOperator createOperator(VMOperator op) {
		return new VMCompoundPostfixDecrement(op);
	}

	@Override
	public VMOperator createOperator(double op) {
		return new VMDoublePostfixDecrement(op);
	}

	@Override
	public VMOperator createOperator(long op) {
		return new VMLongPostfixDecrement(op);
	}

	@Override
	public VMOperator createOperator(int op) {
		return new VMIntPostfixDecrement(op);
	}

	@Override
	public VMOperator createOperator(short op) {
		return new VMShortPostfixDecrement(op);
	}

	@Override
	public VMOperator createOperator(boolean op) {
		throw new VMParsingException(
				"The postfix decrement operator is not applicable for type boolean.");
	}

}

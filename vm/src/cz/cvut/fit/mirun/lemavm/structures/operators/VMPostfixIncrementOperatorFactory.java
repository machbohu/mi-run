package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.operators.compounds.VMCompoundPostfixIncrement;
import cz.cvut.fit.mirun.lemavm.structures.operators.doubles.VMDoublePostfixIncrement;
import cz.cvut.fit.mirun.lemavm.structures.operators.ints.VMIntPostfixIncrement;
import cz.cvut.fit.mirun.lemavm.structures.operators.longs.VMLongPostfixIncrement;
import cz.cvut.fit.mirun.lemavm.structures.operators.shorts.VMShortPostfixIncrement;

public final class VMPostfixIncrementOperatorFactory implements
		VMUnaryOperatorFactory {

	@Override
	public VMOperator createOperator(VMOperator op) {
		return new VMCompoundPostfixIncrement(op);
	}

	@Override
	public VMOperator createOperator(double op) {
		return new VMDoublePostfixIncrement(op);
	}

	@Override
	public VMOperator createOperator(long op) {
		return new VMLongPostfixIncrement(op);
	}

	@Override
	public VMOperator createOperator(int op) {
		return new VMIntPostfixIncrement(op);
	}

	@Override
	public VMOperator createOperator(short op) {
		return new VMShortPostfixIncrement(op);
	}

	@Override
	public VMOperator createOperator(boolean op) {
		throw new VMParsingException(
				"The postfix increment operator is not applicable for type boolean.");
	}

}

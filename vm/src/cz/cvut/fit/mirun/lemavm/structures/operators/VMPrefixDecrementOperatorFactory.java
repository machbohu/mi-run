package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.operators.compounds.VMCompoundPrefixDecrement;
import cz.cvut.fit.mirun.lemavm.structures.operators.doubles.VMDoublePrefixDecrement;
import cz.cvut.fit.mirun.lemavm.structures.operators.ints.VMIntPrefixDecrement;
import cz.cvut.fit.mirun.lemavm.structures.operators.longs.VMLongPrefixDecrement;
import cz.cvut.fit.mirun.lemavm.structures.operators.shorts.VMShortPrefixDecrement;

public final class VMPrefixDecrementOperatorFactory implements
		VMUnaryOperatorFactory {

	@Override
	public VMOperator createOperator(VMOperator op) {
		return new VMCompoundPrefixDecrement(op);
	}

	@Override
	public VMOperator createOperator(double op) {
		return new VMDoublePrefixDecrement(op);
	}

	@Override
	public VMOperator createOperator(long op) {
		return new VMLongPrefixDecrement(op);
	}

	@Override
	public VMOperator createOperator(int op) {
		return new VMIntPrefixDecrement(op);
	}

	@Override
	public VMOperator createOperator(short op) {
		return new VMShortPrefixDecrement(op);
	}

	@Override
	public VMOperator createOperator(boolean op) {
		throw new VMParsingException(
				"The prefix decrement operator is not applicable for type boolean.");
	}

}

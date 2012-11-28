package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.operators.compounds.VMCompoundPrefixIncrement;
import cz.cvut.fit.mirun.lemavm.structures.operators.doubles.VMDoublePrefixIncrement;
import cz.cvut.fit.mirun.lemavm.structures.operators.ints.VMIntPrefixIncrement;
import cz.cvut.fit.mirun.lemavm.structures.operators.longs.VMLongPrefixIncrement;
import cz.cvut.fit.mirun.lemavm.structures.operators.shorts.VMShortPrefixIncrement;

public final class VMPrefixIncrementOperatorFactory implements
		VMUnaryOperatorFactory {

	@Override
	public VMOperator createOperator(VMOperator op) {
		return new VMCompoundPrefixIncrement(op);
	}

	@Override
	public VMOperator createOperator(double op) {
		return new VMDoublePrefixIncrement(op);
	}

	@Override
	public VMOperator createOperator(long op) {
		return new VMLongPrefixIncrement(op);
	}

	@Override
	public VMOperator createOperator(int op) {
		return new VMIntPrefixIncrement(op);
	}

	@Override
	public VMOperator createOperator(short op) {
		return new VMShortPrefixIncrement(op);
	}

	@Override
	public VMOperator createOperator(boolean op) {
		throw new VMParsingException(
				"The prefix increment operator is not applicable for type boolean.");
	}
}

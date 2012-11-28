package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.operators.compounds.VMUnaryCompoundPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.doubles.VMUnaryDoublePlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.ints.VMUnaryIntPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.longs.VMUnaryLongPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.shorts.VMUnaryShortPlus;

public final class VMUnaryPlusOperatorFactory implements VMUnaryOperatorFactory {

	@Override
	public VMOperator createOperator(VMOperator op) {
		return new VMUnaryCompoundPlus(op);
	}

	@Override
	public VMOperator createOperator(double op) {
		return new VMUnaryDoublePlus(op);
	}

	@Override
	public VMOperator createOperator(long op) {
		return new VMUnaryLongPlus(op);
	}

	@Override
	public VMOperator createOperator(int op) {
		return new VMUnaryIntPlus(op);
	}

	@Override
	public VMOperator createOperator(short op) {
		return new VMUnaryShortPlus(op);
	}

	@Override
	public VMOperator createOperator(boolean op) {
		throw new VMParsingException(
				"The unary plus operator is not applicable for type boolean.");
	}

}

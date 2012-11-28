package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.operators.compounds.VMUnaryCompoundMinus;
import cz.cvut.fit.mirun.lemavm.structures.operators.doubles.VMUnaryDoubleMinus;
import cz.cvut.fit.mirun.lemavm.structures.operators.ints.VMUnaryIntMinus;
import cz.cvut.fit.mirun.lemavm.structures.operators.longs.VMUnaryLongMinus;
import cz.cvut.fit.mirun.lemavm.structures.operators.shorts.VMUnaryShortMinus;

public final class VMUnaryMinusOperatorFactory implements
		VMUnaryOperatorFactory {

	@Override
	public VMOperator createOperator(VMOperator op) {
		return new VMUnaryCompoundMinus(op);
	}

	@Override
	public VMOperator createOperator(double op) {
		return new VMUnaryDoubleMinus(op);
	}

	@Override
	public VMOperator createOperator(long op) {
		return new VMUnaryLongMinus(op);
	}

	@Override
	public VMOperator createOperator(int op) {
		return new VMUnaryIntMinus(op);
	}

	@Override
	public VMOperator createOperator(short op) {
		return new VMUnaryShortMinus(op);
	}

	@Override
	public VMOperator createOperator(boolean op) {
		throw new VMParsingException(
				"The unary minus operator is not applicable for type boolean.");
	}
}

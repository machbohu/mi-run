package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.structures.operators.compounds.VMCompoundMinus;
import cz.cvut.fit.mirun.lemavm.structures.operators.doubles.VMDoubleMinus;
import cz.cvut.fit.mirun.lemavm.structures.operators.ints.VMIntMinus;
import cz.cvut.fit.mirun.lemavm.structures.operators.longs.VMLongMinus;
import cz.cvut.fit.mirun.lemavm.structures.operators.mixed.VMDoubleCompMinus;
import cz.cvut.fit.mirun.lemavm.structures.operators.mixed.VMIntCompMinus;
import cz.cvut.fit.mirun.lemavm.structures.operators.mixed.VMLongCompMinus;
import cz.cvut.fit.mirun.lemavm.structures.operators.mixed.VMShortCompMinus;
import cz.cvut.fit.mirun.lemavm.structures.operators.shorts.VMShortMinus;

public final class VMBinaryMinusOperatorFactory implements
		VMBinaryOperatorFactory {

	@Override
	public VMOperator createOperator(VMOperator opOne, VMOperator opTwo) {
		return new VMCompoundMinus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(double opOne, double opTwo) {
		return new VMDoubleMinus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(VMOperator opOne, double opTwo) {
		return new VMDoubleCompMinus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(double opOne, VMOperator opTwo) {
		return new VMDoubleCompMinus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(long opOne, long opTwo) {
		return new VMLongMinus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(VMOperator opOne, long opTwo) {
		return new VMLongCompMinus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(long opOne, VMOperator opTwo) {
		return new VMLongCompMinus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(int opOne, int opTwo) {
		return new VMIntMinus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(VMOperator opOne, int opTwo) {
		return new VMIntCompMinus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(int opOne, VMOperator opTwo) {
		return new VMIntCompMinus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(short opOne, short opTwo) {
		return new VMShortMinus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(VMOperator opOne, short opTwo) {
		return new VMShortCompMinus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(short opOne, VMOperator opTwo) {
		return new VMShortCompMinus(opOne, opTwo);
	}
}

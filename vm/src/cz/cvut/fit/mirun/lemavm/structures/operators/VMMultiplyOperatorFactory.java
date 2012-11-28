package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.structures.operators.compounds.VMCompoundMultiply;
import cz.cvut.fit.mirun.lemavm.structures.operators.doubles.VMDoubleMultiply;
import cz.cvut.fit.mirun.lemavm.structures.operators.ints.VMIntMultiply;
import cz.cvut.fit.mirun.lemavm.structures.operators.longs.VMLongMultiply;
import cz.cvut.fit.mirun.lemavm.structures.operators.mixed.VMDoubleCompMultiply;
import cz.cvut.fit.mirun.lemavm.structures.operators.mixed.VMIntCompMultiply;
import cz.cvut.fit.mirun.lemavm.structures.operators.mixed.VMLongCompMultiply;
import cz.cvut.fit.mirun.lemavm.structures.operators.mixed.VMShortCompMultiply;
import cz.cvut.fit.mirun.lemavm.structures.operators.shorts.VMShortMultiply;

public final class VMMultiplyOperatorFactory implements VMBinaryOperatorFactory {

	@Override
	public VMOperator createOperator(VMOperator opOne, VMOperator opTwo) {
		return new VMCompoundMultiply(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(double opOne, double opTwo) {
		return new VMDoubleMultiply(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(VMOperator opOne, double opTwo) {
		return new VMDoubleCompMultiply(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(double opOne, VMOperator opTwo) {
		return new VMDoubleCompMultiply(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(long opOne, long opTwo) {
		return new VMLongMultiply(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(VMOperator opOne, long opTwo) {
		return new VMLongCompMultiply(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(long opOne, VMOperator opTwo) {
		return new VMLongCompMultiply(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(int opOne, int opTwo) {
		return new VMIntMultiply(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(VMOperator opOne, int opTwo) {
		return new VMIntCompMultiply(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(int opOne, VMOperator opTwo) {
		return new VMIntCompMultiply(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(short opOne, short opTwo) {
		return new VMShortMultiply(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(VMOperator opOne, short opTwo) {
		return new VMShortCompMultiply(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(short opOne, VMOperator opTwo) {
		return new VMShortCompMultiply(opOne, opTwo);
	}
}

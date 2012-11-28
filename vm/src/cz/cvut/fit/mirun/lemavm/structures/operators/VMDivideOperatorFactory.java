package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.structures.operators.compounds.VMCompoundDivide;
import cz.cvut.fit.mirun.lemavm.structures.operators.doubles.VMDoubleDivide;
import cz.cvut.fit.mirun.lemavm.structures.operators.ints.VMIntDivide;
import cz.cvut.fit.mirun.lemavm.structures.operators.longs.VMLongDivide;
import cz.cvut.fit.mirun.lemavm.structures.operators.mixed.VMDoubleCompDivide;
import cz.cvut.fit.mirun.lemavm.structures.operators.mixed.VMIntCompDivide;
import cz.cvut.fit.mirun.lemavm.structures.operators.mixed.VMLongCompDivide;
import cz.cvut.fit.mirun.lemavm.structures.operators.mixed.VMShortCompDivide;
import cz.cvut.fit.mirun.lemavm.structures.operators.shorts.VMShortDivide;

public final class VMDivideOperatorFactory implements VMBinaryOperatorFactory {

	@Override
	public VMOperator createOperator(VMOperator opOne, VMOperator opTwo) {
		return new VMCompoundDivide(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(double opOne, double opTwo) {
		return new VMDoubleDivide(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(VMOperator opOne, double opTwo) {
		return new VMDoubleCompDivide(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(double opOne, VMOperator opTwo) {
		return new VMDoubleCompDivide(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(long opOne, long opTwo) {
		return new VMLongDivide(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(VMOperator opOne, long opTwo) {
		return new VMLongCompDivide(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(long opOne, VMOperator opTwo) {
		return new VMLongCompDivide(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(int opOne, int opTwo) {
		return new VMIntDivide(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(VMOperator opOne, int opTwo) {
		return new VMIntCompDivide(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(int opOne, VMOperator opTwo) {
		return new VMIntCompDivide(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(short opOne, short opTwo) {
		return new VMShortDivide(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(VMOperator opOne, short opTwo) {
		return new VMShortCompDivide(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(short opOne, VMOperator opTwo) {
		return new VMShortCompDivide(opOne, opTwo);
	}

}

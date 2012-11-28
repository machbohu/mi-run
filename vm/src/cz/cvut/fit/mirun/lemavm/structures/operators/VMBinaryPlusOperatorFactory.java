package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.structures.operators.compounds.VMCompoundPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.doubles.VMDoublePlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.ints.VMIntPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.longs.VMLongPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.mixed.VMDoubleCompPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.mixed.VMIntCompPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.mixed.VMLongCompPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.mixed.VMShortCompPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.shorts.VMShortPlus;

public final class VMBinaryPlusOperatorFactory implements
		VMBinaryOperatorFactory {

	@Override
	public VMOperator createOperator(VMOperator opOne, VMOperator opTwo) {
		return new VMCompoundPlus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(double opOne, double opTwo) {
		return new VMDoublePlus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(VMOperator opOne, double opTwo) {
		return new VMDoubleCompPlus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(double opOne, VMOperator opTwo) {
		return new VMDoubleCompPlus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(long opOne, long opTwo) {
		return new VMLongPlus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(VMOperator opOne, long opTwo) {
		return new VMLongCompPlus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(long opOne, VMOperator opTwo) {
		return new VMLongCompPlus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(int opOne, int opTwo) {
		return new VMIntPlus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(VMOperator opOne, int opTwo) {
		return new VMIntCompPlus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(int opOne, VMOperator opTwo) {
		return new VMLongCompPlus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(short opOne, short opTwo) {
		return new VMShortPlus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(VMOperator opOne, short opTwo) {
		return new VMShortCompPlus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(short opOne, VMOperator opTwo) {
		return new VMShortCompPlus(opOne, opTwo);
	}
}

package cz.cvut.fit.mirun.lemavm.structures.operators.shorts;

import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public abstract class VMBinaryShortOperator extends VMOperator {

	protected final short opOne;
	protected final short opTwo;

	public VMBinaryShortOperator(short opOne, short opTwo) {
		super();
		this.opOne = opOne;
		this.opTwo = opTwo;
	}
}

package cz.cvut.fit.mirun.lemavm.structures.operators.mixed;

import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public abstract class VMBinaryShortCompOperator extends VMOperator {

	protected final short opOne;
	protected final short opTwo;
	protected final VMOperator operOne;
	protected final VMOperator operTwo;

	public VMBinaryShortCompOperator(short opOne, VMOperator operTwo) {
		super();
		this.opOne = opOne;
		this.operTwo = operTwo;
		this.operOne = null;
		this.opTwo = 0;
	}

	public VMBinaryShortCompOperator(VMOperator operOne, short opTwo) {
		super();
		this.operOne = operOne;
		this.opTwo = opTwo;
		this.operTwo = null;
		this.opOne = 0;
	}
}

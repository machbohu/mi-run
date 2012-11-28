package cz.cvut.fit.mirun.lemavm.structures.operators.mixed;

import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public abstract class VMBinaryIntCompOperator extends VMOperator {

	protected final int opOne;
	protected final int opTwo;
	protected final VMOperator operOne;
	protected final VMOperator operTwo;

	public VMBinaryIntCompOperator(int opOne, VMOperator operTwo) {
		super();
		this.opOne = opOne;
		this.operTwo = operTwo;
		this.operOne = null;
		this.opTwo = 0;
	}

	public VMBinaryIntCompOperator(VMOperator operOne, int opTwo) {
		super();
		this.operOne = operOne;
		this.opTwo = opTwo;
		this.operTwo = null;
		this.opOne = 0;
	}
}

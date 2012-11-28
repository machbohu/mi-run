package cz.cvut.fit.mirun.lemavm.structures.operators.mixed;

import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public abstract class VMBinaryLongCompOperator extends VMOperator {

	protected final long opOne;
	protected final long opTwo;
	protected final VMOperator operOne;
	protected final VMOperator operTwo;

	public VMBinaryLongCompOperator(long opOne, VMOperator operTwo) {
		super();
		this.opOne = opOne;
		this.operTwo = operTwo;
		this.operOne = null;
		this.opTwo = 0L;
	}

	public VMBinaryLongCompOperator(VMOperator operOne, long opTwo) {
		super();
		this.operOne = operOne;
		this.opTwo = opTwo;
		this.operTwo = null;
		this.opOne = 0L;
	}
}

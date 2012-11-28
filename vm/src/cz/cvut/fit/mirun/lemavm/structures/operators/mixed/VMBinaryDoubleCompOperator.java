package cz.cvut.fit.mirun.lemavm.structures.operators.mixed;

import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public abstract class VMBinaryDoubleCompOperator extends VMOperator {

	protected final double opOne;
	protected final double opTwo;
	protected final VMOperator operOne;
	protected final VMOperator operTwo;

	public VMBinaryDoubleCompOperator(double opOne, VMOperator operTwo) {
		this.opOne = opOne;
		this.operTwo = operTwo;
		this.operOne = null;
		this.opTwo = 0.0;
	}

	public VMBinaryDoubleCompOperator(VMOperator operOne, double opTwo) {
		this.operOne = operOne;
		this.opTwo = opTwo;
		this.operTwo = null;
		this.opOne = 0.0;
	}
}

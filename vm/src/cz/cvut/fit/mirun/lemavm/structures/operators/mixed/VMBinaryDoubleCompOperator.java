package cz.cvut.fit.mirun.lemavm.structures.operators.mixed;

import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

public abstract class VMBinaryDoubleCompOperator extends VMOperator {

	protected final double opOne;
	protected final double opTwo;
	protected final VMOperator operOne;
	protected final VMOperator operTwo;

	public VMBinaryDoubleCompOperator(double opOne, VMOperator operTwo) {
		if (operTwo == null) {
			throw new NullPointerException();
		}
		this.opOne = opOne;
		this.operTwo = operTwo;
		this.operOne = null;
		this.opTwo = 0.0;
	}

	public VMBinaryDoubleCompOperator(VMOperator operOne, double opTwo) {
		if (operOne == null) {
			throw new NullPointerException();
		}
		this.operOne = operOne;
		this.opTwo = opTwo;
		this.operTwo = null;
		this.opOne = 0.0;
	}

	@Override
	public VMString evaluateString() {
		return new VMString("" + evaluateDouble());
	}
}

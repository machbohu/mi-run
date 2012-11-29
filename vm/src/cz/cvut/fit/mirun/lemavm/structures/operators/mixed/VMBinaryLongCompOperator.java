package cz.cvut.fit.mirun.lemavm.structures.operators.mixed;

import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

public abstract class VMBinaryLongCompOperator extends VMOperator {

	protected final long opOne;
	protected final long opTwo;
	protected final VMOperator operOne;
	protected final VMOperator operTwo;

	public VMBinaryLongCompOperator(long opOne, VMOperator operTwo) {
		super();
		if (operTwo == null) {
			throw new NullPointerException();
		}
		this.opOne = opOne;
		this.operTwo = operTwo;
		this.operOne = null;
		this.opTwo = 0L;
	}

	public VMBinaryLongCompOperator(VMOperator operOne, long opTwo) {
		super();
		if (operOne == null) {
			throw new NullPointerException();
		}
		this.operOne = operOne;
		this.opTwo = opTwo;
		this.operTwo = null;
		this.opOne = 0L;
	}
	
	@Override
	public VMString evaluateString() {
		return new VMString("" + evaluateLong());
	}
}

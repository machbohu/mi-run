package cz.cvut.fit.mirun.lemavm.structures.operators.longs;

import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

public abstract class VMBinaryLongOperator extends VMOperator {

	protected final long opOne;
	protected final long opTwo;

	public VMBinaryLongOperator(long opOne, long opTwo) {
		super();
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public VMString evaluateString() {
		return new VMString("" + evaluateLong());
	}
}

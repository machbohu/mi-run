package cz.cvut.fit.mirun.lemavm.structures.operators.ints;

import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

public abstract class VMBinaryIntOperator extends VMOperator {

	protected final int opOne;
	protected final int opTwo;

	public VMBinaryIntOperator(int opOne, int opTwo) {
		super();
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public VMString evaluateString() {
		return new VMString("" + evaluateInt());
	}
}

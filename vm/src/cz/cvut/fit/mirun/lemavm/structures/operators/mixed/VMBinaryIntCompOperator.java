package cz.cvut.fit.mirun.lemavm.structures.operators.mixed;

import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

public abstract class VMBinaryIntCompOperator extends VMOperator {

	protected final int opOne;
	protected final int opTwo;
	protected final VMOperator operOne;
	protected final VMOperator operTwo;

	public VMBinaryIntCompOperator(int opOne, VMOperator operTwo) {
		super();
		if (operTwo == null) {
			throw new NullPointerException();
		}
		this.opOne = opOne;
		this.operTwo = operTwo;
		this.operOne = null;
		this.opTwo = 0;
	}

	public VMBinaryIntCompOperator(VMOperator operOne, int opTwo) {
		super();
		if (operOne == null) {
			throw new NullPointerException();
		}
		this.operOne = operOne;
		this.opTwo = opTwo;
		this.operTwo = null;
		this.opOne = 0;
	}
	
	@Override
	public VMString evaluateString() {
		return new VMString("" + evaluateInt());
	}
}

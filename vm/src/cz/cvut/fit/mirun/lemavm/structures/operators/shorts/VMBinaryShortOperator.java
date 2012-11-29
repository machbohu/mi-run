package cz.cvut.fit.mirun.lemavm.structures.operators.shorts;

import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

public abstract class VMBinaryShortOperator extends VMOperator {

	protected final short opOne;
	protected final short opTwo;

	public VMBinaryShortOperator(short opOne, short opTwo) {
		super();
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public VMString evaluateString() {
		return new VMString("" + evaluateShort());
	}
}

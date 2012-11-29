package cz.cvut.fit.mirun.lemavm.structures.operators.doubles;

import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

public abstract class VMBinaryDoubleOperator extends VMOperator {

	protected final double opOne;
	protected final double opTwo;

	public VMBinaryDoubleOperator(double opOne, double opTwo) {
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public VMString evaluateString() {
		return new VMString("" + evaluateDouble());
	}
}

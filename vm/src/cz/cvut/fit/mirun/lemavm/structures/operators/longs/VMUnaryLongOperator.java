package cz.cvut.fit.mirun.lemavm.structures.operators.longs;

import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

public abstract class VMUnaryLongOperator extends VMOperator {

	protected long op;

	public VMUnaryLongOperator(long op) {
		super();
		this.op = op;
	}

	@Override
	public VMString evaluateString() {
		return new VMString("" + evaluateLong());
	}
}

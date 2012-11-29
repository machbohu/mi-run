package cz.cvut.fit.mirun.lemavm.structures.operators.shorts;

import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

public abstract class VMUnaryShortOperator extends VMOperator {

	protected short op;

	public VMUnaryShortOperator(short op) {
		super();
		this.op = op;
	}

	@Override
	public VMString evaluateString() {
		return new VMString("" + evaluateShort());
	}
}

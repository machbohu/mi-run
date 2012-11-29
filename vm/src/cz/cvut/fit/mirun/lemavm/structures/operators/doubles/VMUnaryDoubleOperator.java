package cz.cvut.fit.mirun.lemavm.structures.operators.doubles;

import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

public abstract class VMUnaryDoubleOperator extends VMOperator {

	protected double op;

	public VMUnaryDoubleOperator(double op) {
		this.op = op;
	}

	@Override
	public VMString evaluateString() {
		return new VMString("" + evaluateDouble());
	}
}

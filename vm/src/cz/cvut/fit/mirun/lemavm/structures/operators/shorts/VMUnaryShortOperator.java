package cz.cvut.fit.mirun.lemavm.structures.operators.shorts;

import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public abstract class VMUnaryShortOperator extends VMOperator {

	protected short op;

	public VMUnaryShortOperator(short op) {
		super();
		this.op = op;
	}
}

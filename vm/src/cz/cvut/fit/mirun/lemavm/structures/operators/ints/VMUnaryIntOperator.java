package cz.cvut.fit.mirun.lemavm.structures.operators.ints;

import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public abstract class VMUnaryIntOperator extends VMOperator {

	protected int op;

	public VMUnaryIntOperator(int op) {
		super();
		this.op = op;
	}
}

package cz.cvut.fit.mirun.lemavm.structures.operators.compounds;

import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public abstract class VMUnaryCompoundOperator extends VMOperator {

	protected VMOperator op;

	public VMUnaryCompoundOperator(VMOperator op) {
		super();
		this.op = op;
	}
}

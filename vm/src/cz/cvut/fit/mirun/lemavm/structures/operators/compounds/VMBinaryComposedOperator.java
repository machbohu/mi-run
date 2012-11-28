package cz.cvut.fit.mirun.lemavm.structures.operators.compounds;

import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public abstract class VMBinaryComposedOperator extends VMOperator {

	protected final VMOperator opOne;
	protected final VMOperator opTwo;

	public VMBinaryComposedOperator(VMOperator opOne, VMOperator opTwo) {
		super();
		this.opOne = opOne;
		this.opTwo = opTwo;
	}
}

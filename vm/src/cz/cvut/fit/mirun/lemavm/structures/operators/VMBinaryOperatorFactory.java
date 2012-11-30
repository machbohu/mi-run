package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

public interface VMBinaryOperatorFactory {

	public VMOperator createOperator(VMOperator opOne, VMOperator opTwo);

	public VMOperator createOperator(VMOperator opOne, Number opTwo);

	public VMOperator createOperator(Number opOne, VMOperator opTwo);

	public VMOperator createOperator(Number opOne, Number opTwo);

	public VMOperator createOperator(VMString opOne, VMOperator opTwo);

	public VMOperator createOperator(VMOperator opOne, VMString opTwo);

	public VMOperator createOperator(VMString opOne, Number opTwo);

	public VMOperator createOperator(Number opOne, VMString opTWo);

	public VMOperator createOperator(VMString opOne, VMString opTwo);

	public VMOperator createOperator(String opOne, VMOperator opTwo);

	public VMOperator createOperator(VMOperator opOne, String opTwo);

	public VMOperator createOperator(String opOne, Number opTwo);

	public VMOperator createOperator(Number opOne, String opTwo);

	public VMOperator createOperator(String opOne, String opTwo);

	public VMOperator createOperator(String opOne, VMString opTWo);

	public VMOperator createOperator(VMString opOne, String opTwo);
}

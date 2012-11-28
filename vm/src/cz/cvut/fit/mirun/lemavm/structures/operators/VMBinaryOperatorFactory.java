package cz.cvut.fit.mirun.lemavm.structures.operators;

public interface VMBinaryOperatorFactory {

	public VMOperator createOperator(VMOperator opOne, VMOperator opTwo);

	public VMOperator createOperator(double opOne, double opTwo);

	public VMOperator createOperator(VMOperator opOne, double opTwo);

	public VMOperator createOperator(double opOne, VMOperator opTwo);

	public VMOperator createOperator(long opOne, long opTwo);

	public VMOperator createOperator(VMOperator opOne, long opTwo);

	public VMOperator createOperator(long opOne, VMOperator opTwo);

	public VMOperator createOperator(int opOne, int opTwo);

	public VMOperator createOperator(VMOperator opOne, int opTwo);

	public VMOperator createOperator(int opOne, VMOperator opTwo);

	public VMOperator createOperator(short opOne, short opTwo);

	public VMOperator createOperator(VMOperator opOne, short opTwo);

	public VMOperator createOperator(short opOne, VMOperator opTwo);
}

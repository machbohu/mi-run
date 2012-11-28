package cz.cvut.fit.mirun.lemavm.structures.operators;

public interface VMUnaryOperatorFactory {

	public VMOperator createOperator(VMOperator op);

	public VMOperator createOperator(double op);

	public VMOperator createOperator(long op);

	public VMOperator createOperator(int op);

	public VMOperator createOperator(short op);

	public VMOperator createOperator(boolean op);
}

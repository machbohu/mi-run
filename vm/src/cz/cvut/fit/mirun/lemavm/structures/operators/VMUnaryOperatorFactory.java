package cz.cvut.fit.mirun.lemavm.structures.operators;

public interface VMUnaryOperatorFactory {

	public VMOperator createOperator(VMOperator op);

	public VMOperator createOperator(Number op);

	public VMOperator createOperator(Boolean op);

	/**
	 * Create operator for a variable.
	 * 
	 * @param op
	 *            Name of the variable
	 * @return VMOperator
	 */
	public VMOperator createOperator(String op);
}

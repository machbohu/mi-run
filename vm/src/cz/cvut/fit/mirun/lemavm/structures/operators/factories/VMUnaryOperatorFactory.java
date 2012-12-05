package cz.cvut.fit.mirun.lemavm.structures.operators.factories;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.utils.ParsingUtils;

public abstract class VMUnaryOperatorFactory {

	/**
	 * Create unary operator from the specified argument. </p>
	 * 
	 * This method decides the type of the argument and creates corresponding
	 * {@code VMOperator} instance.
	 * 
	 * @param op
	 *            Operand
	 * @return Unary operator
	 * @throws NullPointerException
	 *             If the argument is null
	 * @throws VMParsingException
	 *             If incompatible operand is passed
	 */
	public VMOperator createOperator(Object op) {
		if (op == null) {
			throw new NullPointerException();
		}
		if (op instanceof VMOperator) {
			return createOperator((VMOperator) op);
		} else if (op instanceof String) {
			final String strOp = (String) op;
			Boolean b = ParsingUtils.tryParsingBoolean(strOp);
			if (b != null) {
				return createOperator(b);
			}
			Number n = ParsingUtils.tryParsingNumber(strOp);
			if (n != null) {
				return createOperator(n);
			} else {
				return createOperator(strOp);
			}
		} else {
			throw new VMParsingException("Cannot parse the value "
					+ op.toString() + " and create an unary operator.");
		}
	}

	protected abstract VMOperator createOperator(VMOperator op);

	protected abstract VMOperator createOperator(Number op);

	protected abstract VMOperator createOperator(Boolean op);

	/**
	 * Create operator for a variable.
	 * 
	 * @param op
	 *            Name of the variable
	 * @return VMOperator
	 */
	protected abstract VMOperator createOperator(String op);
}

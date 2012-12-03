package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.utils.ParsingUtils;

public abstract class VMBinaryOperatorFactory {

	/**
	 * Create binary operator from the specified arguments. </p>
	 * 
	 * This method decides the type of the arguments and creates corresponding
	 * {@code VMOperator} instance.
	 * 
	 * @param opOne
	 *            The first operand
	 * @param opTwo
	 *            The second operand
	 * @return VMOperator
	 * @throws NullPointerException
	 *             If one or both arguments are null
	 * @throws VMParsingException
	 *             If an incompatible operand type is passed
	 */
	public VMOperator createOperator(Object opOne, Object opTwo) {
		if (opOne == null || opTwo == null) {
			throw new NullPointerException(
					"Null passed to createOperator. Operand one = " + opOne
							+ ", operand two = " + opTwo);
		}
		if (opOne instanceof VMOperator) {
			// The first operand is an operator
			final VMOperator oOne = (VMOperator) opOne;
			if (opTwo instanceof VMOperator) {
				// The second operand is an operator
				return createOperator(oOne, (VMOperator) opTwo);
			} else if (opTwo instanceof VMString) {
				// The second operand is a string
				return createOperator(oOne, (VMString) opTwo);
			} else if (opTwo instanceof String) {
				// The second operand is a literal or a variable name
				final String strOp = (String) opTwo;
				Boolean b = ParsingUtils.tryParsingBoolean(strOp);
				if (b != null) {
					return createOperator(oOne, b);
				}
				Number n = ParsingUtils.tryParsingNumber(strOp);
				if (n != null) {
					return createOperator(oOne, n);
				} else {
					return createOperator(oOne, strOp);
				}
			} else {
				throw new VMParsingException("Cannot parse the value "
						+ opTwo.toString() + " and create a binary operator.");
			}
		} else if (opOne instanceof VMString) {
			// The first operand is a string
			final VMString sOne = (VMString) opOne;
			if (opTwo instanceof VMOperator) {
				// The second operand is an operator
				return createOperator(sOne, (VMOperator) opTwo);
			} else if (opTwo instanceof VMString) {
				// The second operand is a string
				return createOperator(sOne, (VMString) opTwo);
			} else if (opTwo instanceof String) {
				// The second operand is a literal or a variable name
				final String strOp = (String) opTwo;
				if (strOp.startsWith("\"")) {
					// The second operand is a string literal
					return createOperator(sOne,
							new VMString(strOp.substring(1, strOp.length())));
				}
				Boolean b = ParsingUtils.tryParsingBoolean(strOp);
				if (b != null) {
					return createOperator(sOne, b);
				}
				Number n = ParsingUtils.tryParsingNumber(strOp);
				if (n != null) {
					return createOperator(sOne, n);
				} else {
					return createOperator(sOne, strOp);
				}
			} else {
				throw new VMParsingException("Cannot parse the value "
						+ opTwo.toString() + " and create a binary operator.");
			}
		} else if (opOne instanceof String) {
			// The first operand is a literal or a variable name
			final String strOne = (String) opOne;
			return createOperatorFirstString(strOne, opTwo);
		} else {
			throw new VMParsingException("Cannot parse the value "
					+ opOne.toString() + " and create a binary operator.");
		}
	}

	/**
	 * Create operator if the first operand is a literal or a variable name.
	 * </p>
	 * 
	 * This method must try all the combinations of the first and second operand
	 * types.
	 * 
	 * @param opOne
	 *            The first operand
	 * @param opTwo
	 *            The second operand
	 * @return VMOperator
	 */
	private VMOperator createOperatorFirstString(String opOne, Object opTwo) {
		if (opOne.startsWith("\"")) {
			// The first operand is a string literal
			VMString v = new VMString(opOne.substring(1, opOne.length()));
			if (opTwo instanceof VMOperator) {
				// The second operand is an operator
				return createOperator(v, (VMOperator) opTwo);
			} else if (opTwo instanceof VMString) {
				// The second operand is a string
				return createOperator(v, (VMString) opTwo);
			} else if (opTwo instanceof String) {
				// The second operand is a literal or a variable name
				final String strOp = (String) opTwo;
				if (strOp.startsWith("\"")) {
					// The second operand is a string literal
					return createOperator(v,
							new VMString(strOp.substring(1, strOp.length())));
				}
				Boolean b = ParsingUtils.tryParsingBoolean(strOp);
				if (b != null) {
					return createOperator(v, b);
				}
				Number n = ParsingUtils.tryParsingNumber(strOp);
				if (n != null) {
					return createOperator(v, n);
				} else {
					return createOperator(v, strOp);
				}
			} else {
				throw new VMParsingException("Cannot parse the value "
						+ opTwo.toString() + " and create a binary operator.");
			}
		}
		Boolean bOne = ParsingUtils.tryParsingBoolean(opOne);
		if (bOne != null) {
			// The first operand is a boolean
			if (opTwo instanceof VMOperator) {
				// The second operand is an operator
				return createOperator(bOne, (VMOperator) opTwo);
			} else if (opTwo instanceof VMString) {
				// The second operand is a string
				return createOperator(bOne, (VMString) opTwo);
			} else if (opTwo instanceof String) {
				// The second operand is a literal or a variable name
				final String strOp = (String) opTwo;
				if (strOp.startsWith("\"")) {
					// The second operand is a string literal
					return createOperator(bOne,
							new VMString(strOp.substring(1, strOp.length())));
				}
				Boolean b = ParsingUtils.tryParsingBoolean(strOp);
				if (b != null) {
					return createOperator(bOne, b);
				}
				Number n = ParsingUtils.tryParsingNumber(strOp);
				if (n != null) {
					return createOperator(bOne, n);
				} else {
					return createOperator(bOne, strOp);
				}
			} else {
				throw new VMParsingException("Cannot parse the value "
						+ opTwo.toString() + " and create a binary operator.");
			}
		}

		Number nOne = ParsingUtils.tryParsingNumber(opOne);
		if (nOne != null) {
			// The first operand is a number
			if (opTwo instanceof VMOperator) {
				// The second operand is an operator
				return createOperator(nOne, (VMOperator) opTwo);
			} else if (opTwo instanceof VMString) {
				// The second operand is a string
				return createOperator(nOne, (VMString) opTwo);
			} else if (opTwo instanceof String) {
				// The second operand is a literal or a variable name
				final String strOp = (String) opTwo;
				if (strOp.startsWith("\"")) {
					// The second operand is a string literal
					return createOperator(nOne,
							new VMString(strOp.substring(1, strOp.length())));
				}
				Boolean b = ParsingUtils.tryParsingBoolean(strOp);
				if (b != null) {
					return createOperator(nOne, b);
				}
				Number n = ParsingUtils.tryParsingNumber(strOp);
				if (n != null) {
					return createOperator(nOne, n);
				} else {
					return createOperator(nOne, strOp);
				}
			} else {
				throw new VMParsingException("Cannot parse the value "
						+ opTwo.toString() + " and create a binary operator.");
			}
		} else {
			// The first operand is a literal or a variable name
			if (opTwo instanceof VMOperator) {
				// The second operand is an operator
				return createOperator(opOne, (VMOperator) opTwo);
			} else if (opTwo instanceof VMString) {
				// The second operand is a string
				return createOperator(opOne, (VMString) opTwo);
			} else if (opTwo instanceof String) {
				// The second operand is a literal or a variable name
				final String strOp = (String) opTwo;
				if (strOp.startsWith("\"")) {
					// The second operand is a string literal
					return createOperator(opOne,
							new VMString(strOp.substring(1, strOp.length())));
				}
				Boolean b = ParsingUtils.tryParsingBoolean(strOp);
				if (b != null) {
					return createOperator(opOne, b);
				}
				Number n = ParsingUtils.tryParsingNumber(strOp);
				if (n != null) {
					return createOperator(opOne, n);
				} else {
					return createOperator(opOne, strOp);
				}
			} else {
				throw new VMParsingException("Cannot parse the value "
						+ opTwo.toString() + " and create a binary operator.");
			}
		}
	}

	protected abstract VMOperator createOperator(VMOperator opOne,
			VMOperator opTwo);

	protected abstract VMOperator createOperator(VMOperator opOne, Number opTwo);

	protected abstract VMOperator createOperator(Number opOne, VMOperator opTwo);

	protected abstract VMOperator createOperator(Number opOne, Number opTwo);

	protected abstract VMOperator createOperator(VMString opOne,
			VMOperator opTwo);

	protected abstract VMOperator createOperator(VMOperator opOne,
			VMString opTwo);

	protected abstract VMOperator createOperator(VMString opOne, Number opTwo);

	protected abstract VMOperator createOperator(Number opOne, VMString opTWo);

	protected abstract VMOperator createOperator(VMString opOne, VMString opTwo);

	protected abstract VMOperator createOperator(String opOne, VMOperator opTwo);

	protected abstract VMOperator createOperator(VMOperator opOne, String opTwo);

	protected abstract VMOperator createOperator(String opOne, Number opTwo);

	protected abstract VMOperator createOperator(Number opOne, String opTwo);

	protected abstract VMOperator createOperator(String opOne, String opTwo);

	protected abstract VMOperator createOperator(String opOne, VMString opTWo);

	protected abstract VMOperator createOperator(VMString opOne, String opTwo);
}

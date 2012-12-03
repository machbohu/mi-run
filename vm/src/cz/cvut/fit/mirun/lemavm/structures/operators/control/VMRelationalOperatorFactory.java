package cz.cvut.fit.mirun.lemavm.structures.operators.control;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.utils.ParsingUtils;

public abstract class VMRelationalOperatorFactory {

	public VMOperator createOperator(Object opOne, Object opTwo) {
		if (opOne == null || opTwo == null) {
			throw new NullPointerException(
					"Null passed to createOperator. Operand one = " + opOne
							+ ", operand two = " + opTwo);
		}
		if (opOne instanceof VMOperator) {
			final VMOperator cOne = (VMOperator) opOne;
			if (opTwo instanceof VMOperator) {
				return createOperator(cOne, (VMOperator) opTwo);
			}
			if (opTwo instanceof String) {
				// The second operand is a literal or a variable name
				final String strOp = (String) opTwo;
				Boolean b = ParsingUtils.tryParsingBoolean(strOp);
				if (b != null) {
					return createOperator(cOne, b);
				}
				Number n = ParsingUtils.tryParsingNumber(strOp);
				if (n != null) {
					return createOperator(cOne, n);
				} else {
					return createOperator(cOne, strOp);
				}
			} else {
				throw new VMParsingException("Cannot parse the value "
						+ opOne.toString() + " and create a binary operator.");
			}
		} else if (opOne instanceof VMObject) {
			final VMObject oOne = (VMObject) opOne;
			if (opTwo instanceof VMObject) {
				// The second operand is an object
				return createOperator(oOne, (VMObject) opTwo);
			}
			if (opTwo instanceof String) {
				// The second operand a variable name
				final String strOp = (String) opTwo;
				return createOperator(oOne, strOp);
			} else {
				throw new VMParsingException("Cannot parse the value "
						+ opOne.toString() + " and create a binary operator.");
			}
		} else if (opOne instanceof String) {
			return createOperatorFirstString((String) opOne, opTwo);
		} else {
			throw new VMParsingException("Cannot parse the value "
					+ opOne.toString() + " and create a binary operator.");
		}
	}

	private VMOperator createOperatorFirstString(String opOne, Object opTwo) {
		Boolean b = ParsingUtils.tryParsingBoolean(opOne);
		if (b != null) {
			if (opTwo instanceof VMOperator) {
				return createOperator(b, (VMOperator) opTwo);
			} else if (opTwo instanceof String) {
				final String sTwo = (String) opTwo;
				Boolean bTwo = ParsingUtils.tryParsingBoolean(sTwo);
				if (bTwo != null) {
					return createOperator(b, bTwo);
				} else {
					return createOperator(b, sTwo);
				}
			} else {
				throw new VMParsingException("Cannot parse the value "
						+ opTwo.toString() + " and create a binary operator.");
			}
		}
		Number n = ParsingUtils.tryParsingNumber(opOne);
		if (n != null) {
			if (opTwo instanceof VMOperator) {
				return createOperator(n, (VMOperator) opTwo);
			} else if (opTwo instanceof String) {
				final String sTwo = (String) opTwo;
				Number nTwo = ParsingUtils.tryParsingNumber(sTwo);
				if (nTwo != null) {
					return createOperator(n, nTwo);
				} else {
					return createOperator(n, sTwo);
				}
			} else {
				throw new VMParsingException("Cannot parse the value "
						+ opTwo.toString() + " and create a binary operator.");
			}
		} else {
			if (opTwo instanceof VMOperator) {
				return createOperator(opOne, (VMOperator) opTwo);
			} else if (opTwo instanceof VMObject) {
				return createOperator(opOne, (VMObject) opTwo);
			} else if (opTwo instanceof String) {
				final String sTwo = (String) opTwo;
				Boolean bTwo = ParsingUtils.tryParsingBoolean(sTwo);
				if (bTwo != null) {
					return createOperator(opOne, bTwo);
				}
				Number nTwo = ParsingUtils.tryParsingNumber(sTwo);
				if (nTwo != null) {
					return createOperator(opOne, nTwo);
				} else {
					return createOperator(opOne, sTwo);
				}
			} else {
				throw new VMParsingException("Cannot parse the value "
						+ opTwo.toString() + " and create a binary operator.");
			}
		}
	}

	protected abstract VMRelationalOperator createOperator(Number opOne,
			Number opTwo);

	protected abstract VMRelationalOperator createOperator(Boolean opOne,
			Boolean opTwo);

	protected abstract VMRelationalOperator createOperator(VMObject opOne,
			VMObject opTwo);

	protected abstract VMRelationalOperator createOperator(Number opOne,
			VMOperator opTwo);

	protected abstract VMRelationalOperator createOperator(Boolean opOne,
			VMOperator opTwo);

	protected abstract VMRelationalOperator createOperator(VMOperator opOne,
			Number opTwo);

	protected abstract VMRelationalOperator createOperator(VMOperator opOne,
			Boolean opTwo);

	protected abstract VMRelationalOperator createOperator(VMOperator opOne,
			VMOperator opTwo);

	protected abstract VMRelationalOperator createOperator(Number opOne,
			String opTwo);

	protected abstract VMRelationalOperator createOperator(String opOne,
			Number opTwo);

	protected abstract VMRelationalOperator createOperator(Boolean opOne,
			String opTwo);

	protected abstract VMRelationalOperator createOperator(String opOne,
			Boolean opTwo);

	protected abstract VMRelationalOperator createOperator(String opOne,
			VMOperator opTwo);

	protected abstract VMRelationalOperator createOperator(VMOperator opOne,
			String opTwo);

	protected abstract VMRelationalOperator createOperator(String opOne,
			VMObject opTwo);

	protected abstract VMRelationalOperator createOperator(VMObject opOne,
			String opTwo);

	protected abstract VMRelationalOperator createOperator(String opOne,
			String opTwo);

}

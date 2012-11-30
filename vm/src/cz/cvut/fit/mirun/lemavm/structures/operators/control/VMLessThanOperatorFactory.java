package cz.cvut.fit.mirun.lemavm.structures.operators.control;

import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class VMLessThanOperatorFactory {

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessThanOperator(Number opOne,
			Number opTwo) {
		return null;
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createOperator(Number opOne, VMOperator opTwo) {
		return null;
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createOperator(VMOperator opOne, Number opTwo) {
		return null;
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createOperator(String opOne, Number opTwo) {
		return null;
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createOperator(Number opOne, String opTwo) {
		return null;
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createOperator(String opOne, VMOperator opTwo) {
		return null;
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createOperator(VMOperator opOne, String opTwo) {
		return null;
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createOperator(String opOne, String opTwo) {
		return null;
	}

	// Operators definitions

	public static final class NumberLessThan extends VMRelationalOperator {
		private final Number dOne;
		private final Number dTwo;

		NumberLessThan(Number dOne, Number dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			// TODO
			return false;
		}
	}
}

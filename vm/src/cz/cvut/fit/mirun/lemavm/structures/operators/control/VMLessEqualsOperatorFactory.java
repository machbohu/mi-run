package cz.cvut.fit.mirun.lemavm.structures.operators.control;

import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class VMLessEqualsOperatorFactory {

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createOperator(Number opOne, Number opTwo) {
		return new NumberLessEquals(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessEqualsOperator(VMOperator opOne,
			VMOperator opTwo) {
		return new CompCompLessEquals(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createOperator(Number opOne, VMOperator opTwo) {
		return new NumberCompLessEquals(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createOperator(VMOperator opOne, Number opTwo) {
		return new CompNumberLessEquals(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createOperator(String opOne, Number opTwo) {
		return new VariableNumberLessEquals(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createOperator(Number opOne, String opTwo) {
		return new NumberVariableLessEquals(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createOperator(String opOne, VMOperator opTwo) {
		return new VariableCompLessEquals(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createOperator(VMOperator opOne, String opTwo) {
		return new CompVariableLessEquals(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createOperator(String opOne, String opTwo) {
		return new VariableVariableLessEquals(opOne, opTwo);
	}

	// Operators definitions

	public static final class NumberLessEquals extends VMRelationalOperator {
		private final Number opOne;
		private final Number opTwo;

		NumberLessEquals(Number opOne, Number opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			if (opOne instanceof Double || opTwo instanceof Double) {
				return (opOne.doubleValue() <= opTwo.doubleValue());
			} else {
				return (opOne.longValue() <= opTwo.longValue());
			}
		}
	}

	public static final class NumberCompLessEquals extends VMRelationalOperator {
		private final Number opOne;
		private final VMOperator opTwo;

		public NumberCompLessEquals(Number opOne, VMOperator opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			if (opOne instanceof Double) {
				return (opOne.doubleValue() <= opTwo.evaluateDouble(env));
			} else {
				return (opOne.longValue() <= opTwo.evaluateLong(env));
			}
		}
	}

	public static final class CompNumberLessEquals extends VMRelationalOperator {
		private final VMOperator opOne;
		private final Number opTwo;

		public CompNumberLessEquals(VMOperator opOne, Number opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			if (opTwo instanceof Double) {
				return (opOne.evaluateDouble(env) <= opTwo.doubleValue());
			} else {
				return (opOne.evaluateLong(env) <= opTwo.longValue());
			}
		}
	}

	public static final class CompCompLessEquals extends VMRelationalOperator {
		private final VMOperator opOne;
		private final VMOperator opTwo;

		public CompCompLessEquals(VMOperator opOne, VMOperator opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			Double rOne = opOne.evaluateDouble(env);
			Double rTwo = opTwo.evaluateDouble(env);
			return (rOne <= rTwo);
		}
	}

	public static final class NumberVariableLessEquals extends
			VMRelationalOperator {
		private final Number opOne;
		private final String opTwo;

		public NumberVariableLessEquals(Number opOne, String opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			Number nTwo = getBindingValue(opTwo, Number.class, env);
			if (opOne instanceof Double || nTwo instanceof Double) {
				return (opOne.doubleValue() <= nTwo.doubleValue());
			} else {
				return (opOne.longValue() <= nTwo.longValue());
			}
		}
	}

	public static final class VariableNumberLessEquals extends
			VMRelationalOperator {
		private final String opOne;
		private final Number opTwo;

		public VariableNumberLessEquals(String opOne, Number opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			Number nOne = getBindingValue(opOne, Number.class, env);
			if (opTwo instanceof Double || nOne instanceof Double) {
				return (nOne.doubleValue() <= opTwo.doubleValue());
			} else {
				return (nOne.longValue() <= opTwo.longValue());
			}
		}
	}

	public static final class VariableCompLessEquals extends
			VMRelationalOperator {
		private final String opOne;
		private final VMOperator opTwo;

		public VariableCompLessEquals(String opOne, VMOperator opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			Number nOne = getBindingValue(opOne, Number.class, env);
			if (nOne instanceof Double) {
				return (nOne.doubleValue() <= opTwo.evaluateDouble(env));
			} else {
				return (nOne.longValue() <= opTwo.evaluateLong(env));
			}
		}
	}

	public static final class CompVariableLessEquals extends
			VMRelationalOperator {
		private final VMOperator opOne;
		private final String opTwo;

		public CompVariableLessEquals(VMOperator opOne, String opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			Number nTwo = getBindingValue(opTwo, Number.class, env);
			if (nTwo instanceof Double) {
				return (opOne.evaluateDouble(env) <= nTwo.doubleValue());
			} else {
				return (opOne.evaluateLong(env) <= nTwo.longValue());
			}
		}
	}

	public static final class VariableVariableLessEquals extends
			VMRelationalOperator {
		private final String opOne;
		private final String opTwo;

		public VariableVariableLessEquals(String opOne, String opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			final Number nOne = getBindingValue(opOne, Number.class, env);
			final Number nTwo = getBindingValue(opTwo, Number.class, env);
			if (nOne instanceof Double || nTwo instanceof Double) {
				return (nOne.doubleValue() <= nTwo.doubleValue());
			} else {
				return (nOne.longValue() <= nTwo.longValue());
			}
		}
	}
}

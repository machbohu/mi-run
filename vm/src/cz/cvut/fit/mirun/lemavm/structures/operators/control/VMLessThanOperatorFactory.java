package cz.cvut.fit.mirun.lemavm.structures.operators.control;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class VMLessThanOperatorFactory extends
		VMRelationalOperatorFactory {

	/**
	 * Create the relational operator.
	 */
	protected VMRelationalOperator createOperator(Number opOne, Number opTwo) {
		return new NumberLessThan(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	protected VMRelationalOperator createLessThanOperator(VMOperator opOne,
			VMOperator opTwo) {
		return new CompCompLessThan(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	protected VMRelationalOperator createOperator(Number opOne, VMOperator opTwo) {
		return new NumberCompLessThan(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	protected VMRelationalOperator createOperator(VMOperator opOne, Number opTwo) {
		return new CompNumberLessThan(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	protected VMRelationalOperator createOperator(String opOne, Number opTwo) {
		return new VariableNumberLessThan(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	protected VMRelationalOperator createOperator(Number opOne, String opTwo) {
		return new NumberVariableLessThan(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	protected VMRelationalOperator createOperator(String opOne, VMOperator opTwo) {
		return new VariableCompLessThan(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	protected VMRelationalOperator createOperator(VMOperator opOne, String opTwo) {
		return new CompVariableLessThan(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	protected VMRelationalOperator createOperator(String opOne, String opTwo) {
		return new VariableVariableLessThan(opOne, opTwo);
	}

	@Override
	protected VMRelationalOperator createOperator(Boolean opOne, Boolean opTwo) {
		throw new VMParsingException("Unsupported operand types "
				+ opOne.getClass().getName() + ", "
				+ opTwo.getClass().getName());
	}

	@Override
	protected VMRelationalOperator createOperator(VMObject opOne, VMObject opTwo) {
		throw new VMParsingException("Unsupported operand types "
				+ opOne.getClass().getName() + ", "
				+ opTwo.getClass().getName());
	}

	@Override
	protected VMRelationalOperator createOperator(Boolean opOne,
			VMOperator opTwo) {
		throw new VMParsingException("Unsupported operand types "
				+ opOne.getClass().getName() + ", "
				+ opTwo.getClass().getName());
	}

	@Override
	protected VMRelationalOperator createOperator(VMOperator opOne,
			Boolean opTwo) {
		throw new VMParsingException("Unsupported operand types "
				+ opOne.getClass().getName() + ", "
				+ opTwo.getClass().getName());
	}

	@Override
	protected VMRelationalOperator createOperator(VMOperator opOne,
			VMOperator opTwo) {
		throw new VMParsingException("Unsupported operand types "
				+ opOne.getClass().getName() + ", "
				+ opTwo.getClass().getName());
	}

	@Override
	protected VMRelationalOperator createOperator(Boolean opOne, String opTwo) {
		throw new VMParsingException("Unsupported operand types "
				+ opOne.getClass().getName() + ", "
				+ opTwo.getClass().getName());
	}

	@Override
	protected VMRelationalOperator createOperator(String opOne, Boolean opTwo) {
		throw new VMParsingException("Unsupported operand types "
				+ opOne.getClass().getName() + ", "
				+ opTwo.getClass().getName());
	}

	@Override
	protected VMRelationalOperator createOperator(String opOne, VMObject opTwo) {
		throw new VMParsingException("Unsupported operand types "
				+ opOne.getClass().getName() + ", "
				+ opTwo.getClass().getName());
	}

	@Override
	protected VMRelationalOperator createOperator(VMObject opOne, String opTwo) {
		throw new VMParsingException("Unsupported operand types "
				+ opOne.getClass().getName() + ", "
				+ opTwo.getClass().getName());
	}

	// Operators definitions

	public static final class NumberLessThan extends VMRelationalOperator {
		private final Number opOne;
		private final Number opTwo;

		NumberLessThan(Number opOne, Number opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			if (opOne instanceof Double || opTwo instanceof Double) {
				return (opOne.doubleValue() < opTwo.doubleValue());
			} else {
				return (opOne.longValue() < opTwo.longValue());
			}
		}
	}

	public static final class NumberCompLessThan extends VMRelationalOperator {
		private final Number opOne;
		private final VMOperator opTwo;

		public NumberCompLessThan(Number opOne, VMOperator opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			if (opOne instanceof Double) {
				return (opOne.doubleValue() < opTwo.evaluateDouble(env));
			} else {
				return (opOne.longValue() < opTwo.evaluateLong(env));
			}
		}
	}

	public static final class CompNumberLessThan extends VMRelationalOperator {
		private final VMOperator opOne;
		private final Number opTwo;

		public CompNumberLessThan(VMOperator opOne, Number opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			if (opTwo instanceof Double) {
				return (opOne.evaluateDouble(env) < opTwo.doubleValue());
			} else {
				return (opOne.evaluateLong(env) < opTwo.longValue());
			}
		}
	}

	public static final class CompCompLessThan extends VMRelationalOperator {
		private final VMOperator opOne;
		private final VMOperator opTwo;

		public CompCompLessThan(VMOperator opOne, VMOperator opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			Double rOne = opOne.evaluateDouble(env);
			Double rTwo = opTwo.evaluateDouble(env);
			return (rOne < rTwo);
		}
	}

	public static final class NumberVariableLessThan extends
			VMRelationalOperator {
		private final Number opOne;
		private final String opTwo;

		public NumberVariableLessThan(Number opOne, String opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			Number nTwo = getBindingValue(opTwo, Number.class, env);
			if (opOne instanceof Double || nTwo instanceof Double) {
				return (opOne.doubleValue() < nTwo.doubleValue());
			} else {
				return (opOne.longValue() < nTwo.longValue());
			}
		}
	}

	public static final class VariableNumberLessThan extends
			VMRelationalOperator {
		private final String opOne;
		private final Number opTwo;

		public VariableNumberLessThan(String opOne, Number opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			Number nOne = getBindingValue(opOne, Number.class, env);
			if (opTwo instanceof Double || nOne instanceof Double) {
				return (nOne.doubleValue() < opTwo.doubleValue());
			} else {
				return (nOne.longValue() < opTwo.longValue());
			}
		}
	}

	public static final class VariableCompLessThan extends VMRelationalOperator {
		private final String opOne;
		private final VMOperator opTwo;

		public VariableCompLessThan(String opOne, VMOperator opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			Number nOne = getBindingValue(opOne, Number.class, env);
			if (nOne instanceof Double) {
				return (nOne.doubleValue() < opTwo.evaluateDouble(env));
			} else {
				return (nOne.longValue() < opTwo.evaluateLong(env));
			}
		}
	}

	public static final class CompVariableLessThan extends VMRelationalOperator {
		private final VMOperator opOne;
		private final String opTwo;

		public CompVariableLessThan(VMOperator opOne, String opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			Number nTwo = getBindingValue(opTwo, Number.class, env);
			if (nTwo instanceof Double) {
				return (opOne.evaluateDouble(env) < nTwo.doubleValue());
			} else {
				return (opOne.evaluateLong(env) < nTwo.longValue());
			}
		}
	}

	public static final class VariableVariableLessThan extends
			VMRelationalOperator {
		private final String opOne;
		private final String opTwo;

		public VariableVariableLessThan(String opOne, String opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			final Number nOne = getBindingValue(opOne, Number.class, env);
			final Number nTwo = getBindingValue(opTwo, Number.class, env);
			if (nOne instanceof Double || nTwo instanceof Double) {
				return (nOne.doubleValue() < nTwo.doubleValue());
			} else {
				return (nOne.longValue() < nTwo.longValue());
			}
		}
	}
}

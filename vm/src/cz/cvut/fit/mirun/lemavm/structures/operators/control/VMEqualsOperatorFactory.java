package cz.cvut.fit.mirun.lemavm.structures.operators.control;

import cz.cvut.fit.mirun.lemavm.core.VMConstants;
import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class VMEqualsOperatorFactory {

	public VMRelationalOperator createOperator(Number opOne, Number opTwo) {
		return new NumberEquals(opOne, opTwo);
	}

	public VMRelationalOperator createOperator(Boolean opOne, Boolean opTwo) {
		return new BooleanEquals(opOne, opTwo);
	}

	public VMRelationalOperator createOperator(VMObject opOne, VMObject opTwo) {
		return new VMGeneralEquals(opOne, opTwo);
	}

	public VMRelationalOperator createOperator(Number opOne, VMOperator opTwo) {
		return new NumberCompEquals(opOne, opTwo);
	}

	public VMRelationalOperator createOperator(Boolean opOne, VMOperator opTwo) {
		return new BooleanCompEquals(opOne, opTwo);
	}

	public VMRelationalOperator createOperator(VMOperator opOne, Number opTwo) {
		return createOperator(opTwo, opOne);
	}

	public VMRelationalOperator createOperator(VMOperator opOne, Boolean opTwo) {
		return createOperator(opTwo, opOne);
	}

	public VMRelationalOperator createOperator(VMOperator opOne,
			VMOperator opTwo) {
		return new VMOperatorEquals(opOne, opTwo);
	}

	public VMRelationalOperator createOperator(Number opOne, String opTwo) {
		return createOperator(opTwo, opOne);
	}

	public VMRelationalOperator createOperator(String opOne, Number opTwo) {
		return new VMVariableNumberEquals(opOne, opTwo);
	}

	public VMRelationalOperator createOperator(Boolean opOne, String opTwo) {
		return createOperator(opTwo, opOne);
	}

	public VMRelationalOperator createOperator(String opOne, Boolean opTwo) {
		return new VMVariableBooleanEquals(opOne, opTwo);
	}

	public VMRelationalOperator createOperator(String opOne, VMOperator opTwo) {
		return new VMVariableOperEquals(opOne, opTwo);
	}

	public VMRelationalOperator createOperator(VMOperator opOne, String opTwo) {
		return createOperator(opTwo, opOne);
	}

	public VMRelationalOperator createOperator(String opOne, VMObject opTwo) {
		return new VMVariableObjEquals(opOne, opTwo);
	}

	public VMRelationalOperator createOperator(VMObject opOne, String opTwo) {
		return createOperator(opTwo, opOne);
	}

	public VMRelationalOperator createOperator(String opOne, String opTwo) {
		return new VMVariableEquals(opOne, opTwo);
	}

	// Operator classes definitions

	public static final class NumberEquals extends VMRelationalOperator {
		private final Number opOne;
		private final Number opTwo;

		public NumberEquals(Number opOne, Number opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			return (opOne.equals(opTwo));
		}
	}

	/**
	 * This one is for integral types (long, int and short).
	 * 
	 * @author kidney
	 * 
	 */
	public static final class BooleanEquals extends VMRelationalOperator {
		private final Boolean opOne;
		private final Boolean opTwo;

		public BooleanEquals(Boolean opOne, Boolean opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			return (opOne.equals(opTwo));
		}
	}

	public static final class NumberCompEquals extends VMRelationalOperator {
		private final Number opOne;
		private final VMOperator opTwo;

		public NumberCompEquals(Number opOne, VMOperator opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			if (opOne instanceof Double) {
				return (opOne.equals(opTwo.evaluateDouble(env)));
			} else {
				return (opOne.longValue() == opTwo.evaluateLong(env)
						.longValue());
			}
		}
	}

	public static final class BooleanCompEquals extends VMRelationalOperator {
		private final Boolean opOne;
		private final VMOperator opTwo;

		public BooleanCompEquals(Boolean opOne, VMOperator opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			return (opOne.equals(opTwo.evaluateBoolean(env)));
		}
	}

	public static final class VMOperatorEquals extends VMRelationalOperator {
		private final VMOperator dOne;
		private final VMOperator dTwo;

		public VMOperatorEquals(VMOperator dOne, VMOperator dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			try {
				return (dOne.evaluateDouble(env).equals(dTwo
						.evaluateDouble(env)));
			} catch (VMEvaluationException e) {
				return (dOne.evaluateBoolean(env).equals(dTwo
						.evaluateBoolean(env)));
			}
		}
	}

	public static final class VMGeneralEquals extends VMRelationalOperator {
		private final VMObject oOne;
		private final VMObject oTwo;

		public VMGeneralEquals(VMObject oOne, VMObject oTwo) {
			this.oOne = oOne;
			this.oTwo = oTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			return oOne.equals(oTwo);
		}
	}

	public static final class VMVariableNumberEquals extends
			VMRelationalOperator {

		private final String opOne;
		private final Number opTwo;

		public VMVariableNumberEquals(String opOne, Number opTwo) {
			super();
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			try {
				final Number t = env.getBinding(opOne, Number.class);
				if (t == null) {
					throw new VMEvaluationException("Variable with name "
							+ opOne + "  found.");
				}
				return (t.equals(opTwo));
			} catch (ClassCastException e) {
				throw new VMEvaluationException(
						"Incompatible types found. First operand is of type "
								+ env.getNameType(opOne)
								+ ", the second is of type "
								+ opTwo.getClass().getName());
			}
		}
	}

	public static final class VMVariableBooleanEquals extends
			VMRelationalOperator {

		private final String opOne;
		private final Boolean opTwo;

		public VMVariableBooleanEquals(String opOne, Boolean opTwo) {
			super();
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			try {
				final Boolean t = env.getBinding(opOne, Boolean.class);
				if (t == null) {
					throw new VMEvaluationException("Variable with name "
							+ opOne + "  found.");
				}
				return (t.equals(opTwo));
			} catch (ClassCastException e) {
				throw new VMEvaluationException(
						"Incompatible types found. First operand is of type "
								+ env.getNameType(opOne)
								+ ", the second is of type "
								+ opTwo.getClass().getName());
			}
		}
	}

	public static final class VMVariableOperEquals extends VMRelationalOperator {

		private final String opOne;
		private final VMOperator opTwo;

		public VMVariableOperEquals(String opOne, VMOperator opTwo) {
			super();
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			final String type = env.getNameType(opOne);
			if (type == null) {
				throw new VMEvaluationException("Variable with name " + opOne
						+ "  found.");
			}
			if (type.equals(VMConstants.BOOLEAN)) {
				final Boolean t = env.getBinding(opOne, Boolean.class);
				final Boolean res = opTwo.evaluateBoolean(env);
				return (t.equals(res));
			} else {
				try {
					final Number t = env.getBinding(opOne, Number.class);
					// Double should contain most of the values
					return !(t.equals(opTwo.evaluateDouble(env)));
				} catch (ClassCastException e) {
					throw new VMEvaluationException(
							"Incompatible types found. First operand is of type "
									+ env.getNameType(opOne)
									+ ", the second is of type "
									+ opTwo.getClass().getName());
				}
			}
		}
	}

	public static final class VMVariableObjEquals extends VMRelationalOperator {

		private final String opOne;
		private final VMObject opTwo;

		public VMVariableObjEquals(String opOne, VMObject opTwo) {
			super();
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			try {
				final Object t = env.getBinding(opOne, opTwo.getClass());
				if (t == null) {
					throw new VMEvaluationException("Variable with name "
							+ opOne + "  found.");
				}
				return (t.equals(opTwo));
			} catch (ClassCastException e) {
				throw new VMEvaluationException(
						"Incompatible types found. First operand is of type "
								+ env.getNameType(opOne)
								+ ", the second is of type "
								+ opTwo.getClass().getName());
			}
		}
	}

	public static final class VMVariableEquals extends VMRelationalOperator {

		private final String opOne;
		private final String opTwo;

		public VMVariableEquals(String opOne, String opTwo) {
			super();
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			final Object oOne = env.getBinding(opOne, Object.class);
			if (oOne == null) {
				throw new VMEvaluationException("Variable with name " + opOne
						+ " not found.");
			}
			final Object oTwo = env.getBinding(opTwo, Object.class);
			if (oTwo == null) {
				throw new VMEvaluationException("Variable with name " + opTwo
						+ " not found.");
			}
			return (oOne.equals(oTwo));
		}
	}
}

package cz.cvut.fit.mirun.lemavm.structures.operators.control;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;

public final class VMEqualsOperatorFactory extends VMRelationalOperatorFactory {

	protected VMRelationalOperator createOperator(Number opOne, Number opTwo) {
		return new NumberEquals(opOne, opTwo);
	}

	protected VMRelationalOperator createOperator(Boolean opOne, Boolean opTwo) {
		return new BooleanEquals(opOne, opTwo);
	}

	protected VMRelationalOperator createOperator(VMObject opOne, VMObject opTwo) {
		return new VMGeneralEquals(opOne, opTwo);
	}

	protected VMRelationalOperator createOperator(Number opOne, VMOperator opTwo) {
		return new NumberCompEquals(opOne, opTwo);
	}

	protected VMRelationalOperator createOperator(Boolean opOne,
			VMOperator opTwo) {
		return new BooleanCompEquals(opOne, opTwo);
	}

	protected VMRelationalOperator createOperator(VMOperator opOne, Number opTwo) {
		return createOperator(opTwo, opOne);
	}

	protected VMRelationalOperator createOperator(VMOperator opOne,
			Boolean opTwo) {
		return createOperator(opTwo, opOne);
	}

	protected VMRelationalOperator createOperator(VMOperator opOne,
			VMOperator opTwo) {
		return new VMOperatorEquals(opOne, opTwo);
	}

	protected VMRelationalOperator createOperator(Number opOne, String opTwo) {
		return createOperator(opTwo, opOne);
	}

	protected VMRelationalOperator createOperator(String opOne, Number opTwo) {
		return new VMVariableNumberEquals(opOne, opTwo);
	}

	protected VMRelationalOperator createOperator(Boolean opOne, String opTwo) {
		return createOperator(opTwo, opOne);
	}

	protected VMRelationalOperator createOperator(String opOne, Boolean opTwo) {
		return new VMVariableBooleanEquals(opOne, opTwo);
	}

	protected VMRelationalOperator createOperator(String opOne, VMOperator opTwo) {
		return new VMVariableOperEquals(opOne, opTwo);
	}

	protected VMRelationalOperator createOperator(VMOperator opOne, String opTwo) {
		return createOperator(opTwo, opOne);
	}

	protected VMRelationalOperator createOperator(String opOne, VMObject opTwo) {
		return new VMVariableObjEquals(opOne, opTwo);
	}

	protected VMRelationalOperator createOperator(VMObject opOne, String opTwo) {
		return createOperator(opTwo, opOne);
	}

	protected VMRelationalOperator createOperator(String opOne, String opTwo) {
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

		@Override
		public Object evaluate(VMEnvironment env) {
			return evaluateBoolean(env);
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

		@Override
		public Object evaluate(VMEnvironment env) {
			return evaluateBoolean(env);
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

		@Override
		public Object evaluate(VMEnvironment env) {
			return evaluateBoolean(env);
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

		@Override
		public Object evaluate(VMEnvironment env) {
			return evaluateBoolean(env);
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

		@Override
		public Object evaluate(VMEnvironment env) {
			return evaluateBoolean(env);
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

		@Override
		public Object evaluate(VMEnvironment env) {
			return evaluateBoolean(env);
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
			final Number t = getBindingValue(opOne, Number.class, env);
			return (t.equals(opTwo));
		}

		@Override
		public Object evaluate(VMEnvironment env) {
			return evaluateBoolean(env);
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
			final Boolean t = getBindingValue(opOne, Boolean.class, env);
			return (t.equals(opTwo));
		}

		@Override
		public Object evaluate(VMEnvironment env) {
			return evaluateBoolean(env);
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

		@Override
		public Object evaluate(VMEnvironment env) {
			return evaluateBoolean(env);
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
			final Object t = getBindingValue(opOne, opTwo.getClass(), env);
			return (t.equals(opTwo));
		}

		@Override
		public Object evaluate(VMEnvironment env) {
			return evaluateBoolean(env);
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
			final Object oOne = getBindingValue(opOne, Object.class, env);
			final Object oTwo = getBindingValue(opTwo, Object.class, env);
			return (oOne.equals(oTwo));
		}

		@Override
		public Object evaluate(VMEnvironment env) {
			return evaluateBoolean(env);
		}
	}
}

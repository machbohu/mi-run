package cz.cvut.fit.mirun.lemavm.structures.operators.control;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class VMLogicalAndOperatorFactory extends
		VMRelationalOperatorFactory {

	@Override
	protected VMRelationalOperator createOperator(Number opOne, Number opTwo) {
		throw new VMParsingException("Unsupported operand types "
				+ opOne.getClass().getName() + ", "
				+ opTwo.getClass().getName());
	}

	@Override
	protected VMRelationalOperator createOperator(Boolean opOne, Boolean opTwo) {
		return new BooleanBooleanAnd(opOne, opTwo);
	}

	@Override
	protected VMRelationalOperator createOperator(VMObject opOne, VMObject opTwo) {
		throw new VMParsingException("Unsupported operand types "
				+ opOne.getClass().getName() + ", "
				+ opTwo.getClass().getName());
	}

	@Override
	protected VMRelationalOperator createOperator(Number opOne, VMOperator opTwo) {
		throw new VMParsingException("Unsupported operand types "
				+ opOne.getClass().getName() + ", "
				+ opTwo.getClass().getName());
	}

	@Override
	protected VMRelationalOperator createOperator(Boolean opOne,
			VMOperator opTwo) {
		return new BooleanCompAnd(opOne, opTwo);
	}

	@Override
	protected VMRelationalOperator createOperator(VMOperator opOne, Number opTwo) {
		throw new VMParsingException("Unsupported operand types "
				+ opOne.getClass().getName() + ", "
				+ opTwo.getClass().getName());
	}

	@Override
	protected VMRelationalOperator createOperator(VMOperator opOne,
			Boolean opTwo) {
		return createOperator(opTwo, opOne);
	}

	@Override
	protected VMRelationalOperator createOperator(VMOperator opOne,
			VMOperator opTwo) {
		return new CompCompAnd(opOne, opTwo);
	}

	@Override
	protected VMRelationalOperator createOperator(Number opOne, String opTwo) {
		throw new VMParsingException("Unsupported operand types "
				+ opOne.getClass().getName() + ", "
				+ opTwo.getClass().getName());
	}

	@Override
	protected VMRelationalOperator createOperator(String opOne, Number opTwo) {
		throw new VMParsingException("Unsupported operand types "
				+ opOne.getClass().getName() + ", "
				+ opTwo.getClass().getName());
	}

	@Override
	protected VMRelationalOperator createOperator(Boolean opOne, String opTwo) {
		return new BooleanVariableAnd(opOne, opTwo);
	}

	@Override
	protected VMRelationalOperator createOperator(String opOne, Boolean opTwo) {
		return createOperator(opTwo, opOne);
	}

	@Override
	protected VMRelationalOperator createOperator(String opOne, VMOperator opTwo) {
		return new VariableCompAnd(opOne, opTwo);
	}

	@Override
	protected VMRelationalOperator createOperator(VMOperator opOne, String opTwo) {
		return createOperator(opTwo, opOne);
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

	@Override
	protected VMRelationalOperator createOperator(String opOne, String opTwo) {
		return new VariableVariableAnd(opOne, opTwo);
	}

	// Operator definitions

	public static final class BooleanBooleanAnd extends VMRelationalOperator {
		private final Boolean opOne;
		private final Boolean opTwo;

		public BooleanBooleanAnd(Boolean opOne, Boolean opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			return (opOne && opTwo);
		}
	}

	public static final class BooleanCompAnd extends VMRelationalOperator {
		private final Boolean opOne;
		private final VMOperator opTwo;

		public BooleanCompAnd(Boolean opOne, VMOperator opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			return (opOne && opTwo.evaluateBoolean(env));
		}
	}

	public static final class CompCompAnd extends VMRelationalOperator {
		private final VMOperator opOne;
		private final VMOperator opTwo;

		public CompCompAnd(VMOperator opOne, VMOperator opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			return (opOne.evaluateBoolean(env) && opTwo.evaluateBoolean(env));
		}
	}

	public static final class BooleanVariableAnd extends VMRelationalOperator {
		private final Boolean opOne;
		private final String opTwo;

		public BooleanVariableAnd(Boolean opOne, String opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			return (opOne && getBindingValue(opTwo, Boolean.class, env));
		}
	}

	public static final class VariableCompAnd extends VMRelationalOperator {
		private final String opOne;
		private final VMOperator opTwo;

		public VariableCompAnd(String opOne, VMOperator opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			final Boolean bOne = getBindingValue(opOne, Boolean.class, env);
			return (bOne && opTwo.evaluateBoolean(env));
		}
	}

	public static final class VariableVariableAnd extends VMRelationalOperator {
		private final String opOne;
		private final String opTwo;

		public VariableVariableAnd(String opOne, String opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			final Boolean bOne = getBindingValue(opOne, Boolean.class, env);
			final Boolean bTwo = getBindingValue(opTwo, Boolean.class, env);
			return (bOne && bTwo);
		}
	}
}

package cz.cvut.fit.mirun.lemavm.structures.operators.control;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class VMLogicalOrOperatorFactory extends
		VMRelationalOperatorFactory {

	@Override
	protected VMRelationalOperator createOperator(Number opOne, Number opTwo) {
		throw new VMParsingException("Unsupported operOr types "
				+ opOne.getClass().getName() + ", "
				+ opTwo.getClass().getName());
	}

	@Override
	protected VMRelationalOperator createOperator(Boolean opOne, Boolean opTwo) {
		return new BooleanBooleanOr(opOne, opTwo);
	}

	@Override
	protected VMRelationalOperator createOperator(VMObject opOne, VMObject opTwo) {
		throw new VMParsingException("Unsupported operOr types "
				+ opOne.getClass().getName() + ", "
				+ opTwo.getClass().getName());
	}

	@Override
	protected VMRelationalOperator createOperator(Number opOne, VMOperator opTwo) {
		throw new VMParsingException("Unsupported operOr types "
				+ opOne.getClass().getName() + ", "
				+ opTwo.getClass().getName());
	}

	@Override
	protected VMRelationalOperator createOperator(Boolean opOne,
			VMOperator opTwo) {
		return new BooleanCompOr(opOne, opTwo);
	}

	@Override
	protected VMRelationalOperator createOperator(VMOperator opOne, Number opTwo) {
		throw new VMParsingException("Unsupported operOr types "
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
		return new CompCompOr(opOne, opTwo);
	}

	@Override
	protected VMRelationalOperator createOperator(Number opOne, String opTwo) {
		throw new VMParsingException("Unsupported operOr types "
				+ opOne.getClass().getName() + ", "
				+ opTwo.getClass().getName());
	}

	@Override
	protected VMRelationalOperator createOperator(String opOne, Number opTwo) {
		throw new VMParsingException("Unsupported operOr types "
				+ opOne.getClass().getName() + ", "
				+ opTwo.getClass().getName());
	}

	@Override
	protected VMRelationalOperator createOperator(Boolean opOne, String opTwo) {
		return new BooleanVariableOr(opOne, opTwo);
	}

	@Override
	protected VMRelationalOperator createOperator(String opOne, Boolean opTwo) {
		return createOperator(opTwo, opOne);
	}

	@Override
	protected VMRelationalOperator createOperator(String opOne, VMOperator opTwo) {
		return new VariableCompOr(opOne, opTwo);
	}

	@Override
	protected VMRelationalOperator createOperator(VMOperator opOne, String opTwo) {
		return createOperator(opTwo, opOne);
	}

	@Override
	protected VMRelationalOperator createOperator(String opOne, VMObject opTwo) {
		throw new VMParsingException("Unsupported operOr types "
				+ opOne.getClass().getName() + ", "
				+ opTwo.getClass().getName());
	}

	@Override
	protected VMRelationalOperator createOperator(VMObject opOne, String opTwo) {
		throw new VMParsingException("Unsupported operOr types "
				+ opOne.getClass().getName() + ", "
				+ opTwo.getClass().getName());
	}

	@Override
	protected VMRelationalOperator createOperator(String opOne, String opTwo) {
		return new VariableVariableOr(opOne, opTwo);
	}

	// Operator definitions

	public static final class BooleanBooleanOr extends VMRelationalOperator {
		private final Boolean opOne;
		private final Boolean opTwo;

		public BooleanBooleanOr(Boolean opOne, Boolean opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			return (opOne || opTwo);
		}
	}

	public static final class BooleanCompOr extends VMRelationalOperator {
		private final Boolean opOne;
		private final VMOperator opTwo;

		public BooleanCompOr(Boolean opOne, VMOperator opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			return (opOne || opTwo.evaluateBoolean(env));
		}
	}

	public static final class CompCompOr extends VMRelationalOperator {
		private final VMOperator opOne;
		private final VMOperator opTwo;

		public CompCompOr(VMOperator opOne, VMOperator opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			return (opOne.evaluateBoolean(env) || opTwo.evaluateBoolean(env));
		}
	}

	public static final class BooleanVariableOr extends VMRelationalOperator {
		private final Boolean opOne;
		private final String opTwo;

		public BooleanVariableOr(Boolean opOne, String opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			return (opOne || getBindingValue(opTwo, Boolean.class, env));
		}
	}

	public static final class VariableCompOr extends VMRelationalOperator {
		private final String opOne;
		private final VMOperator opTwo;

		public VariableCompOr(String opOne, VMOperator opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			final Boolean bOne = getBindingValue(opOne, Boolean.class, env);
			return (bOne || opTwo.evaluateBoolean(env));
		}
	}

	public static final class VariableVariableOr extends VMRelationalOperator {
		private final String opOne;
		private final String opTwo;

		public VariableVariableOr(String opOne, String opTwo) {
			this.opOne = opOne;
			this.opTwo = opTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			final Boolean bOne = getBindingValue(opOne, Boolean.class, env);
			final Boolean bTwo = getBindingValue(opTwo, Boolean.class, env);
			return (bOne || bTwo);
		}
	}
}

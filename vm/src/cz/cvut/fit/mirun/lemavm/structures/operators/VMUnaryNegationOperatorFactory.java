package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.compounds.VMCompoundNegation;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

public final class VMUnaryNegationOperatorFactory extends
		VMUnaryOperatorFactory {

	@Override
	protected VMOperator createOperator(VMOperator op) {
		return new VMCompoundNegation(op);
	}

	@Override
	protected VMOperator createOperator(Boolean op) {
		return new BooleanUnaryNegation(op);
	}

	@Override
	protected VMOperator createOperator(Number op) {
		throw new VMParsingException(
				"The unary negation operator is not applicable for number literal value.");
	}

	@Override
	protected VMOperator createOperator(String op) {
		return new VariableUnaryNegation(op);
	}

	// Operators definitions

	public static final class BooleanUnaryNegation extends VMOperator {
		private final Boolean op;

		public BooleanUnaryNegation(Boolean op) {
			this.op = op;
		}

		@Override
		public Double evaluateDouble(VMEnvironment env) {
			throw new VMParsingException(
					"The unary negation operator cannot a value of type double.");
		}

		@Override
		public Long evaluateLong(VMEnvironment env) {
			throw new VMParsingException(
					"The unary negation operator cannot a value of type long.");
		}

		@Override
		public Integer evaluateInt(VMEnvironment env) {
			throw new VMParsingException(
					"The unary negation operator cannot a value of type int.");
		}

		@Override
		public Short evaluateShort(VMEnvironment env) {
			throw new VMParsingException(
					"The unary negation operator cannot a value of type short.");
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			return !(op);
		}

		@Override
		public VMString evaluateString(VMEnvironment env) {
			return new VMString(evaluateBoolean(env).toString());
		}
	}

	public static final class VariableUnaryNegation extends VMOperator {
		private final String op;

		public VariableUnaryNegation(String op) {
			this.op = op;
		}

		@Override
		public Double evaluateDouble(VMEnvironment env) {
			throw new VMParsingException(
					"The unary negation operator cannot a value of type double.");
		}

		@Override
		public Long evaluateLong(VMEnvironment env) {
			throw new VMParsingException(
					"The unary negation operator cannot a value of type long.");
		}

		@Override
		public Integer evaluateInt(VMEnvironment env) {
			throw new VMParsingException(
					"The unary negation operator cannot a value of type int.");
		}

		@Override
		public Short evaluateShort(VMEnvironment env) {
			throw new VMParsingException(
					"The unary negation operator cannot a value of type short.");
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			Boolean b = getBindingValue(op, Boolean.class, env);
			return (!b);
		}

		@Override
		public VMString evaluateString(VMEnvironment env) {
			return new VMString(evaluateBoolean(env).toString());
		}
	}
}

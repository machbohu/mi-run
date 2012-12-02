package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.compounds.VMUnaryCompoundPlus;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

public final class VMUnaryPlusOperatorFactory extends VMUnaryOperatorFactory {

	@Override
	protected VMOperator createOperator(VMOperator op) {
		return new VMUnaryCompoundPlus(op);
	}

	@Override
	protected VMOperator createOperator(Boolean op) {
		throw new VMParsingException(
				"The unary plus operator is not applicable for type boolean.");
	}

	@Override
	protected VMOperator createOperator(Number op) {
		return new NumberUnaryPlus(op);
	}

	@Override
	protected VMOperator createOperator(String op) {
		return new VariableUnaryPlus(op);
	}

	// Operator definitions

	public static final class NumberUnaryPlus extends VMOperator {
		private final Number op;

		public NumberUnaryPlus(Number op) {
			this.op = op;
		}

		@Override
		public Double evaluateDouble(VMEnvironment env) {
			return Double.valueOf(+op.doubleValue());
		}

		@Override
		public Long evaluateLong(VMEnvironment env) {
			return Long.valueOf(+op.longValue());
		}

		@Override
		public Integer evaluateInt(VMEnvironment env) {
			return Integer.valueOf(+op.intValue());
		}

		@Override
		public Short evaluateShort(VMEnvironment env) {
			return Short.valueOf((short) +op.intValue());
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			throw new VMEvaluationException(
					"The unary Plus operator cannot return a boolean value.");
		}

		@Override
		public VMString evaluateString(VMEnvironment env) {
			return new VMString(evaluateInt(env).toString());
		}
	}

	public static final class VariableUnaryPlus extends VMOperator {
		private final String op;

		public VariableUnaryPlus(String op) {
			this.op = op;
		}

		@Override
		public Double evaluateDouble(VMEnvironment env) {
			final Number n = getBindingValue(op, Number.class, env);
			return Double.valueOf(+n.doubleValue());
		}

		@Override
		public Long evaluateLong(VMEnvironment env) {
			final Number n = getBindingValue(op, Number.class, env);
			return Long.valueOf(+n.longValue());
		}

		@Override
		public Integer evaluateInt(VMEnvironment env) {
			final Number n = getBindingValue(op, Number.class, env);
			return Integer.valueOf(+n.intValue());
		}

		@Override
		public Short evaluateShort(VMEnvironment env) {
			final Number n = getBindingValue(op, Number.class, env);
			return Short.valueOf((short) +n.intValue());
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			throw new VMEvaluationException(
					"The unary Plus operator cannot return a boolean value.");
		}

		@Override
		public VMString evaluateString(VMEnvironment env) {
			return new VMString(evaluateInt(env).toString());
		}
	}
}

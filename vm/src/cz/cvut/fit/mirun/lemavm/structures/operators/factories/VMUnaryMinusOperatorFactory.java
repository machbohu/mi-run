package cz.cvut.fit.mirun.lemavm.structures.operators.factories;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.structures.operators.compounds.VMUnaryCompoundMinus;

public final class VMUnaryMinusOperatorFactory extends VMUnaryOperatorFactory {

	@Override
	protected VMOperator createOperator(VMOperator op) {
		return new VMUnaryCompoundMinus(op);
	}

	@Override
	protected VMOperator createOperator(Boolean op) {
		throw new VMParsingException(
				"The unary minus operator is not applicable for type boolean.");
	}

	@Override
	protected VMOperator createOperator(Number op) {
		return new NumberUnaryMinus(op);
	}

	@Override
	protected VMOperator createOperator(String op) {
		return new VariableUnaryMinus(op);
	}

	public static final class NumberUnaryMinus extends VMOperator {
		private final Number op;

		public NumberUnaryMinus(Number op) {
			this.op = op;
		}

		@Override
		public Double evaluateDouble(VMEnvironment env) {
			return Double.valueOf(-op.doubleValue());
		}

		@Override
		public Long evaluateLong(VMEnvironment env) {
			return Long.valueOf(-op.longValue());
		}

		@Override
		public Integer evaluateInt(VMEnvironment env) {
			return Integer.valueOf(-op.intValue());
		}

		@Override
		public Short evaluateShort(VMEnvironment env) {
			return Short.valueOf((short) -op.intValue());
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			throw new VMEvaluationException(
					"The unary minus operator cannot return a boolean value.");
		}

		@Override
		public VMString evaluateString(VMEnvironment env) {
			return new VMString(evaluate(env).toString());
		}

		@Override
		public Object evaluate(VMEnvironment env) {
			if (op instanceof Double) {
				return Double.valueOf(-op.doubleValue());
			} else if (op instanceof Long) {
				return Long.valueOf(-op.longValue());
			} else {
				return Integer.valueOf(-op.intValue());
			}
		}
	}

	public static final class VariableUnaryMinus extends VMOperator {
		private final String op;

		public VariableUnaryMinus(String op) {
			this.op = op;
		}

		@Override
		public Double evaluateDouble(VMEnvironment env) {
			final Number n = getBindingValue(op, Number.class, env);
			return Double.valueOf(-n.doubleValue());
		}

		@Override
		public Long evaluateLong(VMEnvironment env) {
			final Number n = getBindingValue(op, Number.class, env);
			return Long.valueOf(-n.longValue());
		}

		@Override
		public Integer evaluateInt(VMEnvironment env) {
			final Number n = getBindingValue(op, Number.class, env);
			return Integer.valueOf(-n.intValue());
		}

		@Override
		public Short evaluateShort(VMEnvironment env) {
			final Number n = getBindingValue(op, Number.class, env);
			return Short.valueOf((short) -n.intValue());
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			throw new VMEvaluationException(
					"The unary minus operator cannot return a boolean value.");
		}

		@Override
		public VMString evaluateString(VMEnvironment env) {
			return new VMString(evaluate(env).toString());
		}

		@Override
		public Object evaluate(VMEnvironment env) {
			final Number n = getBindingValue(op, Number.class, env);
			if (n instanceof Double) {
				return Double.valueOf(-n.doubleValue());
			} else if (n instanceof Long) {
				return Long.valueOf(-n.longValue());
			} else {
				return Integer.valueOf(-n.intValue());
			}
		}
	}
}

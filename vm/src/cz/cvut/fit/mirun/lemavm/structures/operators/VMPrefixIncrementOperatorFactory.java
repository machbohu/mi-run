package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

public final class VMPrefixIncrementOperatorFactory extends
		VMUnaryOperatorFactory {

	@Override
	protected VMOperator createOperator(VMOperator op) {
		throw new VMParsingException(
				"The prefix increment operator is not applicable for operation result.");
	}

	@Override
	protected VMOperator createOperator(Boolean op) {
		throw new VMParsingException(
				"The prefix increment operator is not applicable for type boolean.");
	}

	@Override
	protected VMOperator createOperator(Number op) {
		throw new VMParsingException(
				"The prefix increment operator is not applicable for a number literal value.");
	}

	@Override
	protected VMOperator createOperator(String op) {
		return new VariablePrefixIncrement(op);
	}

	public static final class VariablePrefixIncrement extends VMOperator {

		private final String op;

		public VariablePrefixIncrement(String op) {
			this.op = op;
		}

		@Override
		public Double evaluateDouble(VMEnvironment env) {
			Number n = getBindingValue(op, Number.class, env);
			final Double d = Double.valueOf(n.doubleValue() + 1);
			env.addPrimitiveBinding(op, d, env.getNameType(op));
			return d;
		}

		@Override
		public Long evaluateLong(VMEnvironment env) {
			Number n = getBindingValue(op, Number.class, env);
			final Long d = Long.valueOf(n.longValue() + 1);
			env.addPrimitiveBinding(op, d, env.getNameType(op));
			return d;
		}

		@Override
		public Integer evaluateInt(VMEnvironment env) {
			Number n = getBindingValue(op, Number.class, env);
			final Integer d = Integer.valueOf(n.intValue() + 1);
			env.addPrimitiveBinding(op, d, env.getNameType(op));
			return d;
		}

		@Override
		public Short evaluateShort(VMEnvironment env) {
			Number n = getBindingValue(op, Number.class, env);
			final Short d = Short.valueOf((short) (n.shortValue() + 1));
			env.addPrimitiveBinding(op, d, env.getNameType(op));
			return d;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			throw new VMEvaluationException(
					"The postfix decrement operator cannot return a boolean value.");
		}

		@Override
		public VMString evaluateString(VMEnvironment env) {
			return new VMString(evaluateInt(env).toString());
		}

		@Override
		public Object evaluate(VMEnvironment env) {
			return evaluateInt(env);
		}
	}
}

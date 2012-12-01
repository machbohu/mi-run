package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.compounds.VMCompoundPostfixDecrement;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

public final class VMPostfixDecrementOperatorFactory implements
		VMUnaryOperatorFactory {

	@Override
	public VMOperator createOperator(VMOperator op) {
		return new VMCompoundPostfixDecrement(op);
	}

	@Override
	public VMOperator createOperator(Boolean op) {
		throw new VMParsingException(
				"The postfix decrement operator is not applicable for type boolean.");
	}

	@Override
	public VMOperator createOperator(Number op) {
		throw new VMParsingException(
				"The postfix decrement operator is not applicable for a number literal value.");
	}

	@Override
	public VMOperator createOperator(String op) {
		return new VariablePostfixDecrement(op);
	}

	public static final class VariablePostfixDecrement extends VMOperator {

		private final String op;

		public VariablePostfixDecrement(String op) {
			this.op = op;
		}

		@Override
		public Double evaluateDouble(VMEnvironment env) {
			Number n = getBindingValue(op, Number.class, env);
			final double d = n.doubleValue();
			env.addPrimitiveBinding(op, Double.valueOf(d - 1),
					env.getNameType(op));
			return d;
		}

		@Override
		public Long evaluateLong(VMEnvironment env) {
			Number n = getBindingValue(op, Number.class, env);
			final long d = n.longValue();
			env.addPrimitiveBinding(op, Long.valueOf(d - 1),
					env.getNameType(op));
			return d;
		}

		@Override
		public Integer evaluateInt(VMEnvironment env) {
			Number n = getBindingValue(op, Number.class, env);
			final int d = n.intValue();
			env.addPrimitiveBinding(op, Integer.valueOf(d - 1),
					env.getNameType(op));
			return d;
		}

		@Override
		public Short evaluateShort(VMEnvironment env) {
			Number n = getBindingValue(op, Number.class, env);
			final short d = n.shortValue();
			env.addPrimitiveBinding(op, Short.valueOf((short) (d - 1)),
					env.getNameType(op));
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
	}
}

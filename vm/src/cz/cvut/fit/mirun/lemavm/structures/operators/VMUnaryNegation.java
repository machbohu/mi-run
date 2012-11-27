package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMBoolean;

public final class VMUnaryNegation extends VMUnaryOperator {

	public VMUnaryNegation(VMObject operand) {
		super(operand);
	}

	@Override
	protected VMObject evaulateImpl(VMObject op) {
		if (LOG.isTraceEnabled()) {
			LOG.trace("UnaryNegation evaluating: " + op);
		}
		if (op instanceof VMBoolean) {
			final VMBoolean b = (VMBoolean) op;
			return (b.getValue() ? VMBoolean.FALSE : VMBoolean.TRUE);
		}
		throw new VMEvaluationException(
				"Operator ! is not applicable for operand of type "
						+ op.getType());
	}
}

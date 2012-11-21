package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.core.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMDouble;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMInteger;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMLong;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMNumber;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMShort;

public final class VMPostfixIncrement extends VMUnaryOperator {

	public VMPostfixIncrement(VMObject operand) {
		super(operand);
	}

	@Override
	protected VMObject evaulateImpl(VMObject op) {
		if (LOG.isTraceEnabled()) {
			LOG.trace("PostfixIncrement evaluating: " + op);
		}
		if (!(op instanceof VMNumber)) {
			throw new VMEvaluationException(
					"PostfixIncrement is not applicable for operand of type "
							+ op.getType());
		}
		if (op instanceof VMShort) {
			final VMShort n = (VMShort) op;
			n.increment();
		} else if (op instanceof VMInteger) {
			final VMInteger n = (VMInteger) op;
			n.increment();
		} else if (op instanceof VMLong) {
			final VMLong n = (VMLong) op;
			n.increment();
		} else if (op instanceof VMDouble) {
			final VMDouble n = (VMDouble) op;
			n.increment();
		} else {
			throw new VMEvaluationException(
					"PostfixIncrement is not applicable for operand of type "
							+ op.getType());
		}
		return op;
	}
}

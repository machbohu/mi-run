package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.core.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMDouble;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMInteger;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMLong;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMNumber;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMShort;

public final class VMPrefixDecrement extends VMUnaryOperator {

	public VMPrefixDecrement(VMObject operand) {
		super(operand);
	}

	@Override
	protected VMObject evaulateImpl(VMObject op) {
		if (LOG.isTraceEnabled()) {
			LOG.trace("PrefixDecrement evaluating: " + op);
		}
		if (!(op instanceof VMNumber)) {
			throw new VMEvaluationException(
					"PrefixDecrement is not applicable for operand of type "
							+ op.getType());
		}
		if (op instanceof VMShort) {
			final VMShort n = (VMShort) op;
			n.decrement();
		} else if (op instanceof VMInteger) {
			final VMInteger n = (VMInteger) op;
			n.decrement();
		} else if (op instanceof VMLong) {
			final VMLong n = (VMLong) op;
			n.decrement();
		} else if (op instanceof VMDouble) {
			final VMDouble n = (VMDouble) op;
			n.decrement();
		} else {
			throw new VMEvaluationException(
					"PrefixDecrement is not applicable for operand of type "
							+ op.getType());
		}
		return op;
	}
}

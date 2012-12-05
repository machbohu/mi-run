package cz.cvut.fit.mirun.lemavm.structures.operators.plus;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class VMCompoundPlus extends AbstractBinaryPlus {

	private final VMOperator opOne;
	private final VMOperator opTwo;

	public VMCompoundPlus(VMOperator opOne, VMOperator opTwo) {
		this.opOne = opOne;
		this.opTwo = opTwo;
	}

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		Double dOne = opOne.evaluateDouble(env);
		Double dTwo = opTwo.evaluateDouble(env);
		return (dOne.doubleValue() + dTwo.doubleValue());
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		Long dOne = opOne.evaluateLong(env);
		Long dTwo = opTwo.evaluateLong(env);
		return (dOne.longValue() + dTwo.longValue());
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		Integer dOne = opOne.evaluateInt(env);
		Integer dTwo = opTwo.evaluateInt(env);
		return (dOne.intValue() + dTwo.intValue());
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		Short dOne = opOne.evaluateShort(env);
		Short dTwo = opTwo.evaluateShort(env);
		return (short) (dOne.shortValue() + dTwo.shortValue());
	}

	@Override
	public Boolean evaluateBoolean(VMEnvironment env) {
		throw new VMEvaluationException("Operator cannot return boolean value.");
	}

	@Override
	public VMString evaluateString(VMEnvironment env) {
		final Object r = evaluate(env);
		if (r instanceof VMString) {
			return (VMString) r;
		} else {
			return new VMString(r.toString());
		}
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		final Object resOne = opOne.evaluate(env);
		final Object resTwo = opTwo.evaluate(env);
		if (resOne instanceof VMString) {
			final VMString sOne = (VMString) resOne;
			if (resTwo instanceof VMString) {
				return new VMString(sOne.getValue()
						+ ((VMString) resTwo).getValue());
			} else {
				return new VMString(sOne.getValue() + resTwo.toString());
			}
		} else if (resTwo instanceof VMString) {
			return new VMString(resOne.toString()
					+ ((VMString) resTwo).getValue());
		} else {
			return addNumbers((Number) resOne, (Number) resTwo);
		}
	}
}

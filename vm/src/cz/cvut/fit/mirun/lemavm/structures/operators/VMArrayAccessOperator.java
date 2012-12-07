package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.Evaluable;
import cz.cvut.fit.mirun.lemavm.structures.VMArray;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.ParsingUtils;

public final class VMArrayAccessOperator implements Evaluable {

	private final String array;
	private final Object index;

	/**
	 * 
	 * @param array
	 *            Array name
	 * @param index
	 *            Index of value in array
	 */
	public VMArrayAccessOperator(String array, Object index) {
		if (array == null || index == null) {
			throw new NullPointerException();
		}
		this.array = array;
		this.index = index;
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		final VMArray arr = env.getBinding(array, VMArray.class);
		if (arr == null) {
			throw new VMEvaluationException("Array with name " + array
					+ " not found.");
		}
		final int ind = resolveArrayIndex(index, env);
		return arr.get(ind);
	}

	public static int resolveArrayIndex(Object index, VMEnvironment env) {
		if (index instanceof VMOperator) {
			VMOperator op = (VMOperator) index;
			return op.evaluateInt(env);
		} else if (index instanceof String) {
			final String str = (String) index;
			Number n = ParsingUtils.tryParsingNumber(str);
			if (n == null) {
				n = env.getBinding(str, Number.class);
				if (n == null) {
					throw new VMEvaluationException("No variable with name "
							+ str + " found in this environment.");
				}
			}
			if (!(n instanceof Integer) && !(n instanceof Short)) {
				throw new VMEvaluationException(
						"Arrays can be indexed only by int or short numbers.");
			}
			return n.intValue();
		} else {
			throw new VMEvaluationException("Unsupported array index type "
					+ index);
		}
	}
}

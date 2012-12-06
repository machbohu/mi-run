package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.structures.Evaluable;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.utils.ParsingUtils;

public final class AssignOperatorFactory {

	/**
	 * Create assign operator from the specified arguments. </p>
	 * 
	 * The type of the operator is decided from the runtime type of the value.
	 * 
	 * @param name
	 *            Name value should be assigned to
	 * @param type
	 *            Declared type of the name. If this is an existing binding, can
	 *            be null
	 * @param isFinal
	 *            True if the binding should be final
	 * @param value
	 *            Value to assign
	 * @return VMAssignOperator
	 */
	public VMAssignOperator createOperator(String name, String type,
			boolean isFinal, Object value) {
		if (value instanceof VMOperator) {
			return createOperator(name, type, isFinal, (VMOperator) value);
		} else if (value instanceof VMObject) {
			return createOperator(name, type, isFinal, (VMObject) value);
		} else if (value instanceof Evaluable) {
			return createOperator(name, type, isFinal, (Evaluable) value);
		} else {
			return createOperator(name, type, isFinal, (String) value);
		}
	}

	/**
	 * Create operator for assigning array element values. </p>
	 * 
	 * @param name
	 *            Name of the array
	 * @param type
	 *            Type of elements in the array
	 * @param index
	 *            Index expression
	 * @param value
	 *            The value to set
	 * @return VMAssignOperator
	 */
	public VMAssignOperator createOperator(String name, String type,
			Object index, Object value) {
		return createArrayAssignOperator(name, type, index, value);
	}

	protected VMAssignOperator createOperator(String name, String type,
			boolean isFinal, Number value) {
		return new VMAssignNumber(name, type, isFinal, value);
	}

	protected VMAssignOperator createOperator(String name, String type,
			boolean isFinal, Boolean value) {
		return new VMAssignBoolean(name, type, isFinal, value);
	}

	protected VMAssignOperator createOperator(String name, String type,
			boolean isFinal, VMOperator value) {
		return new VMAssignExpr(name, type, isFinal, value);
	}

	protected VMAssignOperator createOperator(String name, String type,
			boolean isFinal, VMObject value) {
		return new VMAssignReference(name, type, isFinal, value);
	}

	protected VMAssignOperator createOperator(String name, String type,
			boolean isFinal, String value) {
		if (value.startsWith("\"")) {
			return new VMAssignString(name, type, isFinal, value);
		}
		final Boolean b = ParsingUtils.tryParsingBoolean(value);
		if (b != null) {
			// Assign boolean
			return createOperator(name, type, isFinal, b);
		}
		final Number n = ParsingUtils.tryParsingNumber(value);
		if (n != null) {
			// Assign number
			return createOperator(name, type, isFinal, n);
		}
		// Assign variable
		return new VMAssignVariable(name, type, isFinal, value);
	}

	protected VMAssignOperator createOperator(String name, String type,
			boolean isFinal, Evaluable value) {
		return new VMAssignEvaluationResult(name, type, isFinal, value);
	}

	protected VMAssignOperator createArrayAssignOperator(String name,
			String type, Object index, Object value) {
		return new VMArrayAssignOperator(name, type, index, value);
	}
}

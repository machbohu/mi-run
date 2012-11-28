package cz.cvut.fit.mirun.lemavm.structures.control;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMCodeBlock;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.operators.control.VMRelationalOperator;

public final class VMWhile extends VMObject {

	private final VMRelationalOperator condition;
	private final VMCodeBlock whilePart;

	/**
	 * Constructor for this while statement.</p>
	 * 
	 * @param condition
	 *            Condition
	 * @param whilePart
	 *            While part
	 */
	public VMWhile(VMRelationalOperator condition, VMCodeBlock whilePart) {
		super(ObjectType.WHILE);
		if (condition == null || whilePart == null) {
			throw new VMParsingException(
					"Illegal arguments passed to VMWhile constructor: "
							+ condition + ", " + whilePart);
		}
		this.condition = condition;
		this.whilePart = whilePart;
	}

	@Override
	public VMObject evaluate() {
		final boolean res = condition.evaluateBoolean();
		if (res) {
			// TODO prepend this instance of while to the CodeBlock whilePart
			// for later repeated evaluation
			return whilePart;
		} else {
			return null;
		}
	}

}

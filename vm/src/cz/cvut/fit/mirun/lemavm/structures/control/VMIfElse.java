package cz.cvut.fit.mirun.lemavm.structures.control;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMCodeBlock;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.operators.control.VMRelationalOperator;

public final class VMIfElse extends VMObject {

	private final VMRelationalOperator condition;
	private final VMCodeBlock ifPart;
	private final VMCodeBlock elsePart;

	/**
	 * Constructor for this if-else statement.</p>
	 * 
	 * The {@code elsePart} can be null which will mean that this is an if-then
	 * statement.
	 * 
	 * @param condition
	 *            Condition
	 * @param ifPart
	 *            If part
	 * @param elsePart
	 *            Else part. Optional
	 */
	public VMIfElse(VMRelationalOperator condition, VMCodeBlock ifPart,
			VMCodeBlock elsePart) {
		super(ObjectType.IF_ELSE);
		if (condition == null || ifPart == null) {
			throw new VMParsingException(
					"Illegal arguments passed to VMIfElse constructor: "
							+ condition + ", " + ifPart);
		}
		this.condition = condition;
		this.ifPart = ifPart;
		this.elsePart = elsePart;
	}

	@Override
	public VMObject evaluate() {
		final boolean res = condition.evaluateBoolean();
		if (res) {
			return ifPart;
		} else {
			return elsePart;
		}
	}

}

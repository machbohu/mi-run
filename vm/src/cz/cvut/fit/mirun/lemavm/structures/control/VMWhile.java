package cz.cvut.fit.mirun.lemavm.structures.control;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMCodeBlock;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMBoolean;

public final class VMWhile extends VMObject {

	private final VMObject condition;
	private final VMCodeBlock whilePart;

	/**
	 * Constructor for this while statement.</p>
	 * 
	 * @param condition
	 *            Condition
	 * @param whilePart
	 *            While part
	 */
	public VMWhile(VMObject condition, VMCodeBlock whilePart) {
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
		final VMObject condRes = condition.evaluate();
		if (!condRes.getType().equals(ObjectType.BOOLEAN)) {
			throw new VMEvaluationException(
					"The result of while condition evaluation is not a boolean.");
		}
		final VMBoolean res = (VMBoolean) condRes;
		if (res.getValue()) {
			// TODO prepend this instance of while to the CodeBlock whilePart for later repeated evaluation
			return whilePart;
		} else {
			return null;
		}
	}

}

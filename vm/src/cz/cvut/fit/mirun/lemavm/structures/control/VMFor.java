package cz.cvut.fit.mirun.lemavm.structures.control;

import cz.cvut.fit.mirun.lemavm.core.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.core.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMCodeBlock;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMBoolean;

public final class VMFor extends VMObject {

//	private final VMObject index;
	private final VMObject condition;
	private final VMObject operation;
	private final VMCodeBlock forPart;

	/**
	 * Constructor for this while statement.</p>
	 * 
	 * @param index
	 *            Index
	 * @param condition
	 *            Condition
	 * @param operation
	 *            Operation
	 * @param forPart
	 *            For part
	 */
	public VMFor(/*VMObject index, */VMObject condition, VMObject operation, VMCodeBlock forPart) {
		super(ObjectType.FOR);
		if (/*index == null || */condition == null || operation == null || forPart == null) {
			throw new VMParsingException(
					"Illegal arguments passed to VMFor constructor: "
							/*+ index + ", "*/ + condition + ", " + operation + ", " + forPart);
		}
//		this.index = index;
		this.condition = condition;
		this.operation = operation;
		this.forPart = forPart;
	}

	@Override
	public VMObject evaluate() {
		final VMObject condRes = condition.evaluate();
		if (!condRes.getType().equals(ObjectType.BOOLEAN)) {
			throw new VMEvaluationException(
					"The result of for condition evaluation is not a boolean.");
		}
		final VMBoolean res = (VMBoolean) condRes;
		if (res.getValue()) {
			// TODO prepend operation and 
			// this instance of for to the CodeBlock forPart for later repeated evaluation
			return forPart;
		} else {
			return null;
		}
	}

}

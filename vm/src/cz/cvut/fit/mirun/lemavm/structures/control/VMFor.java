package cz.cvut.fit.mirun.lemavm.structures.control;

import org.antlr.runtime.tree.CommonTree;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMCodeBlock;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.operators.control.VMRelationalOperator;

public final class VMFor extends VMObject {

	// private final VMObject index;
	private final VMRelationalOperator condition;
	private final VMObject operation;
	private final CommonTree forTree;
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
	public VMFor(/* VMObject index, */VMRelationalOperator condition,
			VMObject operation, CommonTree forTree) {
		super(ObjectType.FOR);
		if (/* index == null || */condition == null || operation == null
				|| forTree == null) {
			throw new VMParsingException(
					"Illegal arguments passed to VMFor constructor: "
					/* + index + ", " */+ condition + ", " + operation + ", "
							+ forTree);
		}
		// this.index = index;
		this.condition = condition;
		this.operation = operation;
		this.forPart = null;
		this.forTree = forTree;
	}

	@Override
	public VMObject evaluate() {
		final boolean res = condition.evaluateBoolean();
		if (res) {
			// TODO build codeBlock from AST, prepend operation and
			// this instance of for to the CodeBlock forPart for later repeated evaluation
			return forPart;
		} else {
			return null;
		}
	}

}

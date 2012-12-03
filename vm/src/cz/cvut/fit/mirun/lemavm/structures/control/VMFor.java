package cz.cvut.fit.mirun.lemavm.structures.control;

import java.util.List;

import org.antlr.runtime.tree.CommonTree;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMCodeBlock;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

public final class VMFor extends VMControlStructure {

	private final List<Object> inits;
	private final Object condition;
	private final Object operation;
	private final CommonTree forTree;
	private final VMCodeBlock forPart;

	/**
	 * Constructor for this while statement.</p>
	 * 
	 * @param inits
	 *            Initialize arguments
	 * @param condition
	 *            Condition
	 * @param operation
	 *            Operation
	 * @param forPart
	 *            For part
	 */
	public VMFor(List<Object> inits, Object condition, Object operation,
			CommonTree forTree) {
		super(ObjectType.FOR);
		if (/* index == null || */condition == null || operation == null
				|| forTree == null) {
			throw new VMParsingException(
					"Illegal arguments passed to VMFor constructor: "
					/* + index + ", " */+ condition + ", " + operation + ", "
							+ forTree);
		}
		this.inits = inits;
		this.condition = condition;
		this.operation = operation;
		this.forPart = null;
		this.forTree = forTree;
	}

	@Override
	public VMObject evaluate(VMEnvironment env) {
		// final boolean res = condition.evaluateBoolean();
		// if (res) {
		// // TODO build codeBlock from AST, prepend operation and
		// // this instance of for to the CodeBlock forPart for later repeated
		// evaluation
		// return forPart;
		// }

		return null;
	}

}

package cz.cvut.fit.mirun.lemavm.structures.control;

import org.antlr.runtime.tree.CommonTree;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMCodeBlock;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.control.VMRelationalOperator;

public final class VMWhile extends VMControlStructure {

	private final VMRelationalOperator condition;
	private final CommonTree whileTree;
	private final VMCodeBlock whilePart;

	/**
	 * Constructor for this while statement.</p>
	 * 
	 * @param condition
	 *            Condition
	 * @param whilePart
	 *            While part
	 */
	public VMWhile(VMRelationalOperator condition, CommonTree whileTree) {
		super(ObjectType.WHILE);
		if (condition == null || whileTree == null) {
			throw new VMParsingException(
					"Illegal arguments passed to VMWhile constructor: "
							+ condition + ", " + whileTree);
		}
		this.condition = condition;
		this.whileTree = whileTree;
		this.whilePart = null;
	}

	@Override
	public VMObject evaluate(VMEnvironment env) {
		final boolean res = condition.evaluateBoolean(env);
		if (res) {
			// TODO build codeBlock from AST and
			// prepend this instance of while to the CodeBlock whilePart
			// for later repeated evaluation
			return whilePart;
		} else {
			return null;
		}
	}

}

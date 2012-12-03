package cz.cvut.fit.mirun.lemavm.structures.control;

import org.antlr.runtime.tree.CommonTree;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMCodeBlock;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.control.VMRelationalOperator;

public final class VMIfElse extends VMControlStructure {

	private final VMRelationalOperator condition;
	private final CommonTree ifTree;
	private final VMCodeBlock ifPart;
	private final CommonTree elseTree;
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
	public VMIfElse(VMRelationalOperator condition, CommonTree ifTree,
			CommonTree elseTree) {
		super(ObjectType.IF_ELSE);
		if (condition == null || ifTree == null) {
			throw new VMParsingException(
					"Illegal arguments passed to VMIfElse constructor: "
							+ condition + ", " + ifTree);
		}
		this.condition = condition;
		this.ifTree = ifTree;
		this.ifPart = null;
		this.elseTree = elseTree;
		this.elsePart = null;
	}

	@Override
	public VMObject evaluate(VMEnvironment env) {
		final boolean res = condition.evaluateBoolean(env);
		if (res) {
			// TODO build codeBlock from AST
			return ifPart;
		} else {
			// TODO build codeBlock from AST
			return elsePart;
		}
	}

}

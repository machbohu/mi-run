package cz.cvut.fit.mirun.lemavm.structures.control;

import org.antlr.runtime.tree.CommonTree;

import cz.cvut.fit.mirun.lemavm.builder.VMCreator;
import cz.cvut.fit.mirun.lemavm.core.VMInterpreter;
import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMCodeBlock;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.control.VMRelationalOperator;

public final class VMIfElse extends VMControlStructure {

	private final VMRelationalOperator condition;
	private final CommonTree ifTree;
	private VMCodeBlock ifPart;
	private final CommonTree elseTree;
	private VMCodeBlock elsePart;

	/**
	 * Constructor for this if-else statement.</p>
	 * 
	 * The {@code elseTree} can be null which will mean that this is an if-then
	 * statement.
	 * 
	 * @param condition
	 *            Condition
	 * @param ifTree
	 *            If AST subtree
	 * @param elseTree
	 *            Else AST subtree. Optional
	 */
	public VMIfElse(Object condition, CommonTree ifTree,
			CommonTree elseTree) {
		super(ObjectType.IF_ELSE);
		if (condition == null || !(condition instanceof VMRelationalOperator) 
				|| ifTree == null) {
			throw new VMParsingException(
					"Illegal arguments passed to VMIfElse constructor: "
							+ condition + ", " + ifTree);
		}
		this.condition = (VMRelationalOperator) condition;
		this.ifTree = ifTree;
		this.ifPart = null;
		this.elseTree = elseTree;
		this.elsePart = null;
	}

	@Override
	public VMCodeBlock evaluate(VMEnvironment env) {
		final VMEnvironment newEnv = new VMEnvironment(env);
		final boolean res = condition.evaluateBoolean(env);
		
		if(res){
			if(ifPart == null){
				ifPart = VMCreator.createCodeBlockFromTree(ifTree);
			}
			VMInterpreter.getInstance().invokeCodeBlock(newEnv, ifPart);
		}else if(elseTree != null){
			if(elsePart == null){
				elsePart = VMCreator.createCodeBlockFromTree(elseTree);
			}
			VMInterpreter.getInstance().invokeCodeBlock(newEnv, elsePart);
		}
		
		return null;
	}

}

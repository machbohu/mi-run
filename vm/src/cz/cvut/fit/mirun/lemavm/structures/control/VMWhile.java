package cz.cvut.fit.mirun.lemavm.structures.control;

import org.antlr.runtime.tree.CommonTree;

import cz.cvut.fit.mirun.lemavm.builder.VMCreator;
import cz.cvut.fit.mirun.lemavm.core.VMInterpreter;
import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.Evaluable;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMCodeBlock;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.control.VMRelationalOperator;

public final class VMWhile extends VMControlStructure {

	private final Evaluable condition;
	private final CommonTree whileTree;
	private VMCodeBlock whilePart;

	/**
	 * Constructor for this while statement.</p>
	 * 
	 * @param condition
	 *            Condition
	 * @param whileTree
	 *            While AST subtree
	 */
	public VMWhile(Object condition, CommonTree whileTree) {
		super(ObjectType.WHILE);
		if (condition == null || !(condition instanceof Evaluable) 
				|| whileTree == null) {
			throw new VMParsingException(
					"Illegal arguments passed to VMWhile constructor: "
							+ condition + ", " + whileTree);
		}
		this.condition = (VMRelationalOperator) condition;
		this.whileTree = whileTree;
		this.whilePart = null;
	}

	@Override
	public VMCodeBlock evaluate(VMEnvironment env) {
		if(whilePart == null){
			whilePart = VMCreator.createCodeBlockFromTree(whileTree);
		}
		
		final VMEnvironment newEnv = new VMEnvironment(env);
		
		while(checkCondition(condition, env) && !env.shouldReturn()){
			VMInterpreter.getInstance().invokeCodeBlock(newEnv, whilePart);
		}
		
		return null;
	}
}

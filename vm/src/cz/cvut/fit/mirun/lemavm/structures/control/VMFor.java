package cz.cvut.fit.mirun.lemavm.structures.control;

import java.util.List;

import org.antlr.runtime.tree.CommonTree;

import cz.cvut.fit.mirun.lemavm.builder.VMCreator;
import cz.cvut.fit.mirun.lemavm.core.VMInterpreter;
import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.Evaluable;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMCodeBlock;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

public final class VMFor extends VMControlStructure {

	private final List<Object> inits;
	private final Evaluable condition;
	private final Evaluable operation;
	private final CommonTree forTree;
	private VMCodeBlock forPart;

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
		if (checkInits(inits) || 
				condition == null || !(condition instanceof Evaluable) || 
				operation == null || !(operation instanceof Evaluable) ||
				forTree == null) {
			throw new VMParsingException(
					"Illegal arguments passed to VMFor constructor: "
					 + inits + ", " + condition + ", " + operation + ", "
							+ forTree);
		}
		// TODO check inits if already exists
		this.inits = inits;
		this.condition = (Evaluable) condition;
		this.operation = (Evaluable) operation;
		this.forPart = null;
		this.forTree = forTree;
	}

	@Override
	public VMObject evaluate(VMEnvironment env) {
		if(forPart == null){
			forPart = VMCreator.createCodeBlockFromTree(forTree);
		}
		
		final VMEnvironment newEnv = new VMEnvironment(env);
		Evaluable init = null;
		
		for(Object o : inits){
			init = (Evaluable) o;
			init.evaluate(newEnv);
		}
		
		for(;checkCondition(condition, env) && !env.shouldReturn();operation.evaluate(env)){
			VMInterpreter.getInstance().invokeCodeBlock(newEnv, forPart);
		}
		
		return null;
	}
	
	private boolean checkInits(List<Object> inits){
		if(inits == null || inits.size() <= 0){
			return false;
		}
		
		for(Object o : inits){
			if(!(o instanceof Evaluable)){
				return false;
			}
		}
		
		return true;
	}

}

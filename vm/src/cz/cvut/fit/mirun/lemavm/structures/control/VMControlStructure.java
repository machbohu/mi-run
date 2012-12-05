package cz.cvut.fit.mirun.lemavm.structures.control;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.Evaluable;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

public abstract class VMControlStructure implements Evaluable {
	private ObjectType type;

	public VMControlStructure(ObjectType type) {
		this.type = type;
	}

	public ObjectType getType() {
		return type;
	}
	
	protected boolean checkCondition(Evaluable condition, VMEnvironment env){
		Object res = condition.evaluate(env);
		
		if(!(res instanceof Boolean)){
			throw new VMEvaluationException("Cannot evaluate condition "+condition
					+" with result "+res);
		}
		
		return (Boolean) res;
	}
}

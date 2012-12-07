package cz.cvut.fit.mirun.lemavm.assignment;

import org.apache.log4j.Logger;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.Evaluable;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

public abstract class VMAssignOperator implements Evaluable {

	protected static final Logger LOG = Logger
			.getLogger(VMAssignOperator.class);

	protected final String name;
	protected String type;
	protected final boolean isFinal;

	public VMAssignOperator(String name, String type, boolean isFinal) {
		if (name == null) {
			throw new NullPointerException();
		}
		this.name = name;
		// Type can be null if it is assignment to already existing name
		this.type = type;
		this.isFinal = isFinal;
	}

	protected void resolveType(VMEnvironment env) {
		if (type == null) {
			// This is an assignment into an existing variable
			type = env.getNameType(name);
			if (type == null) {
				throw new VMEvaluationException(
						"Assignment to a name without any declared type.");
			}
		}
	}
}

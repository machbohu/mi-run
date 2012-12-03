package cz.cvut.fit.mirun.lemavm.structures;

import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

public interface Evaluable {

	/**
	 * Evaluate this node.
	 * 
	 * @param env
	 *            The environment in which this method should do the evaluation
	 * @return Result of the evaluation
	 */
	public VMObject evaluate(VMEnvironment env);
}

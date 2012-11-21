package cz.cvut.fit.mirun.lemavm.structures;

public interface Evaluable {

	/**
	 * Evaluate this node.
	 * 
	 * @return Result of the evaluation
	 */
	public VMObject evaluate();
}

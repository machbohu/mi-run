package cz.cvut.fit.mirun.lemavm.structures;

/**
 * Base class for operators. It just defines the type. </p>
 * 
 * @author kidney
 * 
 */
public abstract class VMOperator extends VMObject {

	public VMOperator() {
		super(ObjectType.OPERATOR);
	}
}

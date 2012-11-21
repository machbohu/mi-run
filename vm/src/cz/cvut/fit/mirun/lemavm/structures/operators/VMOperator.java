package cz.cvut.fit.mirun.lemavm.structures.operators;

import org.apache.log4j.Logger;

import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;

/**
 * Base class for operators. It just defines the type. </p>
 * 
 * @author kidney
 * 
 */
public abstract class VMOperator extends VMObject {

	protected static final Logger LOG = Logger.getLogger(VMOperator.class);

	public VMOperator() {
		super(ObjectType.OPERATOR);
	}
}

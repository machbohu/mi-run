package cz.cvut.fit.mirun.lemavm.structures.operators;

import org.apache.log4j.Logger;

import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMHeader;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

/**
 * Base class for operators. It just defines the type. </p>
 * 
 * @author kidney
 * 
 */
public abstract class VMOperator {

	protected static final Logger LOG = Logger.getLogger(VMOperator.class);

	private final VMHeader header;
	protected ObjectType returnType;

	public VMOperator() {
		super();
		header = new VMHeader();
		header.setType(ObjectType.OPERATOR);
	}

	/**
	 * Evaluate this operator and return result
	 * 
	 * @return Double
	 */
	public abstract Double evaluateDouble(VMEnvironment env);

	/**
	 * Evaluate this operator and return result
	 * 
	 * @return Long
	 */
	public abstract Long evaluateLong(VMEnvironment env);

	/**
	 * Evaluate this operator and return result
	 * 
	 * @return Integer
	 */
	public abstract Integer evaluateInt(VMEnvironment env);

	/**
	 * Evaluate this operator and return result
	 * 
	 * @return Short
	 */
	public abstract Short evaluateShort(VMEnvironment env);

	/**
	 * Evaluate this operator and return result
	 * 
	 * @return Boolean
	 */
	public abstract Boolean evaluateBoolean(VMEnvironment env);

	/**
	 * Evaluate this operator and return result
	 * 
	 * @return VMString
	 */
	public abstract VMString evaluateString(VMEnvironment env);

	public ObjectType getType() {
		return header.getType();
	}

	public VMHeader getHeader() {
		return header;
	}

	public ObjectType getReturnType() {
		return returnType;
	}

	public void setReturnType(ObjectType returnType) {
		this.returnType = returnType;
	}
}

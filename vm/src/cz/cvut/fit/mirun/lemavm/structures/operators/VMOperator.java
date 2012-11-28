package cz.cvut.fit.mirun.lemavm.structures.operators;

import org.apache.log4j.Logger;

import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMHeader;

/**
 * Base class for operators. It just defines the type. </p>
 * 
 * @author kidney
 * 
 */
public abstract class VMOperator {

	protected static final Logger LOG = Logger.getLogger(VMOperator.class);

	private final VMHeader header;

	public VMOperator() {
		super();
		header = new VMHeader();
		header.setType(ObjectType.OPERATOR);
	}

	/**
	 * Evaluate this operator and return result
	 * 
	 * @return double
	 */
	public abstract double evaluateDouble();

	/**
	 * Evaluate this operator and return result
	 * 
	 * @return long
	 */
	public abstract long evaluateLong();

	/**
	 * Evaluate this operator and return result
	 * 
	 * @return int
	 */
	public abstract int evaluateInt();

	/**
	 * Evaluate this operator and return result
	 * 
	 * @return short
	 */
	public abstract short evaluateShort();

	/**
	 * Evaluate this operator and return result
	 * 
	 * @return boolean
	 */
	public abstract boolean evaluateBoolean();

	/**
	 * Evaluate this operator and return result
	 * 
	 * @return String
	 */
	public abstract String evaluateString();

	public ObjectType getType() {
		return header.getType();
	}

	public VMHeader getHeader() {
		return header;
	}
}

package cz.cvut.fit.mirun.lemavm.structures.primitives;

import cz.cvut.fit.mirun.lemavm.structures.ObjectType;

public abstract class VMNumber extends VMPrimitive {

	public VMNumber(ObjectType type) {
		super(type);
	}

	/**
	 * Increment value of this number.
	 */
	public abstract void increment();

	/**
	 * Decrement value of this number.
	 */
	public abstract void decrement();

	/**
	 * Get short value of this number.
	 * 
	 * @return short
	 */
	public abstract short shortValue();

	/**
	 * Get int value of this number.
	 * 
	 * @return int
	 */
	public abstract int intValue();

	/**
	 * Get long value of this number.
	 * 
	 * @return long
	 */
	public abstract long longValue();

	/**
	 * Get double value of this number.
	 * 
	 * @return double
	 */
	public abstract double doubleValue();
}

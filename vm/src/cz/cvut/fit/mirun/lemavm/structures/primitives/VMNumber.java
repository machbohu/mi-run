package cz.cvut.fit.mirun.lemavm.structures.primitives;

import cz.cvut.fit.mirun.lemavm.structures.ObjectType;

public abstract class VMNumber extends VMPrimitive {

	public VMNumber() {
		super(ObjectType.NUMBER);
	}

	/**
	 * Increment value of this number.
	 */
	public abstract void increment();

	/**
	 * Decrement value of this number.
	 */
	public abstract void decrement();
}

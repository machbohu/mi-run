package cz.cvut.fit.mirun.lemavm.structures.primitives;

import cz.cvut.fit.mirun.lemavm.structures.ObjectType;

/**
 * There is only one {@code VMNull} in the VM.
 * 
 * @author kidney
 * 
 */
public final class VMNull extends VMPrimitive {

	private static final String STR_NULL = "null";

	private static final VMNull instance = new VMNull();

	private VMNull() {
		super(ObjectType.NULL);
	}

	public static VMNull getInstance() {
		return instance;
	}

	@Override
	public String printValue() {
		return STR_NULL;
	}

	@Override
	public boolean valueEquals(VMPrimitive other) {
		return equals(other);
	}
}

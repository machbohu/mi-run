package cz.cvut.fit.mirun.lemavm.structures.primitives;

import cz.cvut.fit.mirun.lemavm.structures.ObjectType;

public final class VMString extends VMPrimitive {

	private final String value;

	public VMString(String value) {
		super(ObjectType.STRING);
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		String out = super.toString();
		out += ". Value = " + value;
		return out;
	}

	@Override
	public String printValue() {
		return value;
	}

	@Override
	public boolean valueEquals(VMPrimitive other) {
		if (other instanceof VMString) {
			final String s = ((VMString) other).getValue();
			return value.equals(s);
		} else {
			return false;
		}
	}
}

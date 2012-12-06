package cz.cvut.fit.mirun.lemavm.structures.builtin;

import cz.cvut.fit.mirun.lemavm.core.memory.VMMemoryManager;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;

public class VMString extends VMPrimitive {

	private final String value;

	public VMString(String value) {
		super(ObjectType.STRING);
		this.value = value;
		VMMemoryManager.allocateObject(this);
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

	public VMString charAt(int ind) {
		return new VMString(String.valueOf(value.charAt(ind)));
	}

	public int length() {
		return value.length();
	}

	public boolean contains(VMString str) {
		if (str == null) {
			throw new NullPointerException();
		}
		return value.contains(str.getValue());
	}

	public boolean isEmpty() {
		return value.isEmpty();
	}

	public VMString substring(int beginIndex) {
		return new VMString(value.substring(beginIndex));
	}

	public VMString substring(int beginIndex, int endIndex) {
		return new VMString(value.substring(beginIndex, endIndex));
	}

	public VMString toLowerCase() {
		return new VMString(value.toLowerCase());
	}

	public VMString toUpperCase() {
		return new VMString(value.toUpperCase());
	}

	public VMString concat(VMString... args) {
		final StringBuilder b = new StringBuilder(value);
		for (VMString s : args) {
			b.append(s.value);
		}
		return new VMString(b.toString());
	}
}

package cz.cvut.fit.mirun.lemavm.structures.primitives;

import cz.cvut.fit.mirun.lemavm.core.VMParsingException;

public final class VMInteger extends VMNumber {

	private int value;

	public VMInteger(int value) {
		super();
		this.value = value;
	}

	public VMInteger(String value) {
		super();
		try {
			this.value = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new VMParsingException("Unable to parse VMInteger value "
					+ value);
		}
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		String out = super.toString();
		out += ". Value = " + value;
		return out;
	}

	@Override
	public void increment() {
		value++;
	}

	@Override
	public void decrement() {
		value--;
	}

	@Override
	public short shortValue() {
		return (short) value;
	}

	@Override
	public int intValue() {
		return value;
	}

	@Override
	public long longValue() {
		return (long) value;
	}

	@Override
	public double doubleValue() {
		return (double) value;
	}

	@Override
	public String printValue() {
		return Integer.toString(value);
	}

	@Override
	public boolean valueEquals(VMPrimitive other) {
		if (other instanceof VMNumber) {
			final int d = ((VMNumber) other).intValue();
			return value == d;
		} else if (other instanceof VMBoolean) {
			return ((VMBoolean) other).valueEquals(this);
		} else {
			return false;
		}
	}
}

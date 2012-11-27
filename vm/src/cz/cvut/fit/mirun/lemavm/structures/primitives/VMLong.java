package cz.cvut.fit.mirun.lemavm.structures.primitives;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;

public final class VMLong extends VMNumber {

	private long value;

	public VMLong(long value) {
		super(ObjectType.LONG);
		this.value = value;
	}

	public VMLong(String value) {
		super(ObjectType.LONG);
		try {
			this.value = Long.parseLong(value);
		} catch (NumberFormatException e) {
			throw new VMParsingException("Unable to parse VMLong value "
					+ value);
		}
	}

	public long getValue() {
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
		return (int) value;
	}

	@Override
	public long longValue() {
		return value;
	}

	@Override
	public double doubleValue() {
		return (double) value;
	}

	@Override
	public String printValue() {
		return Long.toString(value);
	}

	@Override
	public boolean valueEquals(VMPrimitive other) {
		if (other instanceof VMNumber) {
			final long d = ((VMNumber) other).longValue();
			return value == d;
		} else if (other instanceof VMBoolean) {
			return ((VMBoolean) other).valueEquals(this);
		} else {
			return false;
		}
	}
}

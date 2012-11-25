package cz.cvut.fit.mirun.lemavm.structures.primitives;

import cz.cvut.fit.mirun.lemavm.core.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;

public final class VMShort extends VMNumber {

	private short value;

	public VMShort(short value) {
		super(ObjectType.SHORT);
		this.value = value;
	}

	public VMShort(int value) {
		super(ObjectType.SHORT);
		this.value = (short) value;
	}

	public VMShort(String value) {
		super(ObjectType.SHORT);
		try {
			this.value = Short.parseShort(value);
		} catch (NumberFormatException e) {
			throw new VMParsingException("Unable to parse VMShort value "
					+ value);
		}
	}

	public short getValue() {
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
		return value;
	}

	@Override
	public int intValue() {
		return (int) value;
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
		return Short.toString(value);
	}

	@Override
	public boolean valueEquals(VMPrimitive other) {
		if (other instanceof VMNumber) {
			final short d = ((VMNumber) other).shortValue();
			return value == d;
		} else if (other instanceof VMBoolean) {
			return ((VMBoolean) other).valueEquals(this);
		} else {
			return false;
		}
	}
}

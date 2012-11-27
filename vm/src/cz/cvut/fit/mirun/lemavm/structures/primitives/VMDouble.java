package cz.cvut.fit.mirun.lemavm.structures.primitives;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;

public final class VMDouble extends VMNumber {

	private double value;

	public VMDouble(double value) {
		super(ObjectType.DOUBLE);
		this.value = value;
	}

	public VMDouble(String value) {
		super(ObjectType.DOUBLE);
		try {
			this.value = Double.parseDouble(value);
		} catch (NumberFormatException e) {
			throw new VMParsingException("Unable to parse VMDouble value "
					+ value);
		}
	}

	public double getValue() {
		return value;
	}

	@Override
	public String toString() {
		String out = super.toString();
		out += ". Value = " + value;
		return out;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Note that using increment operator on double values is generally not a
	 * good idea.
	 */
	@Override
	public void increment() {
		value++;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * Note that using decrement operator on double values is generally not a
	 * good idea.
	 */
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
		return (long) value;
	}

	@Override
	public double doubleValue() {
		return value;
	}

	@Override
	public String printValue() {
		return Double.toString(value);
	}

	@Override
	public boolean valueEquals(VMPrimitive other) {
		if (other instanceof VMNumber) {
			final double d = ((VMNumber) other).doubleValue();
			return value == d;
		} else if (other instanceof VMBoolean) {
			return ((VMBoolean) other).valueEquals(this);
		} else {
			return false;
		}
	}
}

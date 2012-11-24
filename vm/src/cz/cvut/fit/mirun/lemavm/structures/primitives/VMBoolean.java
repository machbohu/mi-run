package cz.cvut.fit.mirun.lemavm.structures.primitives;

import cz.cvut.fit.mirun.lemavm.core.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;

public final class VMBoolean extends VMPrimitive {

	private static final String STR_TRUE = "true";
	private static final String STR_FALSE = "false";

	public static final VMBoolean TRUE = new VMBoolean(true);
	public static final VMBoolean FALSE = new VMBoolean(false);

	private final boolean value;

	private VMBoolean(boolean value) {
		super(ObjectType.BOOLEAN);
		this.value = value;
	}

	/**
	 * Create new {@code VMBoolean} from the specified string. </p>
	 * 
	 * This is the only way to get the {@code VMBoolean} values, since there can
	 * be only one one true and one false entity in the VM.
	 * 
	 * @param value
	 *            The value to parse
	 * @return VMBoolean
	 * @throws VMParsingException
	 */
	public static VMBoolean valueOf(String value) {
		switch (value) {
		case STR_TRUE:
			return TRUE;
		case STR_FALSE:
			return FALSE;
		default:
			throw new VMParsingException("Unknown VMBoolean value " + value);
		}
	}

	/**
	 * Get the value of this object.
	 * 
	 * @return boolean value
	 */
	public boolean getValue() {
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
		return Boolean.toString(value);
	}

	@Override
	public boolean valueEquals(VMPrimitive other) {
		if (other instanceof VMBoolean) {
			return this.equals(other);
		}
		if (other instanceof VMNumber) {
			// Double is the widest type, so this should work for all other
			// primitives
			final double d = ((VMNumber) other).doubleValue();
			return value == true ? (d != 0) : (d == 0);
		}
		return false;
	}
}

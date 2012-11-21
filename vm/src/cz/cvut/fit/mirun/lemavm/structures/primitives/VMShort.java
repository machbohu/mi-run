package cz.cvut.fit.mirun.lemavm.structures.primitives;

import cz.cvut.fit.mirun.lemavm.core.VMParsingException;

public final class VMShort extends VMNumber {

	private short value;

	public VMShort(short value) {
		super();
		this.value = value;
	}

	public VMShort(String value) {
		super();
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

}

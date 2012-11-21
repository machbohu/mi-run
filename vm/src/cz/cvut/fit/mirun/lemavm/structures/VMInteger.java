package cz.cvut.fit.mirun.lemavm.structures;

import cz.cvut.fit.mirun.lemavm.core.VMParsingException;

public class VMInteger extends VMNumber {

	private final int value;

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
}

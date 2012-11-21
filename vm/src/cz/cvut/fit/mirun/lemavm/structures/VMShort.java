package cz.cvut.fit.mirun.lemavm.structures;

import cz.cvut.fit.mirun.lemavm.core.VMParsingException;

public class VMShort extends VMNumber {

	private final short value;

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
}

package cz.cvut.fit.mirun.lemavm.structures;

import cz.cvut.fit.mirun.lemavm.core.VMParsingException;

public class VMLong extends VMNumber {

	private final long value;

	public VMLong(long value) {
		super();
		this.value = value;
	}

	public VMLong(String value) {
		super();
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
}

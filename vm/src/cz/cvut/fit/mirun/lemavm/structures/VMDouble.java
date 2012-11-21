package cz.cvut.fit.mirun.lemavm.structures;

import cz.cvut.fit.mirun.lemavm.core.VMParsingException;

public class VMDouble extends VMNumber {

	private final double value;

	public VMDouble(double value) {
		super();
		this.value = value;
	}

	public VMDouble(String value) {
		super();
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
}

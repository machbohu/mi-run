package cz.cvut.fit.mirun.lemavm.structures;

public class VMString extends VMPrimitive {

	private final String value;

	public VMString(String value) {
		super(ObjectType.STRING);
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		String out = super.toString();
		out += ". Value = " + value;
		return out;
	}
}

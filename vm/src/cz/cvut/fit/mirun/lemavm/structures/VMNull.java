package cz.cvut.fit.mirun.lemavm.structures;

/**
 * There is only one {@code VMNull} in the VM.
 * 
 * @author kidney
 * 
 */
public class VMNull extends VMPrimitive {

	private static final VMNull instance = new VMNull();

	private VMNull() {
		super(ObjectType.NULL);
	}

	public static VMNull getInstance() {
		return instance;
	}
}

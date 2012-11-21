package cz.cvut.fit.mirun.lemavm.structures;

/**
 * This is the base object from which all definitions in the VM should be
 * derived. It merely declares that all objects have a header and can point to
 * their previous location, which is necessary for correct garbage collection
 * support.
 * 
 * @author kidney
 * 
 */
public abstract class VMObject implements Recognizable, Evaluable {

	private final VMHeader header;

	/** Used by GC to be able to get the previous reference of this object */
	private VMObject oldReference;

	public VMObject(ObjectType type) {
		super();
		assert type != null;
		this.header = new VMHeader();
		header.setType(type);
	}

	@Override
	public final VMHeader getHeader() {
		return header;
	}

	public VMObject getOldReference() {
		return oldReference;
	}

	public void setOldReference(VMObject oldReference) {
		this.oldReference = oldReference;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof VMObject) {
			final VMObject o = (VMObject) other;
			return (header.equals(o.getHeader()));
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hash = 31 * header.hashCode();
		return hash;
	}

	@Override
	public String toString() {
		return header.toString();
	}
}

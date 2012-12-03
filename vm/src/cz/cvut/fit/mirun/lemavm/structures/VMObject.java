package cz.cvut.fit.mirun.lemavm.structures;

/**
 * This is the base object from which all reference types in the VM should be
 * derived. It merely declares that all objects have a header and can point to
 * their previous location, which is necessary for correct garbage collection
 * support.
 * 
 * @author kidney
 * 
 */
public abstract class VMObject implements Recognizable {

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

	/**
	 * Get type of this object. </p>
	 * 
	 * This is a shorthand for calling {@link #getHeader()} and then getting the
	 * type.
	 * 
	 * @return Type of this object
	 */
	public ObjectType getType() {
		return header.getType();
	}

	/**
	 * Get name of the type represented by this {@code VMObject}. </p>
	 * 
	 * Built-in reference types can use this default implementation, class
	 * instances should override it and return their class name.
	 * 
	 * @return Type name
	 */
	public String getTypeName() {
		return header.getType().toString();
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

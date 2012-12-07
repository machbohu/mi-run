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
public abstract class VMObject implements Recognizable, Cloneable {

	private final VMHeader header;

	/**
	 * This is not a general purpose constructor. It should be used only by the
	 * GC.
	 */
	protected VMObject() {
		super();
		this.header = null;
	}

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

	@Override
	public VMObject clone() {
		try {
			return (VMObject) super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Unable to clone object.");
			return null;
		}
	}
}

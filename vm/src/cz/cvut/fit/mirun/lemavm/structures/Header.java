package cz.cvut.fit.mirun.lemavm.structures;

/**
 * This is the header of all objects recognized by the VM.
 * 
 * @author kidney
 * 
 */
public class Header {

	private static long ID_CNT = 0;

	private long id;
	private ObjectType type;
	// Needed by GC
	private byte age;

	public Header() {
		this.id = ++ID_CNT;
	}

	public ObjectType getType() {
		return type;
	}

	public void setType(ObjectType type) {
		this.type = type;
	}

	public byte getAge() {
		return age;
	}

	public void incrementAge() {
		age++;
	}

	public long getId() {
		return id;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Header) {
			final Header h = (Header) other;
			return (id == h.getId());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Long.valueOf(id).hashCode();
	}
}

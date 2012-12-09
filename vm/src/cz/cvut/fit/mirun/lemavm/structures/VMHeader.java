package cz.cvut.fit.mirun.lemavm.structures;

/**
 * This is the header of all objects recognized by the VM.
 * 
 * @author kidney
 * 
 */
public class VMHeader {

	private static long ID_CNT = 0;

	private long id;
	private ObjectType type;
	// Needed by GC
	private byte age;
	private int heapPtr;

	public VMHeader() {
		this.id = ++ID_CNT;
		heapPtr = -1;
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

	public void setAge(byte age) {
		this.age = age;
	}

	public long getId() {
		return id;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof VMHeader) {
			final VMHeader h = (VMHeader) other;
			return (id == h.getId());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Long.valueOf(id).hashCode();
	}

	@Override
	public String toString() {
		String out = "VMHeader: id = " + id + ", type = " + type + ", age = "
				+ age;
		return out;
	}

	public int getHeapPtr() {
		return heapPtr;
	}

	public void setHeapPtr(int heapPtr) {
		this.heapPtr = heapPtr;
	}
}

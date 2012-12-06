package cz.cvut.fit.mirun.lemavm.core.memory;

import cz.cvut.fit.mirun.lemavm.structures.VMObject;

/**
 * This class will take care of the memory management and memory allocation and
 * deallocation.
 * 
 * @author kidney
 * 
 */
public final class VMMemoryManager {

	private static VMMemoryManager manager;
	private static boolean initialized = false;

	private final int spaceSize;
	private final VMGarbageCollector gc;

	protected VMObject[] heapOne;
	protected VMObject[] heapTwo;
	protected int heapPtr;
	protected boolean first;

	// May be used in generational scavenging
	protected VMObject[] oldSpace;
	protected int oldSpacePtr;

	private VMMemoryManager(int heapSize) {
		this.spaceSize = heapSize / 2;
		reallocateSpace(true);
		reallocateSpace(false);
		this.first = true;
		this.heapPtr = 0;
		this.gc = new CopyingGarbageCollector(this);
	}

	void reallocateSpace(boolean first) {
		if (first) {
			heapOne = new VMObject[spaceSize];
		} else {
			heapTwo = new VMObject[spaceSize];
		}
	}

	private void allocateObjectImpl(VMObject object) {
		if (heapPtr + 1 >= spaceSize) {
			gc.runGC();
		}
		if (first) {
			heapOne[heapPtr++] = object;
		} else {
			heapTwo[heapPtr++] = object;
		}
		object.getHeader().setHeapPtr(heapPtr);
	}

	/**
	 * Initialize the memory manager. </p>
	 * 
	 * The specified heap size defines the size of the whole heap, so if a
	 * semi-space GC is used, each space will have half of the heap.
	 * 
	 * @param heapSize
	 *            Size of the heap
	 */
	public static void initializeMemoryManager(int heapSize) {
		if (initialized) {
			throw new IllegalStateException(
					"The memory manager is already initialized.");
		}
		if (heapSize < 2) {
			throw new IllegalArgumentException(
					"Heap size cannot be less than 2");
		}
		manager = new VMMemoryManager(heapSize);
		initialized = true;
	}

	/**
	 * Reset the memory manager.
	 */
	public static void resetMemoryManager() {
		if (manager == null) {
			throw new IllegalStateException("Manager was never initialized.");
		}
		initialized = false;
	}

	/**
	 * Allocate the specified object on the heap. </p>
	 * 
	 * @param object
	 *            The object to allocate
	 */
	public static void allocateObject(VMObject object) {
		if (object == null) {
			throw new NullPointerException();
		}
		if (!initialized) {
			throw new IllegalStateException(
					"The memory manager is not initialized.");
		}
		manager.allocateObjectImpl(object);
	}

	protected VMMemoryManager getInstance() {
		if (!initialized) {
			throw new IllegalStateException(
					"The memory manager is not initialized.");
		}
		return manager;
	}
}

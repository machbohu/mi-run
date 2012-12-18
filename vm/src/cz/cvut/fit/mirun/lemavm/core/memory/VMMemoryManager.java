package cz.cvut.fit.mirun.lemavm.core.memory;

import org.apache.log4j.Logger;

import cz.cvut.fit.mirun.lemavm.core.VMSettings;
import cz.cvut.fit.mirun.lemavm.exceptions.VMOutOfMemoryException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;

/**
 * This class will take care of the memory management and memory allocation and
 * deallocation.
 * 
 * @author kidney
 * 
 */
public final class VMMemoryManager {

	private static final Logger LOG = Logger.getLogger(VMMemoryManager.class);

	private static VMMemoryManager manager;
	private static boolean initialized = false;

	private final int spaceSize;
	private final VMGarbageCollector gc;

	protected VMObject[] heapOne;
	protected VMObject[] heapTwo;
	protected int heapPtr;
	protected WhichSpace which;

	// May be used in generational scavenging
	protected VMObject[] oldSpace;
	protected int oldSpacePtr;

	protected enum WhichSpace {
		FIRST, SECOND, OLD
	}

	private VMMemoryManager(int heapSize) {
		this.spaceSize = heapSize / 2;
		reallocateSpace(WhichSpace.FIRST);
		reallocateSpace(WhichSpace.SECOND);
		this.which = WhichSpace.FIRST;
		this.heapPtr = 0;
		final String gcType = (String) VMSettings.get(VMSettings.GC_TYPE);
		if (LOG.isDebugEnabled()) {
			LOG.debug("Using garbage collector of type " + gcType);
		}
		if (gcType != null
				&& gcType.equalsIgnoreCase(VMConstants.GC_GENERATIONAL)) {
			reallocateSpace(WhichSpace.OLD);
			this.gc = new GenerationalGarbageCollector(this);
		} else {
			this.gc = new CopyingGarbageCollector(this);
		}
	}

	void reallocateSpace(WhichSpace which) {
		switch (which) {
		case FIRST:
			heapOne = new VMObject[spaceSize];
			break;
		case SECOND:
			heapTwo = new VMObject[spaceSize];
			break;
		case OLD:
			oldSpace = new VMObject[spaceSize
					* VMConstants.OLD_SPACE_MULTIPLIER];
			break;
		}
	}

	void flipSpaces() {
		reallocateSpace(which);
		this.which = which.equals(WhichSpace.FIRST) ? WhichSpace.SECOND
				: WhichSpace.FIRST;
	}

	private void allocateObjectImpl(VMObject object) {
		if (heapPtr >= spaceSize) {
			gc.runGC();
			if (heapPtr >= spaceSize) {
				throw new VMOutOfMemoryException();
			}
		}
		object.getHeader().setHeapPtr(heapPtr);
		if (which.equals(WhichSpace.FIRST)) {
			heapOne[heapPtr++] = object;
		} else {
			heapTwo[heapPtr++] = object;
		}
		if (LOG.isTraceEnabled()) {
			LOG.trace("Allocated new object. Free heap space left = "
					+ (spaceSize - heapPtr));
		}
	}

	private void addEntryToRememberedSet(VMEnvironment env, String name,
			VMObject value) {
		if (gc == null) {
			// We are not running generational scavenging
			return;
		}
		((GenerationalGarbageCollector) gc).addEntryToRememberedSet(env, name,
				value);
	}

	/**
	 * Initialize the memory manager. </p>
	 * 
	 * The specified heap size defines the size of the whole heap, so if a
	 * semi-space GC is used, each space will have half of the heap.
	 * 
	 */
	public static void initializeMemoryManager() {
		if (initialized) {
			throw new IllegalStateException(
					"The memory manager is already initialized.");
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("Initializing memory manager.");
		}
		final Integer heapSize = (Integer) VMSettings.get(VMSettings.HEAP_SIZE);
		if (heapSize == null) {
			throw new VMParsingException("Heap size not specified.");
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
			LOG.warn("The memory manager has not been initialized. Initializing with default heap size.");
			initializeMemoryManager();
		}
		manager.allocateObjectImpl(object);
	}

	public static void tryAddingToRememberedSet(VMEnvironment env, String name,
			VMObject value) {
		if (env == null || value == null) {
			throw new NullPointerException();
		}
		if (!initialized) {
			throw new IllegalStateException(
					"Memory manager is not initialized.");
		}
		manager.addEntryToRememberedSet(env, name, value);
	}

	protected static VMMemoryManager getInstance() {
		if (!initialized) {
			LOG.warn("The memory manager has not been initialized. Initializing with default heap size.");
			initializeMemoryManager();
		}
		return manager;
	}
}

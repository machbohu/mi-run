package cz.cvut.fit.mirun.lemavm.core.memory;

/**
 * Base class for garbage collectors. </p>
 * 
 * We will start with a simple copying garbage collector and may work our way to
 * generational scavenging.
 * 
 * @author kidney
 * 
 */
abstract class VMGarbageCollector {

	protected VMMemoryManager manager;

	protected VMGarbageCollector(VMMemoryManager manager) {
		if (manager == null) {
			throw new NullPointerException();
		}
		this.manager = manager;
	}

	/**
	 * Run the garbage collection.
	 */
	protected abstract void runGC();
}

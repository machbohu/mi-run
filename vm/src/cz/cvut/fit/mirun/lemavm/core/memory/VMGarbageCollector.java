package cz.cvut.fit.mirun.lemavm.core.memory;

import org.apache.log4j.Logger;

import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;

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

	protected static final Logger LOG = Logger
			.getLogger(VMGarbageCollector.class);

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

	protected static class ForwardPointer extends VMObject {

		private static final ObjectType TYPE = ObjectType.FORWARD_POINTER;

		private final int pointer;

		private final boolean tenured;

		public ForwardPointer(int pointer, boolean tenured) {
			super();
			this.pointer = pointer;
			this.tenured = tenured;
		}

		@Override
		public ObjectType getType() {
			return TYPE;
		}

		public int getPointer() {
			return pointer;
		}

		/**
		 * Returns true if the object was moved to the old space.
		 * 
		 * @return
		 */
		public boolean isTenured() {
			return tenured;
		}
	}
}

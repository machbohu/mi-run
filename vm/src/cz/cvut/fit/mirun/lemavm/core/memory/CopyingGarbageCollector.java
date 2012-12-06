package cz.cvut.fit.mirun.lemavm.core.memory;

import cz.cvut.fit.mirun.lemavm.structures.VMObject;

final class CopyingGarbageCollector extends VMGarbageCollector {

	CopyingGarbageCollector(VMMemoryManager manager) {
		super(manager);
	}

	@Override
	protected void runGC() {
		final VMObject[] from;
		final VMObject[] to;
		if (manager.first) {
			from = manager.heapOne;
			to = manager.heapTwo;
		} else {
			from = manager.heapTwo;
			to = manager.heapOne;
		}
		// TODO
	}

}

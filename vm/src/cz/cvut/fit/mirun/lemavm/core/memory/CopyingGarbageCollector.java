package cz.cvut.fit.mirun.lemavm.core.memory;

final class CopyingGarbageCollector extends VMGarbageCollector {

	CopyingGarbageCollector(VMMemoryManager manager) {
		super(manager);
	}

	@Override
	protected void runGC() {
		// TODO Auto-generated method stub

	}

}

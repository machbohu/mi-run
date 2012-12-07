package cz.cvut.fit.mirun.lemavm.core.memory;

import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import cz.cvut.fit.mirun.lemavm.core.VMInterpreter;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMArray;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMClassInstance;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.VMUtils;

public final class GenerationalGarbageCollector extends VMGarbageCollector {

	// TODO

	private VMObject[] fromSpace;
	private VMObject[] toSpace;
	private VMObject[] oldSpace;
	private int freeInd;

	private int oldFreeInd;

	private Set<Entry<String, VMObject>> rememberedSet;

	private byte ageThreshold;

	public GenerationalGarbageCollector(VMMemoryManager manager) {
		super(manager);
		rememberedSet = new HashSet<>();
	}

	@Override
	protected void runGC() {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Running garbage collection.");
		}
		boolean first = manager.first;
		if (first) {
			this.fromSpace = manager.heapOne;
			this.toSpace = manager.heapTwo;
		} else {
			this.fromSpace = manager.heapTwo;
			this.toSpace = manager.heapOne;
		}
		this.oldSpace = manager.oldSpace;
		final Set<Entry<String, VMObject>> rootSet = resolveRootSet();
		moveRootsToNewSpace(rootSet);
		int scanInd = 0;
		while (scanInd < freeInd) {
			scanObject(toSpace[scanInd]);
			scanInd++;
		}
		scanInd = manager.oldSpacePtr;
		while (scanInd < oldFreeInd) {
			scanObject(oldSpace[scanInd]);
			scanInd++;
		}
		// Flip the spaces
		manager.reallocateSpace(first);
		manager.first = !first;
		manager.heapPtr = freeInd;
		cleanUp();
		if (LOG.isDebugEnabled()) {
			LOG.debug("Garbage collection finished. Objects survived: "
					+ freeInd);
		}
	}

	private void cleanUp() {
		freeInd = 0;
		this.fromSpace = null;
		this.toSpace = null;
	}

	private Set<Entry<String, VMObject>> resolveRootSet() {
		final List<VMEnvironment> envs = VMInterpreter.getInstance()
				.getEnvironments();
		final Set<Entry<String, VMObject>> roots = new HashSet<>();
		for (VMEnvironment e : envs) {
			roots.addAll(e.getBindings().entrySet());
		}
		roots.addAll(rememberedSet);
		return roots;
	}

	private void moveRootsToNewSpace(Set<Entry<String, VMObject>> rootSet) {
		for (Entry<String, VMObject> o : rootSet) {
			VMObject moved = moveObject(o.getValue());
			if (moved != null) {
				o.setValue(moved);
			}
		}
	}

	private void scanObject(VMObject object) {
		if (LOG.isTraceEnabled()) {
			LOG.trace("Scanning object " + object.getHeader().getId());
		}
		if (object.getType().equals(ObjectType.STRING)
				|| object.getType().equals(ObjectType.FILE)) {
			// Strings and files don't contain any references
			return;
		}
		if (object.getType().equals(ObjectType.ARRAY)) {
			// The object is an array, check for element types
			final VMArray arr = (VMArray) object;
			if (!VMUtils.isTypePrimitive(arr.getElementTypeName())) {
				final VMObject[] elems = (VMObject[]) arr.getAll();
				for (int i = 0; i < elems.length; i++) {
					VMObject moved = moveObject(elems[i]);
					if (moved != null) {
						elems[i] = moved;
					}
				}
			}
			// Otherwise do nothing, primitives are stored in the array and
			// those are not allocated on our heap
		} else {
			// Look for reference type field values
			VMClassInstance inst = (VMClassInstance) object;
			final Set<Entry<String, VMObject>> refs = inst.getEnvironment()
					.getBindings().entrySet();
			for (Entry<String, VMObject> o : refs) {
				VMObject moved = moveObject(o.getValue());
				if (moved != null) {
					o.setValue(moved);
				}
			}
		}
	}

	private VMObject moveObject(VMObject object) {
		if (object.getType().equals(ObjectType.NULL)) {
			// Null does not have to be moved, it cannot be collected
			return null;
		}
		int oldPtr = object.getHeader().getHeapPtr();
		if (fromSpace[oldPtr] == null
				|| fromSpace[oldPtr].getType().equals(
						ObjectType.FORWARD_POINTER)) {
			// The object has already been moved
			final ForwardPointer ptr = (ForwardPointer) fromSpace[oldPtr];
			return ptr.isTenured() ? oldSpace[ptr.getPointer()] : toSpace[ptr
					.getPointer()];
		}
		// Move the reference
		final VMObject clone = object.clone();
		boolean tenured = clone.getHeader().getAge() > ageThreshold;
		if (tenured) {
			oldSpace[oldFreeInd] = clone;
			// set forward pointer
			fromSpace[object.getHeader().getHeapPtr()] = new ForwardPointer(
					oldFreeInd, tenured);
			object.getHeader().setHeapPtr(oldFreeInd);
			oldFreeInd++;
		} else {
			toSpace[freeInd] = clone;
			// set forward pointer
			fromSpace[object.getHeader().getHeapPtr()] = new ForwardPointer(
					freeInd, tenured);
			object.getHeader().setHeapPtr(freeInd);
			freeInd++;
		}
		return clone;
	}
}
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

final class CopyingGarbageCollector extends VMGarbageCollector {

	CopyingGarbageCollector(VMMemoryManager manager) {
		super(manager);
	}

	@Override
	protected void runGC() {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Running garbage collection.");
		}
		final VMObject[] from;
		final VMObject[] to;
		boolean first = manager.first;
		if (first) {
			from = manager.heapOne;
			to = manager.heapTwo;
		} else {
			from = manager.heapTwo;
			to = manager.heapOne;
		}
		final Set<Entry<String, VMObject>> rootSet = resolveRootSet();
		int freeInd = moveRootsToNewSpace(rootSet, from, to);
		int scanInd = 0;
		while (scanInd < freeInd) {
			freeInd = scanObject(to[scanInd], from, to, freeInd);
			scanInd++;
		}
		// Flip the spaces
		manager.reallocateSpace(first);
		manager.first = !first;
		manager.heapPtr = freeInd;
		if (LOG.isDebugEnabled()) {
			LOG.debug("Garbage collection finished. Objects survived: "
					+ freeInd);
		}
	}

	/**
	 * Get root set by extracting all bound VMObjects from all existing
	 * environments.
	 * 
	 * @return Root nodes set
	 */
	private Set<Entry<String, VMObject>> resolveRootSet() {
		final List<VMEnvironment> envs = VMInterpreter.getInstance()
				.getEnvironments();
		final Set<Entry<String, VMObject>> roots = new HashSet<>();
		for (VMEnvironment e : envs) {
			roots.addAll(e.getBindings().entrySet());
		}
		return roots;
	}

	private int moveRootsToNewSpace(Set<Entry<String, VMObject>> rootSet,
			VMObject[] fromSpace, VMObject[] toSpace) {
		int i = 0;
		for (Entry<String, VMObject> o : rootSet) {
			VMObject moved = moveObject(o.getValue(), fromSpace, toSpace, i);
			if (moved != null) {
				o.setValue(moved);
				i++;
			}
		}
		return i;
	}

	private int scanObject(VMObject object, VMObject[] fromSpace,
			VMObject[] toSpace, int freeInd) {
		if (LOG.isTraceEnabled()) {
			LOG.trace("Scanning object " + object.getHeader().getId());
		}
		if (object.getType().equals(ObjectType.STRING)
				|| object.getType().equals(ObjectType.FILE)) {
			// Strings and files don't contain any references
			return freeInd;
		}
		if (object.getType().equals(ObjectType.ARRAY)) {
			// The object is an array, check for element types
			final VMArray arr = (VMArray) object;
			if (!VMUtils.isTypePrimitive(arr.getElementTypeName())) {
				final VMObject[] elems = (VMObject[]) arr.getAll();
				for (int i = 0; i < elems.length; i++) {
					VMObject moved = moveObject(elems[i], fromSpace, toSpace,
							freeInd);
					if (moved != null) {
						elems[i] = moved;
						freeInd++;
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
				VMObject moved = moveObject(o.getValue(), fromSpace, toSpace,
						freeInd);
				if (moved != null) {
					o.setValue(moved);
					freeInd++;
				}
			}
		}
		return freeInd;
	}

	/**
	 * Move the object from {@code fromSpace} to {@code toSpace} and set a
	 * forward pointer at its original place in {@code fromSpace}.
	 * 
	 * @param object
	 *            The object to move
	 * @param fromSpace
	 *            From space
	 * @param toSpace
	 *            To space
	 * @param freeInd
	 *            Index of the first free slot in toSpace
	 * @return The new first free slot index in toSpace
	 */
	private VMObject moveObject(VMObject object, VMObject[] fromSpace,
			VMObject[] toSpace, int freeInd) {
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
			return toSpace[ptr.getPointer()];
		}
		// Move the reference
		final VMObject clone = object.clone();
		toSpace[freeInd] = clone;
		// set forward pointer
		fromSpace[object.getHeader().getHeapPtr()] = new ForwardPointer(freeInd);
		object.getHeader().setHeapPtr(freeInd);
		return clone;
	}
}

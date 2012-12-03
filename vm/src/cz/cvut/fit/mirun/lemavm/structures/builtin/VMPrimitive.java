package cz.cvut.fit.mirun.lemavm.structures.builtin;

import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.Printable;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;

/**
 * VMPrimitives represent primitive values in the VM - numbers, strings,
 * booleans and null. </p>
 * 
 * Boolean values and null are implemented as singletons, since there can always
 * be only one instance of them (two in case of boolean). </p>
 * 
 * Numbers and Strings should be cached by the VM, so that there is always only
 * one instance for each value. The reason the cache is not implemented by the
 * classes themselves is to enable garbage collection in case no binding to
 * these values exists any more.
 * 
 * @author kidney
 * 
 */
public abstract class VMPrimitive extends VMObject implements Printable {

	public VMPrimitive(ObjectType type) {
		super(type);
	}

	/**
	 * Compare values of primitives. </p>
	 * 
	 * This method, in contrast to the {@code equals} method compares values of
	 * object.
	 * 
	 * @param other
	 *            The object to compare this object to
	 * @return true if the values are equal, false otherwise
	 */
	public abstract boolean valueEquals(VMPrimitive other);
}

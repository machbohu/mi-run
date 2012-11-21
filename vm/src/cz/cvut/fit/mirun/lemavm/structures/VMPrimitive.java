package cz.cvut.fit.mirun.lemavm.structures;

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
public abstract class VMPrimitive extends VMObject {

	public VMPrimitive(ObjectType type) {
		super(type);
	}

	@Override
	public VMObject evaluate() {
		return this;
	}
}

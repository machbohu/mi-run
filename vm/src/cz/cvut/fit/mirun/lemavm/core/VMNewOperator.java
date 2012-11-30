package cz.cvut.fit.mirun.lemavm.core;

import java.util.List;

import org.apache.log4j.Logger;

import cz.cvut.fit.mirun.lemavm.exceptions.VMClassNotFoundException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMClass;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMMethod;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

/**
 * This class is the new operator which is used to create instances of
 * non-primitive types.
 * 
 * @author kidney
 * 
 */
public final class VMNewOperator {

	private static final Logger LOG = Logger.getLogger(VMNewOperator.class);

	private final String typeName;
	private final List<Object> args;

	/**
	 * Constructor of the new operator. </p>
	 * 
	 * The arguments will be passed to the type constructor in the same order
	 * they are in the list. NOTE: If there are not arguments to pass, give this
	 * method an empty list, do not use null.
	 * 
	 * @param typeName
	 * @param args
	 */
	private VMNewOperator(String typeName, List<Object> args) {
		super();
		if (typeName == null || args == null) {
			throw new NullPointerException();
		}
		this.typeName = typeName;
		this.args = args;
	}

	/**
	 * Create new instance of the specified type with the specified arguments.
	 * </p>
	 * 
	 * @param typeName
	 *            Name of the type to instantiate
	 * @param args
	 *            Arguments to pass to the constructor
	 * @return New object
	 */
	public VMObject evaluate() {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Creating instance of type " + typeName);
			if (LOG.isTraceEnabled()) {
				LOG.trace("Arguments: " + args);
			}
		}
		if (!VMEnvironment.getKnownTypes().contains(typeName)) {
			throw new VMClassNotFoundException("Type " + typeName
					+ " not found.");
		}
		VMObject newInstance = checkForBuiltInTypes();
		if (newInstance != null) {
			return newInstance;
		}
		final VMClass cls = VMClass.getClasses().get(typeName);
		assert cls != null;
		// TODO Create the instance
		// Call the invokeConstructor
		VMMemoryManager.allocateObject(newInstance);
		return null;
	}

	private VMObject checkForBuiltInTypes() {
		VMObject instance = null;
		switch (typeName) {
		case VMConstants.SHORT:
		case VMConstants.INT:
		case VMConstants.LONG:
		case VMConstants.DOUBLE:
		case VMConstants.BOOLEAN:
			throw new VMEvaluationException(
					"Cannot use the new operator with primitive type "
							+ typeName);
		case VMConstants.STRING:
			if (args.size() < 1) {
				instance = new VMString("");
			} else {
				instance = new VMString(args.get(0).toString());
			}
			break;
		// TODO arrays
		default:
			break;
		}
		return instance;
	}
}

package cz.cvut.fit.mirun.lemavm.structures.operators;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import cz.cvut.fit.mirun.lemavm.core.VMInterpreter;
import cz.cvut.fit.mirun.lemavm.core.memory.VMMemoryManager;
import cz.cvut.fit.mirun.lemavm.exceptions.VMClassNotFoundException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMMethodNotFoundException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMUnknownTypeException;
import cz.cvut.fit.mirun.lemavm.structures.Evaluable;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMArray;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMFile;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMNull;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMClass;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMClassInstance;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;
import cz.cvut.fit.mirun.lemavm.utils.VMUtils;

/**
 * This class is the new operator which is used to create instances of
 * non-primitive types.
 * 
 * @author kidney
 * 
 */
public final class VMNewOperator implements Evaluable {

	private static final Logger LOG = Logger.getLogger(VMNewOperator.class);

	private final String typeName;
	private final List<Object> args;
	private final Object arrayLength;

	/**
	 * Constructor of the new operator. </p>
	 * 
	 * The arguments will be passed to the type constructor in the same order
	 * they are in the list. NOTE: If there are no arguments to pass, give this
	 * method an empty list, do not use null.
	 * 
	 * @param typeName
	 *            Name of the type to instantiate
	 * @param args
	 *            Arguments to pass to the type constructor
	 */
	public VMNewOperator(String typeName, List<Object> args) {
		super();
		if (typeName == null || args == null) {
			throw new NullPointerException();
		}
		this.typeName = typeName;
		this.args = args;
		this.arrayLength = null;
	}

	/**
	 * Constructor of the new operator. </p>
	 * 
	 * This constructor is meant to create new operator for array creation. The
	 * arrayLength parameter can be either an integral type or an integral
	 * variable name. </p>
	 * 
	 * NOTE: Do NOT use this method to create a new operator with a constructor
	 * call with one argument. Use {@link #VMNewOperator(String, List)}.
	 * 
	 * @param typeName
	 *            Name of the type to create an array of
	 * @param arrayLength
	 *            Length of the array
	 */
	public VMNewOperator(String typeName, Object arrayLength) {
		super();
		if (typeName == null || arrayLength == null) {
			throw new NullPointerException();
		}
		this.typeName = typeName;
		this.arrayLength = arrayLength;
		this.args = null;
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
	@Override
	public VMObject evaluate(VMEnvironment env) {
		if (!VMEnvironment.getKnownTypes().contains(typeName)) {
			throw new VMClassNotFoundException("Type " + typeName
					+ " not found.");
		}
		if (arrayLength != null) {
			return createArray(env);
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("Creating instance of type " + typeName);
			if (LOG.isTraceEnabled()) {
				LOG.trace("Arguments: " + args);
			}
		}
		VMObject newInstance = checkForBuiltInTypes(env);
		if (newInstance != null) {
			return newInstance;
		}
		final VMClass cls = VMClass.getClasses().get(typeName);
		assert cls != null;
		newInstance = cls.createInstance();
		VMInterpreter.getInstance().invokeConstructor(
				(VMClassInstance) newInstance, args);
		VMMemoryManager.allocateObject(newInstance);
		return newInstance;
	}

	private VMObject checkForBuiltInTypes(VMEnvironment env) {
		VMObject instance = null;
		if (VMUtils.isTypePrimitive(typeName)) {
			throw new VMEvaluationException(
					"Cannot use the new operator with primitive type "
							+ typeName);
		}
		if (typeName.equals(VMConstants.STRING)) {
			if (args.size() < 1) {
				instance = new VMString("");
			} else {
				instance = new VMString(args.get(0).toString());
			}
		}
		if (typeName.equals(ObjectType.FILE.toString())) {
			if (args.size() < 1) {
				throw new VMMethodNotFoundException(
						"No-arg constructor not found in type File.");
			} else {
				instance = new VMFile(args.get(0), env);
			}
		}
		return instance;
	}

	private VMObject createArray(VMEnvironment env) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Creating array of type " + typeName);
		}
		final int size = VMArrayAccessOperator.resolveArrayIndex(arrayLength,
				env);

		if (VMUtils.isTypePrimitive(typeName)) {
			switch (typeName) {
			case VMConstants.BOOLEAN:
				return new VMArray(new Boolean[size], VMConstants.BOOLEAN);
			case VMConstants.SHORT:
				return new VMArray(new Short[size], VMConstants.SHORT);
			case VMConstants.INT:
				return new VMArray(new Integer[size], VMConstants.INT);
			case VMConstants.LONG:
				return new VMArray(new Long[size], VMConstants.LONG);
			case VMConstants.DOUBLE:
				return new VMArray(new Double[size], VMConstants.DOUBLE);
			default:
				throw new VMUnknownTypeException("Unknown type " + typeName);
			}
		} else {
			VMObject[] arr = new VMObject[size];
			VMNull n = VMNull.getInstance();
			// Init the array with nulls
			Arrays.fill(arr, n);
			return new VMArray(new VMClassInstance[size], typeName);
		}
	}
}

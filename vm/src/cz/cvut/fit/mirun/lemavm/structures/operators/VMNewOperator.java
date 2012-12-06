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
		VMObject newInstance = checkForBuiltInTypes();
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

	private VMObject checkForBuiltInTypes() {
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
			if (args.size() < 1 || !(args.get(0) instanceof VMString)) {
				throw new VMMethodNotFoundException(
						"No-arg constructor not found in type File.");
			} else {
				instance = new VMFile((VMString) args.get(0));
			}
		}
		return instance;
	}

	private VMObject createArray(VMEnvironment env) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Creating array of type " + typeName);
		}
//		Long arrSize = null;
//		VMArrayAccessOperator.resolveArrayIndex(arrayLength, env);
//		
//		if (arrayLength instanceof Number) {
//			arrSize = ((Number) arrayLength).longValue();
//		} else {
//			if (!(arrayLength instanceof String)) {
//				throw new VMEvaluationException("Cannot use instance of type "
//						+ arrayLength.getClass() + " in array initialization.");
//			}
//			try {
//				Number n = env.getBinding((String) arrayLength, Number.class);
//				if (n == null) {
//					throw new VMEvaluationException("No binding with name "
//							+ arrayLength + " found.");
//				}
//				arrSize = n.longValue();
//			} catch (ClassCastException e) {
//				throw new VMEvaluationException(
//						"Incompatible types found. Expected an integer number, but got "
//								+ env.getNameType((String) arrayLength));
//			}
//		}
		final int size = VMArrayAccessOperator.resolveArrayIndex(arrayLength, env);
		
		if (VMUtils.isTypePrimitive(typeName)) {
			switch (typeName) {
			case VMConstants.BOOLEAN:
				return new VMArray<Boolean>(new Boolean[size],
						VMConstants.BOOLEAN);
			case VMConstants.SHORT:
				return new VMArray<Short>(new Short[size], VMConstants.SHORT);
			case VMConstants.INT:
				return new VMArray<Integer>(new Integer[size], VMConstants.INT);
			case VMConstants.LONG:
				return new VMArray<Long>(new Long[size], VMConstants.LONG);
			case VMConstants.DOUBLE:
				return new VMArray<Double>(new Double[size], VMConstants.DOUBLE);
			default:
				throw new VMUnknownTypeException("Unknown type " + typeName);
			}
		} else {
			VMClassInstance[] arr = new VMClassInstance[size];
			VMNull n = VMNull.getInstance();
			// Init the array with nulls
			Arrays.fill(arr, n);
			return new VMArray<VMClassInstance>(new VMClassInstance[size],
					typeName);
		}
	}
}

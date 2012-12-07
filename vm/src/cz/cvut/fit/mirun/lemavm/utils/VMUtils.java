package cz.cvut.fit.mirun.lemavm.utils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMUnknownTypeException;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMArray;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMFile;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMNull;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMClass;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMClassInstance;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMMethod;

public class VMUtils {
	private VMUtils() {
	}

	public static Object getTypeDefaultValue(String type) {
		switch (type) {
		case "short":
			return 0;
		case "int":
			return 0;
		case "long":
			return 0L;
		case "double":
			return 0.0d;
		case "boolean":
			return false;
		default: // including string
			return VMNull.getInstance();
		}
	}

	public static Object getTypeProperValue(String type, String value)
			throws NumberFormatException, ParseException {
		switch (type) {
		case "short":
			return Short.parseShort(value);
		case "int":
			return Integer.parseInt(value);
		case "long":
			return Long.parseLong(value);
		case "double":
			return Double.parseDouble(value);
		case "boolean":
			return Boolean.parseBoolean(value);
		case "string":
			if (value.equals(VMConstants.NULL)) {
				return VMNull.getInstance();
			}
			if (value.startsWith("\"") && value.endsWith("\"")) {
				return new VMString(value.substring(1, value.length() - 1));
			} else {
				throw new ParseException("", 0);
			}
		default:
			if (value.equals(VMConstants.NULL)) {
				return VMNull.getInstance();
			} else {
				throw new ParseException("", 0);
			}
		}
	}

	/**
	 * Decide types of the specified arguments and return a list of these type
	 * names. </p>
	 * 
	 * @param arguments
	 *            List of arguments
	 * @param env
	 * @return
	 */
	public static List<String> getArgumentTypes(List<Object> arguments,
			VMEnvironment env) {
		final List<String> types = new ArrayList<String>(arguments.size());
		for (Object arg : arguments) {
			if (arg instanceof String) {
				types.add(env.getNameType((String) arg));
			} else if (arg instanceof Number) {
				if (arg instanceof Double) {
					types.add(VMConstants.DOUBLE);
				} else if (arg instanceof Long) {
					types.add(VMConstants.LONG);
				} else if (arg instanceof Integer) {
					types.add(VMConstants.INT);
				} else {
					types.add(VMConstants.SHORT);
				}
			} else if (arg instanceof Boolean) {
				types.add(VMConstants.BOOLEAN);
			} else {
				VMObject o = (VMObject) arg;
				types.add(o.getTypeName());
			}
		}
		return types;
	}

	public static boolean isTypePrimitive(String type) {
		switch (type) {
		case VMConstants.BOOLEAN:
		case VMConstants.SHORT:
		case VMConstants.INT:
		case VMConstants.LONG:
		case VMConstants.DOUBLE:
			return true;
		default:
			return false;
		}
	}

	public static boolean isBuiltInType(VMObject instance) {
		if (instance.getType().equals(ObjectType.STRING)) {
			return true;
		}
		if (instance.getType().equals(ObjectType.FILE)) {
			return true;
		}
		if (instance.getType().equals(ObjectType.ARRAY)) {
			return true;
		}
		// Can add more built in types here
		return false;
	}

	/**
	 * Find the main method for the executed application.
	 * 
	 * @return Main method or null
	 */
	public static VMMethod getMainMethod() {
		final Collection<VMClass> classes = VMClass.getClasses().values();
		for (VMClass cls : classes) {
			final List<VMMethod> mains = cls
					.getStaticMethodsForName(VMConstants.MAIN_METHOD);
			if (mains.isEmpty()) {
				continue;
			}
			for (VMMethod m : mains) {
				if (m.getArgumentCount() != 1) {
					break;
				}
				final Entry<String, String> param = m.getArguments().entrySet()
						.iterator().next();
				if (param.getValue().equals(VMConstants.STRING_ARR)) {
					return m;
				}
			}
		}
		return null;
	}

	/**
	 * Check if the specified value is compatible with the specified declared
	 * type. </p>
	 * 
	 * This methods internally calls
	 * {@link #isPrimitiveTypeCompatible(String, Object)} or
	 * {@link #isReferenceTypeCompatible(String, Object)} according to whether
	 * the declared type is primitive or not.
	 * 
	 * @param declType
	 *            Declared type
	 * @param value
	 *            The value to check
	 * @return True if the types are compatible
	 */
	public static boolean isTypeCompatible(String declType, Object value) {
		if (isTypePrimitive(declType)) {
			return isPrimitiveTypeCompatible(declType, value);
		} else {
			return isReferenceTypeCompatible(declType, value);
		}
	}

	/**
	 * Check if the specified value is or can be converted to the specified
	 * declared type. </p>
	 * 
	 * @param declType
	 *            Declared type
	 * @param value
	 *            Value to check
	 * @return True if the value and type are compatible, false otherwise
	 */
	public static boolean isPrimitiveTypeCompatible(String declType,
			Object value) {
		if (declType.equals(VMConstants.BOOLEAN)) {
			if (value instanceof Boolean) {
				return true;
			} else {
				return false;
			}
		}
		if (!(value instanceof Number)) {
			return false;
		}
		final Number n = (Number) value;
		switch (declType) {
		case VMConstants.SHORT:
			Short s = n.shortValue();
			return n.equals(s);
		case VMConstants.INT:
			return ((n instanceof Integer) || (n instanceof Short));
		case VMConstants.LONG:
			return ((n instanceof Integer) || (n instanceof Short) || (n instanceof Long));
		default:
			// Double
			return true;
		}
	}

	/**
	 * Check if the specified value can be stored in the variable of the
	 * declared type. </p>
	 * 
	 * I. e. that the declared type is either the same class or a superclass of
	 * the specified instance.
	 * 
	 * @param declType
	 *            Declared type
	 * @param value
	 *            Value
	 * @return True if the types are compatible
	 */
	public static boolean isReferenceTypeCompatible(String declType,
			Object value) {
		if (value instanceof VMNull) {
			return true;
		}
		if (declType.equals(VMConstants.STRING)) {
			return (value instanceof VMString);
		}
		if (declType.equals(VMConstants.FILE)) {
			return (value instanceof VMFile);
		}
		if (value instanceof VMArray) {
			return checkArrayCompatibility(declType, (VMArray) value);
		}
		if (!(value instanceof VMClassInstance)) {
			return false;
		}
		VMClassInstance inst = (VMClassInstance) value;
		return checkClassTypeCompatibility(declType, inst.getVMClass());
	}

	private static boolean checkArrayCompatibility(String declType, VMArray arr) {
		String runtimeType = arr.getElementTypeName();
		String elemType = declType.substring(0, declType.indexOf("["));
		elemType = elemType.trim();
		if (VMUtils.isTypePrimitive(elemType)) {
			if (!elemType.equals(runtimeType)) {
				throw new VMEvaluationException(
						"Incompatible types in array assignment. Expected "
								+ elemType + ", but got " + runtimeType);
			}
			return true;
		} else {
			return checkClassTypeCompatibility(elemType, VMClass.getClasses()
					.get(runtimeType));
		}
	}

	private static boolean checkClassTypeCompatibility(String declType,
			VMClass runtime) {
		if (runtime == null) {
			throw new VMUnknownTypeException();
		}
		VMClass decl = VMClass.getClasses().get(declType);
		if (decl == null) {
			throw new VMUnknownTypeException(declType);
		}
		if (!decl.isAssignableFrom(runtime)) {
			throw new VMEvaluationException(
					"Incompatible types in assigment. Expected " + declType
							+ ", but got " + runtime.getName());
		}
		return true;
	}

	/**
	 * Check if the two specified types are compatible. </p>
	 * 
	 * The compatibility check includes widening conversion for primitive
	 * numbers and class inheritance for reference types.
	 * 
	 * @param declType
	 *            Declared type
	 * @param runtimeType
	 *            Runtime type
	 * @return True if the types are compatible (runtime type can be cast to
	 *         declared type without precision loss)
	 */
	public static boolean areTypesCompatible(String declType, String runtimeType) {
		if (isTypePrimitive(declType)) {
			switch (declType) {
			case VMConstants.BOOLEAN:
				return runtimeType.equals(VMConstants.BOOLEAN);
			case VMConstants.SHORT:
				return runtimeType.equals(VMConstants.SHORT);
			case VMConstants.INT:
				return (runtimeType.equals(VMConstants.INT) || runtimeType
						.equals(VMConstants.SHORT));
			case VMConstants.LONG:
				return (runtimeType.equals(VMConstants.LONG)
						|| runtimeType.equals(VMConstants.INT) || runtimeType
							.equals(VMConstants.SHORT));
			default:
				return true;
			}
		} else {
			// Built in types are handled separately
			final VMClass declCls = VMClass.getClasses().get(declType);
			final VMClass runtimeCls = VMClass.getClasses().get(runtimeType);
			if (declCls != null || runtimeCls != null) {
				return declCls.isAssignableFrom(runtimeCls);
			} else if (declCls == null && runtimeCls == null) {
				return declType.equals(runtimeType);
			} else {
				throw new VMUnknownTypeException("One of the types " + declType
						+ ", " + runtimeType + " wasn't found.");
			}
		}
	}
}

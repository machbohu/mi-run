package cz.cvut.fit.mirun.lemavm.utils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMNull;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

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
			if(value.equals(VMConstants.NULL)){
				return VMNull.getInstance();
			}
			if (value.startsWith("\"") && value.endsWith("\"")) {
				return new VMString(value.substring(1, value.length() - 1));
			} else {
				throw new ParseException("", 0);
			}
		default:
			if(value.equals(VMConstants.NULL)){
				return VMNull.getInstance();
			}else{
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
		// Can add more built in types here
		return false;
	}
}

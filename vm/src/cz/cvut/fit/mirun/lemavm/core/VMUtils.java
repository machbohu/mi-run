package cz.cvut.fit.mirun.lemavm.core;

import java.text.ParseException;

import cz.cvut.fit.mirun.lemavm.structures.primitives.VMNull;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

public class VMUtils {
	private VMUtils(){}
	
	public static Object getTypeDefaultValue(String type){
		switch(type){
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
	
	public static Object getTypeProperValue(String type, String value) throws NumberFormatException, ParseException{
		switch(type){
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
			if(value.startsWith("\"") && value.endsWith("\"")){
				return new VMString(value.substring(1, value.length()-1));
			}else{
				throw new ParseException("", 0);
			}
		default:
			return VMNull.getInstance();
		}
	}
}

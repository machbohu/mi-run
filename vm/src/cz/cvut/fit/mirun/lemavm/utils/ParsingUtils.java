package cz.cvut.fit.mirun.lemavm.utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public abstract class ParsingUtils {

	private static final String TRUE = "true";
	private static final String FALSE = "false";

	private static final NumberFormat numberParser = NumberFormat
			.getNumberInstance(Locale.US);

	/**
	 * Private constructor.
	 */
	private ParsingUtils() {
	}

	/**
	 * Try parsing a {@code Boolean} value from the specified string. </p>
	 * 
	 * If the string does not represent a boolean value, null is returned.
	 * 
	 * @param str
	 *            The string to parse
	 * @return Boolean value or null
	 */
	public static Boolean tryParsingBoolean(String str) {
		if (str.equalsIgnoreCase(TRUE)) {
			return Boolean.TRUE;
		} else if (str.equalsIgnoreCase(FALSE)) {
			return Boolean.FALSE;
		} else {
			return null;
		}
	}

	/**
	 * Try parsing a {@code Number} value for the specified string. </p>
	 * 
	 * If the string does not represent a numeric value, null is returned.
	 * 
	 * @param str
	 *            The string to parse
	 * @return Number or null
	 */
	public static Number tryParsingNumber(String str) {
		Number n = null;
		try {
			n = numberParser.parse(str);
		} catch (ParseException e) {
			// There is nothing we can do
		}
		return n;
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
}

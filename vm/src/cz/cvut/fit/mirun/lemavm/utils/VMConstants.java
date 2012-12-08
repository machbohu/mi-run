package cz.cvut.fit.mirun.lemavm.utils;

public abstract class VMConstants {

	private VMConstants() {
		// Private constructor to prevent instantiation
	}

	public static final String DOUBLE = "double";

	public static final String LONG = "long";

	public static final String INT = "int";

	public static final String SHORT = "short";

	public static final String BOOLEAN = "boolean";

	public static final String STRING = "string";

	public static final String NULL = "null";

	public static final String ARRAY = "array";

	public static final String THIS = "this";

	public static final String VOID = "void";

	public static final String MAIN_METHOD = "main";

	public static final String SYSTEM = "System";

	public static final String FILE = "File";

	// Arrays

	public static final String DOUBLE_ARR = "double[]";

	public static final String LONG_ARR = "long[]";

	public static final String INT_ARR = "int[]";

	public static final String SHORT_ARR = "short[]";

	public static final String BOOLEAN_ARR = "boolean[]";

	public static final String STRING_ARR = "string[]";

	public static final String FILE_ARR = "File[]";

	// VM Settings

	public static final int DEFAULT_HEAP_SIZE = 1000;

	/**
	 * How many times bigger should the old space be
	 */
	public static final int OLD_SPACE_MULTIPLIER = 2;

	public static final byte DEFAULT_TENURE_AGE = 2;

	public static final String GC_GENERATIONAL = "generationalScavenging";

	public static final String GC_COPYING = "copyingCollector";
}

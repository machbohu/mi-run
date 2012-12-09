package cz.cvut.fit.mirun.lemavm.core;

import java.util.HashMap;
import java.util.Map;

import cz.cvut.fit.mirun.lemavm.utils.VMConstants;

public abstract class VMSettings {

	private static final Map<String, Object> settings = initSettings();

	private VMSettings() {
		// Private constructor
	}

	private static Map<String, Object> initSettings() {
		final Map<String, Object> setts = new HashMap<>();
		setts.put(HEAP_SIZE, VMConstants.DEFAULT_HEAP_SIZE);
		setts.put(TENURE_AGE, VMConstants.DEFAULT_TENURE_AGE);
		setts.put(GC_TYPE, VMConstants.GC_GENERATIONAL);
		return setts;
	}

	public static Object get(String name) {
		return settings.get(name);
	}

	public static void set(String name, Object value) {
		settings.put(name, value);
	}

	// Settings names

	public static final String HEAP_SIZE = "-lemaHeapSize";

	public static final String TENURE_AGE = "-lemaTenureAge";

	public static final String GC_TYPE = "-lemaGcType";
}

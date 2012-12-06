package cz.cvut.fit.mirun.lemavm.tests.gc;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.core.VMInterpreter;
import cz.cvut.fit.mirun.lemavm.core.memory.VMMemoryManager;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

public class GarbageCollectorTests {

	private static final String SET_ENV_METHOD = "setCurrentEnvironment";
	private static final String MEM_MANAGER_NAME = "manager";
	private static final int HEAP_SIZE = 10;

	private static VMEnvironment env;
	private static VMMemoryManager manager;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		VMMemoryManager.initializeMemoryManager(HEAP_SIZE);
	}

	@Before
	public void setUp() throws Exception {
		env = new VMEnvironment();
		VMInterpreter i = VMInterpreter.getInstance();
		// Set the environment
		final Method m = i.getClass().getDeclaredMethod(SET_ENV_METHOD,
				VMEnvironment.class);
		m.setAccessible(true);
		m.invoke(i, env);
		VMMemoryManager.resetMemoryManager();
		VMMemoryManager.initializeMemoryManager(HEAP_SIZE);
		final Field f = VMMemoryManager.class
				.getDeclaredField(MEM_MANAGER_NAME);
		f.setAccessible(true);
		manager = (VMMemoryManager) f.get(null);
	}

	@Test
	public void testGarbageCollection() throws NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException {
		int i = 0;
		env.addBinding("a", new VMString("test"), "string");
		for (i = 1; i < HEAP_SIZE / 2 + 1; i++) {
			// Just create it and throw away
			VMString s = new VMString("string" + i);
		}
		final Field ptrField = VMMemoryManager.class
				.getDeclaredField("heapPtr");
		ptrField.setAccessible(true);
		final int ptr = ptrField.getInt(manager);
		assertEquals((i % (HEAP_SIZE / 2)), ptr);
	}

}

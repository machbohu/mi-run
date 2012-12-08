package cz.cvut.fit.mirun.lemavm.tests.gc;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.core.VMInterpreter;
import cz.cvut.fit.mirun.lemavm.core.VMSettings;
import cz.cvut.fit.mirun.lemavm.core.memory.VMMemoryManager;
import cz.cvut.fit.mirun.lemavm.structures.VMArray;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;

public class CopyingGarbageCollectorTests {

	private static final String SET_ENV_METHOD = "setCurrentEnvironment";
	private static final String MEM_MANAGER_NAME = "manager";
	private static final int SEMI_SIZE = 5;

	private static VMEnvironment env;
	private static VMMemoryManager manager;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		VMSettings.set(VMSettings.HEAP_SIZE, SEMI_SIZE * 2);
		VMSettings.set(VMSettings.GC_TYPE, VMConstants.GC_COPYING);
		VMMemoryManager.resetMemoryManager();
		VMMemoryManager.initializeMemoryManager();
	}

	@Before
	public void setUp() throws Exception {
		env = new VMEnvironment();
		VMInterpreter i = VMInterpreter.getInstance();
		i.resetPartVM();
		// Set the environment
		final Method m = i.getClass().getDeclaredMethod(SET_ENV_METHOD,
				VMEnvironment.class);
		m.setAccessible(true);
		m.invoke(i, env);
		VMMemoryManager.resetMemoryManager();
		VMMemoryManager.initializeMemoryManager();
		final Field f = VMMemoryManager.class
				.getDeclaredField(MEM_MANAGER_NAME);
		f.setAccessible(true);
		manager = (VMMemoryManager) f.get(null);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		VMSettings.set(VMSettings.HEAP_SIZE, VMConstants.DEFAULT_HEAP_SIZE);
		VMSettings.set(VMSettings.GC_TYPE, VMConstants.GC_GENERATIONAL);
	}

	@Test
	public void testGarbageCollection() throws NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException {
		int i = 0;
		env.addBinding("a", new VMString("test"), "string");
		for (i = 1; i < SEMI_SIZE + 1; i++) {
			// Just create it and throw away
			@SuppressWarnings("unused")
			VMString s = new VMString("string" + i);
		}
		final Field ptrField = VMMemoryManager.class
				.getDeclaredField("heapPtr");
		ptrField.setAccessible(true);
		final int ptr = ptrField.getInt(manager);
		// + 1 is because the pointer points to the next free index
		assertEquals(i % SEMI_SIZE + 1, ptr);
	}

	@Test
	public void testRunGCSeveralTimes() throws NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException {
		for (int i = 0; i < SEMI_SIZE * 4 + 1; i++) {
			// Just create it and throw away
			@SuppressWarnings("unused")
			VMString s = new VMString("string" + i);
		}
		final Field ptrField = VMMemoryManager.class
				.getDeclaredField("heapPtr");
		ptrField.setAccessible(true);
		final int ptr = ptrField.getInt(manager);
		assertEquals(1, ptr);
	}

	@Test
	public void testRunGCWithReferencedObjects() throws NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException {
		final VMArray arr = new VMArray(new VMString[3], "string");
		env.addBinding("arr", arr, "string[]");
		arr.set(0, new VMString("1"));
		arr.set(1, new VMString("2"));
		arr.set(2, new VMString("3"));
		final int cnt = 5;
		for (int i = 0; i < cnt; i++) {
			// Just create it and throw away
			@SuppressWarnings("unused")
			VMString s = new VMString("string" + i);
		}
		final Field ptrField = VMMemoryManager.class
				.getDeclaredField("heapPtr");
		ptrField.setAccessible(true);
		final int ptr = ptrField.getInt(manager);
		int exp = (arr.getLength() + 1 + cnt) % SEMI_SIZE + 1;
		assertEquals(exp, ptr);
	}
}

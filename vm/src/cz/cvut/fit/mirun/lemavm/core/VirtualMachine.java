package cz.cvut.fit.mirun.lemavm.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.antlr.runtime.CharStream;
import org.apache.log4j.Logger;

import cz.cvut.fit.mirun.lemavm.builder.VMCreator;
import cz.cvut.fit.mirun.lemavm.core.memory.VMMemoryManager;
import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMClass;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

/**
 * This is the main entry point of the LeMaVM virtual machine.
 * 
 * @author kidney
 * 
 */
public class VirtualMachine {

	private static final Logger LOG = Logger.getLogger(VirtualMachine.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			LOG.error("Insuficient number of arguments. You have to specify at least the name of the file to run.");
			System.exit(1);
		}
		final String file = args[0];
		String[] appArgs = Arrays.copyOfRange(args, 1, args.length);
		initAndLaunch(file, appArgs);

	}

	public static void initAndLaunch(String file, String[] args) {
		args = scanForVMSettings(args);
		VMMemoryManager.initializeMemoryManager();
		// Create base structure (classes = variables + constructors + methods)
		VMCreator.createBaseStructureFromTree(file);
		// launch main method if present
		VMInterpreter.getInstance().executeApplication(args);
	}

	public static void initAndLaunch(CharStream stream) {
		String[] args = {};
		VMMemoryManager.initializeMemoryManager();
		// Create base structure (classes = variables + constructors + methods)
		VMCreator.createBaseStructureFromTree(stream);
		// launch main method if present
		VMInterpreter.getInstance().executeApplication(args);
	}

	/**
	 * Reset whole VM - reseting order is important!
	 */
	public static void reset() {
		VMInterpreter.getInstance().resetPartVM();
		VMEnvironment.resetPartVM();
		VMClass.resetPartVM();
		VMMemoryManager.resetMemoryManager();
	}

	private static String[] scanForVMSettings(String[] args) {
		int i = Arrays.binarySearch(args, VMSettings.GC_TYPE);
		if (i > 0) {
			String value = args[i + 1];
			args[i] = "";
			args[i + 1] = "";
			VMSettings.set(VMSettings.GC_TYPE, value);
		}
		i = Arrays.binarySearch(args, VMSettings.HEAP_SIZE);
		if (i > 0) {
			try {
				Integer value = Integer.valueOf(args[i + 1]);
				VMSettings.set(VMSettings.HEAP_SIZE, value);
				args[i] = "";
				args[i + 1] = "";
			} catch (NumberFormatException e) {
				throw new VMParsingException("Invalid heap size parameter.");
			}
		}
		i = Arrays.binarySearch(args, VMSettings.TENURE_AGE);
		if (i > 0) {
			try {
				Integer value = Integer.valueOf(args[i + 1]);
				VMSettings.set(VMSettings.TENURE_AGE, value);
				args[i] = "";
				args[i + 1] = "";
			} catch (NumberFormatException e) {
				throw new VMParsingException("Invalid heap size parameter.");
			}
		}
		final List<String> argList = new ArrayList<>(args.length);
		for (String s : args) {
			if (!s.isEmpty()) {
				argList.add(s);
			}
		}
		String[] arr = new String[argList.size()];
		argList.toArray(arr);
		return arr;
	}
}

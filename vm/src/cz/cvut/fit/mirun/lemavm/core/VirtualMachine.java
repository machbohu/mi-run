package cz.cvut.fit.mirun.lemavm.core;

import java.util.Arrays;

import org.antlr.runtime.CharStream;
import org.apache.log4j.Logger;

import cz.cvut.fit.mirun.lemavm.builder.VMCreator;
import cz.cvut.fit.mirun.lemavm.core.memory.VMMemoryManager;
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
	private static final int DEFAULT_HEAP_SIZE = 1000;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			LOG.error("Insuficient number of arguments. You have to specify at least the name of the file to run.");
			System.exit(1);
		}
		final String file = args[0];
		final String[] appArgs = Arrays.copyOfRange(args, 1, args.length);
		initAndLaunch(file, appArgs);

	}

	public static void initAndLaunch(String file, String[] args) {
		// Create base structure (classes = variables + constructors + methods)
		VMCreator.createBaseStructureFromTree(file);
		VMMemoryManager.initializeMemoryManager(DEFAULT_HEAP_SIZE);
		// launch main method if present
		VMInterpreter.getInstance().executeApplication(args);
	}

	public static void initAndLaunch(CharStream stream) {
		// Create base structure (classes = variables + constructors + methods)
		VMCreator.createBaseStructureFromTree(stream);
		VMMemoryManager.initializeMemoryManager(DEFAULT_HEAP_SIZE);
		// launch main method if present
		VMInterpreter.getInstance().executeApplication(null);
	}
	
	/**
	 * Reset whole VM - reseting order is important!
	 */
	public static void reset(){
		VMInterpreter.getInstance().resetPartVM();
		VMEnvironment.resetPartVM();
		VMClass.resetPartVM();
		VMMemoryManager.resetMemoryManager();
	}
}

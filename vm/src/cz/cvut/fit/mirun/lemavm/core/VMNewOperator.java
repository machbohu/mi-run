package cz.cvut.fit.mirun.lemavm.core;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMClass;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

/**
 * This class is the new operator which is used to create instances of
 * non-primitive types.
 * 
 * @author kidney
 * 
 */
public final class VMNewOperator {

	private static final Logger LOG = Logger.getLogger(VMNewOperator.class);

	private static VMNewOperator instance;

	private Set<String> types;
	private Map<String, VMClass> classes;

	private VMNewOperator() {
		super();
	}

	public static synchronized VMNewOperator getInstance() {
		if (instance == null) {
			instance = new VMNewOperator();
			instance.types = VMEnvironment.getKnownTypes();
			instance.classes = VMClass.getClasses();
		}
		return instance;
	}

	/**
	 * Create new instance of the specified type with the specified arguments.
	 * </p>
	 * 
	 * The arguments will be passed to constructor in the same order they are in
	 * the list. NOTE: If there are not arguments to pass, pass this method an
	 * empty list, do not use null.
	 * 
	 * TODO Should the constructor be called from here or should the interpreter
	 * take care of this?
	 * 
	 * @param typeName
	 *            Name of the type to instantiate
	 * @param args
	 *            Arguments to pass to the constructor
	 * @return New object
	 */
	public VMObject evaluate(String typeName, List<Object> args) {
		if (typeName == null || args == null) {
			throw new NullPointerException();
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("Creating instance of type " + typeName);
			if (LOG.isTraceEnabled()) {
				LOG.trace("Arguments: " + args);
			}
		}
		VMObject newInstance = null;
		// TODO Create the instance
		VMMemoryManager.allocateObject(newInstance);
		return null;
	}

}

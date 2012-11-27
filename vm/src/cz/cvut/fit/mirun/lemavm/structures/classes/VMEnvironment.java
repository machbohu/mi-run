package cz.cvut.fit.mirun.lemavm.structures.classes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMFinalBindingExistsException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMUnknownTypeException;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;

public class VMEnvironment {

	private static final Logger LOG = Logger.getLogger(VMEnvironment.class);

	private static final Set<String> knownTypes = initTypes();

	// Contains all bindings (including final ones)
	private final Map<String, VMObject> bindings;
	private final Map<String, String> bindingTypes;
	// Bindings with the final keyword
	private final Map<String, VMObject> finalBindings;
	private final VMEnvironment parent;

	public VMEnvironment() {
		super();
		this.bindings = new HashMap<>();
		this.finalBindings = new HashMap<>();
		this.bindingTypes = new HashMap<>();
		// This will be the top environment
		this.parent = null;
	}

	public VMEnvironment(VMEnvironment parent) {
		super();
		this.bindings = new HashMap<>();
		this.finalBindings = new HashMap<>();
		this.bindingTypes = new HashMap<>();
		this.parent = parent;
	}

	/**
	 * Get binding for the specified name. Parent environments are searched too.
	 * </p>
	 * 
	 * This method return null if there is no binding with such name. Callers
	 * should handle this situation and throw evaluation error for using
	 * undefined binding name.
	 * 
	 * @param name
	 *            Name of the bound value
	 * @return Value bound to the specified name
	 */
	public VMObject getBinding(String name) {
		VMObject res = bindings.get(name);
		if (res == null && parent != null) {
			res = parent.getBinding(name);
		}
		return res;
	}

	/**
	 * Get declared type of the specified binding name. </p>
	 * 
	 * If there is no binding with such name, null is returned.
	 * 
	 * @param name
	 *            Name of the binding
	 * @return Declared type
	 */
	public String getNameType(String name) {
		String type = bindingTypes.get(name);
		if (type == null && parent != null) {
			type = parent.getNameType(name);
		}
		return type;
	}

	public boolean containsBinding(String name) {
		if (!bindings.containsKey(name)) {
			if (parent != null) {
				return parent.containsBinding(name);
			}
			return false;
		}
		return true;
	}

	/**
	 * Add new binding. </p>
	 * 
	 * This method overrides any bindings with the specified name except final
	 * bindings, in which case a {@code VMFinalBindingExistsException} is
	 * thrown. </p>
	 * 
	 * NOTE: This method does no type checking, it just saves the binding and
	 * the type of the name, type checking is the responsibility of this
	 * environment's clients. The only thing this method does is checking if the
	 * specified type exists. If not, unknown type exception is thrown.
	 * 
	 * @param name
	 *            Name of the binding
	 * @param value
	 *            Value of the binding
	 * @param type
	 *            Declared type of the value
	 * @throws VMFinalBindingExistsException
	 * @throws VMUnknownTypeException
	 */
	public void addBinding(String name, VMObject value, String type) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Creating binding for name " + name + " and value "
					+ value);
		}
		if (name == null || name.isEmpty() || value == null) {
			throw new VMEvaluationException(
					"Cannot create binding for this values: name = " + name
							+ ", value = " + value);
		}
		if (!knownTypes.contains(type)) {
			throw new VMUnknownTypeException("Uknown type " + type);
		}
		checkFinalBinding(name);
		bindings.put(name, value);
		bindingTypes.put(name, type);
	}

	/**
	 * Add new binding with a final keyword </p>
	 * 
	 * Such binding cannot be changed to another value.
	 * 
	 * @see #addBinding(String, VMObject, String)
	 * @throws VMFinalBindingExistsException
	 * @throws VMUnknownTypeException
	 */
	public void addFinalBinding(String name, VMObject value, String type) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Creating final binding for name " + name + " and value "
					+ value);
		}
		if (name == null || name.isEmpty() || value == null) {
			throw new VMEvaluationException(
					"Cannot create binding for this values: name = " + name
							+ ", value = " + value);
		}
		if (!knownTypes.contains(type)) {
			throw new VMUnknownTypeException("Uknown type " + type);
		}
		checkFinalBinding(name);
		bindings.put(name, value);
		bindingTypes.put(name, type);
		finalBindings.put(name, value);
	}

	public Map<String, VMObject> getBindings() {
		return bindings;
	}

	public VMEnvironment getParent() {
		return parent;
	}

	/**
	 * Check if a final binding with this name already exists.
	 * 
	 * @param name
	 *            The name to check
	 */
	private void checkFinalBinding(String name) {
		if (finalBindings.containsKey(name)) {
			throw new VMFinalBindingExistsException("Binding with name " + name
					+ " already exists.");
		}
	}

	private static Set<String> initTypes() {
		final Set<String> types = new HashSet<>();
		types.add(ObjectType.BOOLEAN.toString());
		types.add(ObjectType.SHORT.toString());
		types.add(ObjectType.INTEGER.toString());
		types.add(ObjectType.LONG.toString());
		types.add(ObjectType.DOUBLE.toString());
		types.add(ObjectType.STRING.toString());
		return types;
	}

	/**
	 * Add a new discovered type to the set of known types. </p>
	 * 
	 * If the type is already present, nothing happens.
	 * 
	 * @param typeName
	 *            Name of the type
	 */
	public static void addType(String typeName) {
		knownTypes.add(typeName);
	}
}

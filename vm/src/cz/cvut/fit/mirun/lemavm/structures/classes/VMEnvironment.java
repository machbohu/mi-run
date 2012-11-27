package cz.cvut.fit.mirun.lemavm.structures.classes;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMFinalBindingExistsException;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;

public class VMEnvironment {

	private static final Logger LOG = Logger.getLogger(VMEnvironment.class);

	// TODO type checking

	// Contains all bindings (including final ones)
	private final Map<String, VMObject> bindings;
	// Bindings with the final keyword
	private final Map<String, VMObject> finalBindings;
	private final VMEnvironment parent;

	public VMEnvironment() {
		super();
		this.bindings = new HashMap<>();
		this.finalBindings = new HashMap<>();
		// This will be the top environment
		this.parent = null;
	}

	public VMEnvironment(VMEnvironment parent) {
		super();
		this.bindings = new HashMap<>();
		this.finalBindings = new HashMap<>();
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
		if (res == null) {
			if (parent != null) {
				res = parent.getBinding(name);
			}
		}
		return res;
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
	 * thrown.
	 * 
	 * @param name
	 *            Name of the binding
	 * @param value
	 *            Value of the binding
	 * @throws VMFinalBindingExistsException
	 */
	public void addBinding(String name, VMObject value) {
		if (name == null || name.isEmpty() || value == null) {
			throw new VMEvaluationException(
					"Cannot create binding for this values: name = " + name
							+ ", value = " + value);
		}
		checkFinalBinding(name);
		bindings.put(name, value);
	}

	/**
	 * Add new binding with a final keyword </p>
	 * 
	 * Such binding cannot be changed to another value.
	 * 
	 * @throws VMFinalBindingExistsException
	 */
	public void addFinalBinding(String name, VMObject value) {
		if (name == null || name.isEmpty() || value == null) {
			throw new VMEvaluationException(
					"Cannot create binding for this values: name = " + name
							+ ", value = " + value);
		}
		checkFinalBinding(name);
		bindings.put(name, value);
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
}

package cz.cvut.fit.mirun.lemavm.structures.classes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMFinalBindingExistsException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMUnknownTypeException;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;

public class VMEnvironment {

	private static final Logger LOG = Logger.getLogger(VMEnvironment.class);

	private static final Set<String> knownTypes = initTypes();
	protected final VMClassInstance owner;

	// Contains all reference bindings (including final ones)
	protected final Map<String, VMObject> bindings;
	// Contains all binding types
	protected final Map<String, String> bindingTypes;
	// Contains primitive bindings
	protected final Map<String, Object> primitiveBindings;
	// Contains all final bindings (primitive and reference)
	protected final Map<String, Object> finalBindings;
	protected final VMEnvironment parent;

	// Used for method return values
	protected Object returnValue;
	protected String returnType;
	protected boolean shouldReturn;

	public VMEnvironment() {
		super();
		this.owner = null;
		this.bindings = new HashMap<>();
		this.finalBindings = new HashMap<>();
		this.bindingTypes = new HashMap<>();
		this.primitiveBindings = new HashMap<>();
		// This will be the top environment
		this.parent = null;
		this.shouldReturn = false;
	}

	public VMEnvironment(VMClassInstance owner) {
		super();
		this.owner = owner;
		this.bindings = new HashMap<>();
		this.finalBindings = new HashMap<>();
		this.bindingTypes = new HashMap<>();
		this.primitiveBindings = new HashMap<>();
		this.parent = null;
		this.shouldReturn = false;
	}

	public VMEnvironment(VMEnvironment parent) {
		super();
		this.owner = null;
		this.bindings = new HashMap<>();
		this.finalBindings = new HashMap<>();
		this.bindingTypes = new HashMap<>();
		this.primitiveBindings = new HashMap<>();
		this.parent = parent;
		this.shouldReturn = false;
	}

	public VMEnvironment(VMEnvironment parent, VMClassInstance owner) {
		super();
		this.owner = owner;
		this.bindings = new HashMap<>();
		this.finalBindings = new HashMap<>();
		this.bindingTypes = new HashMap<>();
		this.primitiveBindings = new HashMap<>();
		this.parent = parent;
		this.shouldReturn = false;
	}

	/**
	 * Get binding for the specified name. Parent environments are searched too.
	 * </p>
	 * 
	 * The value returned is cast to the specified class, which will probably be
	 * either {@code VMObject} or a primitive type wrapper ({@code Integer}
	 * etc.). </p>
	 * 
	 * This method return null if there is no binding with such name. Callers
	 * should handle this situation and throw evaluation error for using
	 * undefined binding name.
	 * 
	 * @param name
	 *            Name of the bound value
	 * @param cls
	 *            The expected runtime type of the returned value
	 * @return Value bound to the specified name
	 * @throws ClassCastException
	 *             If the returned value cannot be cast to the specified class
	 */
	public <T> T getBinding(String name, Class<T> cls) {
		if (name.equals(VMConstants.THIS)) {
			if (!cls.equals(VMObject.class)) {
				throw new VMEvaluationException(
						"The this keyword can be used only on VMObject instances.");
			}
			return cls.cast(owner);
		} else {
			Object res = bindings.get(name);
			if (res == null) {
				res = primitiveBindings.get(name);
			}
			if (res == null && parent != null) {
				res = parent.getBinding(name, cls);
			}
			return cls.cast(res);
		}
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
		if (!bindings.containsKey(name) && !primitiveBindings.containsKey(name)) {
			if (parent != null) {
				return parent.containsBinding(name);
			}
			return false;
		}
		return true;
	}

	private VMEnvironment getEnvironmentWithBinding(String name) {
		VMEnvironment env = this;
		while (env != null && !env.getBindings().containsKey(name)) {
			env = env.getParent();
		}
		return env;
	}

	private VMEnvironment getEnvironmentWithPrimitiveBinding(String name) {
		VMEnvironment env = this;
		while (env != null && !env.getPrimitiveBindings().containsKey(name)) {
			if(env instanceof VMInstanceEnvironment){
				VMInstanceEnvironment ienv = ((VMInstanceEnvironment) env);
				if(ienv.getClassEnvironment().getPrimitiveBindings().containsKey(name)){
					return ienv;
				}
			}
			
			env = env.getParent();
		}
		return env;
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

		VMEnvironment env = getEnvironmentWithBinding(name);

		if (env == this || env == null) {
			checkParams(name, value, type);
			checkFinalBinding(name);
			bindings.put(name, value);
			bindingTypes.put(name, type);
		} else {
			env.addBinding(name, value, type);
		}
	}

	/**
	 * Add new binding with a final keyword. </p>
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

		VMEnvironment env = getEnvironmentWithBinding(name);

		if (env == this || env == null) {
			checkParams(name, value, type);
			checkFinalBinding(name);
			bindings.put(name, value);
			bindingTypes.put(name, type);
			finalBindings.put(name, value);
		} else {
			env.addFinalBinding(name, value, type);
		}
	}

	/**
	 * Add a new binding for the specified primitive value (boxed).
	 * 
	 * @see #addBinding(String, VMObject, String)
	 */
	public void addPrimitiveBinding(String name, Object value, String type) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Creating primitive binding for name " + name
					+ " and value " + value);
		}

		VMEnvironment env = getEnvironmentWithPrimitiveBinding(name);

		if (env == this || env == null) {
			checkParams(name, value, type);
			checkFinalBinding(name);
			primitiveBindings.put(name, value);
			bindingTypes.put(name, type);
		} else {
			env.addPrimitiveBinding(name, value, type);
		}
	}

	/**
	 * Add a new final binding for the specified primitive value (boxed). </p>
	 * 
	 * @see #addFinalBinding(String, VMObject, String)
	 */
	public void addPrimitiveFinalBinding(String name, Object value, String type) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Creating primitive final binding for name " + name
					+ " and value " + value);
		}

		VMEnvironment env = getEnvironmentWithPrimitiveBinding(name);

		if (env == this || env == null) {
			checkParams(name, value, type);
			checkFinalBinding(name);
			primitiveBindings.put(name, value);
			bindingTypes.put(name, type);
			finalBindings.put(name, value);
		} else {
			env.addPrimitiveFinalBinding(name, value, type);
		}
	}

	public Map<String, VMObject> getBindings() {
		return bindings;
	}

	public Map<String, Object> getPrimitiveBindings() {
		return primitiveBindings;
	}

	public VMEnvironment getParent() {
		return parent;
	}

	public Object getReturnValue() {
		return returnValue;
	}

	public void setReturnValue(Object returnValue) {
		this.returnValue = returnValue;
		this.shouldReturn = true;

		if (parent != null) {
			parent.setReturnValue(returnValue);
		}
	}

	public String getReturnType() {
		if (returnType != null) {
			return returnType;
		}
		if (parent != null) {
			return parent.getReturnType();
		}
		// Fail safe
		return VMConstants.VOID;
	}

	public void setReturnType(String returnType) {
		if (returnType == null) {
			throw new NullPointerException();
		}
		this.returnType = returnType;
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

	private void checkParams(String name, Object value, String type) {
		if (name == null || name.isEmpty() || value == null) {
			throw new VMEvaluationException(
					"Cannot create binding for this values: name = " + name
							+ ", value = " + value);
		}
		if (!knownTypes.contains(type)) {
			throw new VMUnknownTypeException("Uknown type " + type);
		}
	}

	private static Set<String> initTypes() {
		final Set<String> types = new HashSet<>();
		types.add(VMConstants.BOOLEAN);
		types.add(VMConstants.SHORT);
		types.add(VMConstants.INT);
		types.add(VMConstants.LONG);
		types.add(VMConstants.STRING);
		types.add(ObjectType.STRING.toString());
		types.add(ObjectType.FILE.toString());
		types.add(VMConstants.BOOLEAN + "[]");
		types.add(VMConstants.SHORT + "[]");
		types.add(VMConstants.INT + "[]");
		types.add(VMConstants.LONG + "[]");
		types.add(VMConstants.STRING + "[]");
		types.add(ObjectType.FILE.toString() + "[]");
		return types;
	}

	/**
	 * Reset VMEnvironment when reseting Virtual machine
	 */
	public static void resetPartVM() {
		Iterator<String> it = VMClass.getClasses().keySet().iterator();

		while (it.hasNext()) {
			knownTypes.remove(it.next());
		}
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

	/**
	 * Get the set of all known type names.
	 * 
	 * @return Set of type names
	 */
	public static Set<String> getKnownTypes() {
		return knownTypes;
	}

	public boolean shouldReturn() {
		return shouldReturn;
	}
}

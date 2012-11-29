package cz.cvut.fit.mirun.lemavm.structures.classes;

import java.util.HashMap;
import java.util.Map;

import cz.cvut.fit.mirun.lemavm.exceptions.VMNullPointerException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;

/**
 * Meta class representing classes defined in the VM.
 * 
 * @author kidney
 * 
 */
public final class VMClass extends VMObject {

	private static Map<String, VMClass> classes = new HashMap<>();

	private final String name;
	private final VMClass superClass;
	private final Map<String, VMField> fields;
	private final Map<String, VMMethod> constructors;
	private final Map<String, VMMethod> methods;

	// TODO What about static fields and methods?

	private VMClass(String name, VMClass superClass) {
		super(ObjectType.META_CLASS);
		this.name = name;
		this.superClass = superClass;
		this.fields = new HashMap<>();
		this.constructors = new HashMap<>();
		this.methods = new HashMap<>();
	}

	private VMClass(String name, VMClass superClass,
			Map<String, VMField> fields, Map<String, VMMethod> constructors,
			Map<String, VMMethod> methods) {
		super(ObjectType.META_CLASS);
		this.name = name;
		this.superClass = superClass;

		if (fields == null) {
			this.fields = new HashMap<>();
		} else {
			this.fields = fields;
		}
		if (constructors.isEmpty()) {
			this.constructors = new HashMap<>();
		} else {
			this.constructors = constructors;
		}
		if (methods.isEmpty()) {
			this.methods = new HashMap<>();
		} else {
			this.methods = methods;
		}
	}

	public String getName() {
		return name;
	}

	public VMClass getSuperClass() {
		return superClass;
	}

	public Map<String, VMField> getFields() {
		return fields;
	}

	/**
	 * Add new field to this class.
	 * 
	 * @param newField
	 *            The field to add
	 * @throws VMParsingException
	 *             If this class already contains a field of that name
	 */
	public void addField(VMField field) {
		if (field == null) {
			throw new VMNullPointerException();
		}
		if (fields.containsKey(field.getName())) {
			throw new VMParsingException("Field with name " + field.getName()
					+ " already exists in class " + name);
		}
		fields.put(field.getName(), field);
	}

	public Map<String, VMMethod> getMethods() {
		return methods;
	}

	private void addMethodOrConstructor(VMMethod newMethod,
			Map<String, VMMethod> container) {
		// TODO methods AND CONSTRUCTORS overloading (maybe check number of
		// arguments)
		if (newMethod == null) {
			throw new VMNullPointerException();
		} else if (container.containsKey(newMethod.getName())) {
			throw new VMParsingException("Method/Constructor with name "
					+ newMethod.getName() + " already exists in class " + name);
		}
		container.put(newMethod.getName(), newMethod);
		newMethod.setOwner(this);
	}

	public void addMethod(VMMethod newMethod) {
		addMethodOrConstructor(newMethod, methods);
	}

	public void addConstructor(VMMethod newMethod) {
		addMethodOrConstructor(newMethod, constructors);
	}

	/**
	 * Check if this class instance is the same or is a superclass of the
	 * specified other class.
	 * 
	 * @param other
	 *            The class to check
	 * @return True if this class is assignable from the other
	 */
	public boolean isAssignableFrom(VMClass other) {
		if (other.getName().equals(name)) {
			return true;
		}
		VMClass sup = other;
		while (sup != null) {
			if (sup.getName().equals(name)) {
				return true;
			}
			sup = sup.getSuperClass();
		}
		return false;
	}

	/**
	 * Create class with the specified parameters. </p>
	 * 
	 * This static method is the only way to create a {@code VMClass} so that
	 * there is always only one object of the specified class name.
	 * 
	 * @param name
	 *            Name of the new class
	 * @param superClass
	 *            Super class of the new class. Can be null
	 * @return The new meta class
	 */
	public static VMClass createClass(String name, VMClass superClass) {
		if (name == null || name.isEmpty()) {
			throw new VMParsingException(
					"Invalid VMClass constructor parameters: " + name);
		}
		if (classes.containsKey(name)) {
			// return classes.get(name);
			throw new VMParsingException("Definition of class with name "
					+ name + " already exists.");
		}
		final VMClass newClass = new VMClass(name, superClass);
		classes.put(name, newClass);
		VMEnvironment.addType(name);
		return newClass;
	}

	/**
	 * Create class with the specified parameters. </p>
	 * 
	 * @param name
	 *            Name of the new class
	 * @param superClass
	 *            Super class of the new class. Can be null
	 * @param fields
	 *            Fields of the new class
	 * @param methods
	 *            Methods of the new class
	 * @return The new meta class
	 * @see #createClass(String, VMClass)
	 */
	public static VMClass createClass(String name, VMClass superClass,
			Map<String, VMField> fields, Map<String, VMMethod> constructors,
			Map<String, VMMethod> methods) {
		if (name == null || name.isEmpty()) {
			throw new VMParsingException(
					"Invalid VMClass constructor parameters: " + name);
		}
		if (classes.containsKey(name)) {
			// return classes.get(name);
			throw new VMParsingException("Definition of class with name "
					+ name + " already exists.");
		}
		final VMClass newClass = new VMClass(name, superClass, fields,
				constructors, methods);
		classes.put(name, newClass);
		VMEnvironment.addType(name);
		return newClass;
	}

	/**
	 * Get a map of all existing classes.
	 * 
	 * @return Existing classes
	 */
	public static Map<String, VMClass> getClasses() {
		return classes;
	}

	@Override
	public VMObject evaluate() {
		return this;
	}
}

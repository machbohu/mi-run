package cz.cvut.fit.mirun.lemavm.structures.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cz.cvut.fit.mirun.lemavm.exceptions.VMAmbiguousMethodDeclaration;
import cz.cvut.fit.mirun.lemavm.exceptions.VMNullPointerException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;

/**
 * Meta class representing classes defined in the VM.
 * 
 * @author kidney
 * 
 */
public final class VMClass {

	private static final Map<String, VMClass> classes = new HashMap<>();

	private final String name;
	private final VMClass superClass;
	private final Map<String, VMField> fields;
	private final List<VMMethod> constructors;
	// Need to use list to support method overloading
	private final Map<String, List<VMMethod>> methods;

	// TODO What about static fields and methods?

	private VMClass(String name, VMClass superClass) {
		this.name = name;
		this.superClass = superClass;
		this.fields = new HashMap<>();
		this.constructors = new ArrayList<>();
		this.methods = new HashMap<>();
	}

	private VMClass(String name, VMClass superClass,
			Map<String, VMField> fields, List<VMMethod> constructors,
			Map<String, List<VMMethod>> methods) {
		this.name = name;
		this.superClass = superClass;

		if (fields == null) {
			this.fields = new HashMap<>();
		} else {
			this.fields = fields;
		}
		if (constructors.isEmpty()) {
			this.constructors = new ArrayList<>();
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

	public Map<String, List<VMMethod>> getMethods() {
		return methods;
	}

	public List<VMMethod> getMethodsForName(String methodName) {
		if (methodName == null) {
			throw new NullPointerException();
		}
		List<VMMethod> res = methods.get(methodName);
		if (res == null) {
			return Collections.emptyList();
		}
		return res;
	}

	public List<VMMethod> getDeclaredConstructors() {
		return constructors;
	}

	/**
	 * Add a new method to this class. </p>
	 * 
	 * Method ambiguity check is performed.
	 * 
	 * @param newMethod
	 *            The method to add
	 * @throws VMAmbiguousMethodDeclaration
	 */
	public void addMethod(VMMethod newMethod) {
		if (newMethod == null) {
			throw new NullPointerException();
		}
		List<VMMethod> ms = methods.get(newMethod.getName());
		if (ms != null) {
			VMMethod.checkForMethodAmbiguity(methods.get(newMethod.getName()),
					newMethod);
			ms.add(newMethod);
		} else {
			ms = new ArrayList<>();
			ms.add(newMethod);
			methods.put(newMethod.getName(), ms);
		}
		newMethod.setOwner(this);
	}

	/**
	 * Add a new constructor to this class. </p>
	 * 
	 * Method ambiguity check is performed.
	 * 
	 * @param newConstructor
	 *            The constructor to add
	 * @throws VMAmbiguousMethodDeclaration
	 */
	public void addConstructor(VMMethod newConstructor) {
		if (newConstructor == null) {
			throw new NullPointerException();
		}
		VMMethod.checkForMethodAmbiguity(getDeclaredConstructors(),
				newConstructor);
		constructors.add(newConstructor);
		newConstructor.setOwner(this);
	}

	/**
	 * Create new instance of this class. </p>
	 * 
	 * @return New instance of this class
	 */
	public VMClassInstance createInstance() {
		if (superClass != null) {
			return new VMClassInstance(this, superClass.createInstance());
		} else {
			return new VMClassInstance(this, null);
		}
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

	@Override
	public boolean equals(Object other) {
		if (other instanceof VMClass) {
			final VMClass c = (VMClass) other;
			return name.equals(c.getName());
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hash = 31 * name.hashCode();
		return hash;
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
			Map<String, VMField> fields, List<VMMethod> constructors,
			Map<String, List<VMMethod>> methods) {
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
	public String toString() {
		return name;
	}
}

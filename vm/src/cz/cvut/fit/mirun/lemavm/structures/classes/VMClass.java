package cz.cvut.fit.mirun.lemavm.structures.classes;

import java.util.Collections;
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
	private final Map<String, VMVisibilityModifier> fields;
	private final Map<String, VMMethod> methods;

	// TODO What about static fields and methods?

	private VMClass(String name, VMClass superClass) {
		super(ObjectType.META_CLASS);
		this.name = name;
		this.superClass = superClass;
		this.fields = new HashMap<>();
		this.methods = new HashMap<>();
	}

	private VMClass(String name, VMClass superClass,
			Map<String, VMVisibilityModifier> fields,
			Map<String, VMMethod> methods) {
		super(ObjectType.META_CLASS);
		this.name = name;
		this.superClass = superClass;
		if (fields == null) {
			this.fields = Collections.emptyMap();
		} else {
			this.fields = fields;
		}
		if (methods.isEmpty()) {
			this.methods = Collections.emptyMap();
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

	public Map<String, VMVisibilityModifier> getFields() {
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
	public void addField(String newField, VMVisibilityModifier visibility) {
		if (newField == null) {
			throw new VMNullPointerException();
		}
		if (fields.containsKey(newField)) {
			throw new VMParsingException("Field with name " + newField
					+ " already exists in class " + name);
		}
		fields.put(newField, visibility);
	}

	public Map<String, VMMethod> getMethods() {
		return methods;
	}

	public void addMethod(VMMethod newMethod) {
		if (newMethod == null) {
			throw new VMNullPointerException();
		}
		methods.put(newMethod.getName(), newMethod);
		newMethod.setOwner(this);
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
			return classes.get(name);
		}
		final VMClass newClass = new VMClass(name, superClass);
		classes.put(name, newClass);
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
			Map<String, VMVisibilityModifier> fields,
			Map<String, VMMethod> methods) {
		if (name == null || name.isEmpty()) {
			throw new VMParsingException(
					"Invalid VMClass constructor parameters: " + name);
		}
		if (classes.containsKey(name)) {
			return classes.get(name);
		}
		final VMClass newClass = new VMClass(name, superClass, fields, methods);
		classes.put(name, newClass);
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

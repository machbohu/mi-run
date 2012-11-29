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
	private final boolean isStatic;
	private final VMVisibilityModifier visibility;
	private final Map<String, VMVisibilityModifier> fieldMods;
	private final Map<String, String> fieldTypes; // <name, type>
	private final Map<String, Object> fieldVals; // <name, value>
	private final Map<String, VMMethod> constructors;
	private final Map<String, VMMethod> methods;

	// TODO What about static fields and methods?

	private VMClass(String name, VMClass superClass, boolean isStatic, VMVisibilityModifier visibility) {
		super(ObjectType.META_CLASS);
		this.name = name;
		this.superClass = superClass;
		this.isStatic = isStatic;
		this.visibility = visibility;
		this.fieldMods = new HashMap<>();
		this.fieldTypes = new HashMap<>();
		this.fieldVals = new HashMap<>();
		this.constructors = new HashMap<>();
		this.methods = new HashMap<>();
	}

	private VMClass(String name, VMClass superClass, boolean isStatic, VMVisibilityModifier visibility,
			Map<String, VMVisibilityModifier> fieldMods,
			Map<String, String> fieldTypes,
			Map<String, Object> fieldVals,
			Map<String, VMMethod> constructors,
			Map<String, VMMethod> methods) {
		super(ObjectType.META_CLASS);
		this.name = name;
		this.superClass = superClass;
		this.isStatic = isStatic;
		this.visibility = visibility;
		
		if (fieldMods == null) {
			this.fieldMods = Collections.emptyMap();
		} else {
			this.fieldMods = fieldMods;
		}
		if (fieldTypes == null) {
			this.fieldTypes = Collections.emptyMap();
		} else {
			this.fieldTypes = fieldTypes;
		}
		if (fieldVals == null) {
			this.fieldVals = Collections.emptyMap();
		} else {
			this.fieldVals = fieldVals;
		}
		if (constructors.isEmpty()) {
			this.constructors = Collections.emptyMap();
		} else {
			this.constructors = constructors;
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

	public Map<String, VMVisibilityModifier> getFieldMods() {
		return fieldMods;
	}

	public Map<String, String> getFieldTypes() {
		return fieldTypes;
	}

	public Map<String, Object> getFieldVals() {
		return fieldVals;
	}

	/**
	 * Add new field to this class.
	 * 
	 * @param newField
	 *            The field to add
	 * @throws VMParsingException
	 *             If this class already contains a field of that name
	 */
	public void addField(String newField, VMVisibilityModifier visibility, String type, Object val) {
		if (newField == null) {
			throw new VMNullPointerException();
		}
		if (fieldMods.containsKey(newField)) {
			throw new VMParsingException("Field with name " + newField
					+ " already exists in class " + name);
		}
		fieldMods.put(newField, visibility);
		fieldTypes.put(newField, type);
		fieldVals.put(newField, val);
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
	public static VMClass createClass(String name, VMClass superClass, 
			boolean isStatic, VMVisibilityModifier visibility) {
		if (name == null || name.isEmpty()) {
			throw new VMParsingException(
					"Invalid VMClass constructor parameters: " + name);
		}
		if (classes.containsKey(name)) {
//			return classes.get(name);
			throw new VMParsingException("Definition of class with name "+name+" already exists.");
		}
		final VMClass newClass = new VMClass(name, superClass, isStatic, visibility);
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
			boolean isStatic, VMVisibilityModifier visibility,
			Map<String, VMVisibilityModifier> fieldMods,
			Map<String, String> fieldTypes,
			Map<String, Object> fieldVals,
			Map<String, VMMethod> constructors,
			Map<String, VMMethod> methods) {
		if (name == null || name.isEmpty()) {
			throw new VMParsingException(
					"Invalid VMClass constructor parameters: " + name);
		}
		if (classes.containsKey(name)) {
//			return classes.get(name);
			throw new VMParsingException("Definition of class with name "+name+" already exists.");
		}
		final VMClass newClass = new VMClass(name, superClass, isStatic, visibility, 
				fieldMods, fieldTypes, fieldVals, constructors, methods);
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

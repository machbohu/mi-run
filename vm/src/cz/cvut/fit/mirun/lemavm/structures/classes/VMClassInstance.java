package cz.cvut.fit.mirun.lemavm.structures.classes;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;

/**
 * This class represents an instance of class defined in the code interpreted by
 * the VM.
 * 
 * @author kidney
 * 
 */
public class VMClassInstance extends VMObject {

	private final VMClass cls;
	// For inheritance support
	private final VMClassInstance superInst;
	// The environment contains mapping of instance fields and values
	private final VMEnvironment environment;

	public VMClassInstance(VMClass cls, VMClassInstance superInst) {
		super(ObjectType.OBJECT);
		this.cls = cls;
		this.superInst = superInst;
		this.environment = initEnvironment();
	}

	/**
	 * Set value of a field with the specified name. </p>
	 * 
	 * @param field
	 *            The field to set
	 */
	public void setFieldValue(String fieldName, Object value) {
		if (fieldName == null || value == null) {
			throw new NullPointerException();
		}
		if (!environment.containsBinding(fieldName)) {
			throw new VMEvaluationException("Unknown field name " + fieldName
					+ " in type " + cls.getName());
		}
		if (value instanceof VMObject) {
			final VMObject obVal = (VMObject) value;
			environment.addBinding(fieldName, obVal, obVal.getTypeName());
		} else {
			environment.addPrimitiveBinding(fieldName, value,
					environment.getNameType(fieldName));
		}
	}

	/**
	 * Get visibility of field with the specified name. </p>
	 * 
	 * If the field is not defined in class of this instance, null is returned.
	 * 
	 * @param fieldName
	 *            Name of the field
	 * @return Visibility modified or null
	 */
	public VMVisibilityModifier getFieldVisibility(String fieldName) {
		assert fieldName != null;
		if (cls.getFields().containsKey(fieldName)) {
			return cls.getFields().get(fieldName).getVisibility();
		} else {
			return null;
		}
	}

	public VMClass getVMClass() {
		return cls;
	}

	public VMClassInstance getSuperInstance() {
		return superInst;
	}

	public VMEnvironment getEnvironment() {
		return environment;
	}

	@Override
	public String getTypeName() {
		return cls.getName();
	}

	private VMEnvironment initEnvironment() {
		VMEnvironment env = null;
		if (superInst != null) {
			env = new VMInstanceEnvironment(superInst.environment, this);
		} else {
			env = new VMInstanceEnvironment(this);
		}
		return env;
	}
}

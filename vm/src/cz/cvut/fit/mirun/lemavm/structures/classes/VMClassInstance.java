package cz.cvut.fit.mirun.lemavm.structures.classes;

import java.util.HashMap;
import java.util.Map;

import cz.cvut.fit.mirun.lemavm.core.VMParsingException;
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
	// For possible inheritance support
	private final VMClassInstance superInst;

	private final Map<String, VMObject> fieldValues;

	public VMClassInstance(VMClass cls, VMClassInstance superInst) {
		super(ObjectType.OBJECT);
		fieldValues = new HashMap<>();
		this.cls = cls;
		this.superInst = superInst;
	}

	/**
	 * Set value of a field. </p>
	 * 
	 * The name of the field is specified in the {@code VMField} instance.
	 * 
	 * @param field
	 *            The field to set
	 * @return True if the set was successful, false otherwise
	 */
	public void setFieldValue(String fieldName, VMObject value) {
		assert fieldName != null;
		assert value != null;
		if (!cls.getFields().containsKey(fieldName)) {
			if (superInst != null) {
				try {
					superInst.setFieldValue(fieldName, value);
					return;
				} catch (VMParsingException e) {
					// Rethrow, but with correct class name
					throw new VMParsingException("Unknown field name "
							+ fieldName + " in class " + cls.getName());
				}
			} else {
				throw new VMParsingException("Unknown field name " + fieldName
						+ " in class " + cls.getName());
			}
		}
		fieldValues.put(fieldName, value);
	}

	public Map<String, VMObject> getFieldValues() {
		if (superInst != null) {
			final Map<String, VMObject> vals = superInst.getFieldValues();
			vals.putAll(fieldValues);
			return vals;
		}
		return fieldValues;
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
		return cls.getFields().get(fieldName);
	}

	public VMClass getVMClass() {
		return cls;
	}

	public VMClassInstance getSuperInstance() {
		return superInst;
	}

	@Override
	public VMObject evaluate() {
		return this;
	}
}

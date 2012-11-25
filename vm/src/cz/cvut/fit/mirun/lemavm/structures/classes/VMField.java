package cz.cvut.fit.mirun.lemavm.structures.classes;

import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;

public final class VMField extends VMObject {
	
	private final String name;
	private VMObject value;
	private final VMVisibilityModifier visibility;
	
	public VMField(String name, VMVisibilityModifier visibility) {
		super(ObjectType.OBJECT);
		this.name = name;
		this.visibility = visibility;
	}

	@Override
	public VMObject evaluate() {
		return value;
	}

	public VMObject getValue() {
		return value;
	}

	public void setValue(VMObject value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public VMVisibilityModifier getVisibility() {
		return visibility;
	}

}

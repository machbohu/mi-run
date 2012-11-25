package cz.cvut.fit.mirun.lemavm.structures.classes;

import java.util.Collections;
import java.util.List;

import cz.cvut.fit.mirun.lemavm.core.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;

public class VMMethod extends VMObject {

	private final String name;
	private VMClass owner;
	private final List<VMObject> arguments;
	private final boolean methodStatic;
	private final VMVisibilityModifier visibility;

	private final List<VMObject> code;

	public VMMethod(String name, VMClass owner, boolean methodStatic,
			VMVisibilityModifier visibility, List<VMObject> arguments,
			List<VMObject> code) {
		super(ObjectType.METHOD);
		if (name == null || name.isEmpty() || visibility == null) {
			throw new VMParsingException(
					"Invalid VMMethod constructor parameters: " + name + ", "
							+ owner + ", " + visibility);
		}
		this.name = name;
		this.owner = owner;
		this.methodStatic = methodStatic;
		this.visibility = visibility;
		if (arguments == null) {
			this.arguments = Collections.emptyList();
		} else {
			this.arguments = arguments;
		}
		this.code = code;
	}

	@Override
	public VMObject evaluate() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		return name;
	}

	public VMClass getOwner() {
		return owner;
	}

	public void setOwner(VMClass owner) {
		this.owner = owner;
	}

	public int getArgumentCount() {
		return arguments.size();
	}

	public List<VMObject> getArguments() {
		return arguments;
	}

	public boolean isMethodStatic() {
		return methodStatic;
	}

	public VMVisibilityModifier getVisibility() {
		return visibility;
	}

	public List<VMObject> getCode() {
		return code;
	}
}

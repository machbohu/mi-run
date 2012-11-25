package cz.cvut.fit.mirun.lemavm.structures.classes;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import cz.cvut.fit.mirun.lemavm.core.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;

public class VMMethod extends VMObject {

	private final String name;
	private VMClass owner;
	private final Map<String, VMObject> arguments;
	private final boolean methodStatic;
	private final VMVisibilityModifier visibility;

	// TODO This may not be the best representation of a code block
	private final List<VMObject> code;

	public VMMethod(String name, VMClass owner, boolean methodStatic,
			VMVisibilityModifier visibility, Map<String, VMObject> arguments,
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
			this.arguments = Collections.emptyMap();
		} else {
			this.arguments = arguments;
		}
		this.code = code;
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

	/**
	 * Get arguments of this method. </p>
	 * 
	 * The {@code Map} representing the arguments consists of pairs (argument
	 * name, argument type).
	 * 
	 * @return Map of argument names and types
	 */
	public Map<String, VMObject> getArguments() {
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

	@Override
	public VMObject evaluate() {
		return this;
	}
}

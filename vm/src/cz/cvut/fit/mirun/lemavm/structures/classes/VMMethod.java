package cz.cvut.fit.mirun.lemavm.structures.classes;

import java.util.Collections;
import java.util.Map;

import org.antlr.runtime.tree.CommonTree;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.VMCodeBlock;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;

public class VMMethod extends VMObject {

	private final String name;
	private VMClass owner;
	private final Map<String, String> arguments; // <name, type>
	private final boolean methodStatic;
	private final VMVisibilityModifier visibility;
	private final VMEnvironment env;

	private final CommonTree subTree;
	// TODO This may not be the best representation of a code block
	private final VMCodeBlock code;

	public VMMethod(String name, VMClass owner, boolean methodStatic,
			VMVisibilityModifier visibility, Map<String, String> arguments,
			CommonTree tree) {
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
		this.env = new VMEnvironment();
		
		if (arguments == null) {
			this.arguments = Collections.emptyMap();
		} else {
			this.arguments = arguments;
		}
		
		this.subTree = tree;
		this.code = null;
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
	public Map<String, String> getArguments() {
		return arguments;
	}

	public boolean isMethodStatic() {
		return methodStatic;
	}

	public VMVisibilityModifier getVisibility() {
		return visibility;
	}

	public VMCodeBlock getCode() {
		return code;
	}

	@Override
	public VMObject evaluate() {
		return this;
	}
}

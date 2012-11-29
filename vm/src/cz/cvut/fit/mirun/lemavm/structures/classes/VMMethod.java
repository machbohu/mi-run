package cz.cvut.fit.mirun.lemavm.structures.classes;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
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
	private final boolean isStatic;
	private final VMVisibilityModifier visibility;
	private final String returnType;
	private final VMEnvironment env;

	private final CommonTree methodTree;
	// TODO This may not be the best representation of a code block
	private final VMCodeBlock code;

	/**
	 * WARNING: Make sure that a order preserving instance of argument map is
	 * used (e. g. LinkedHashMap). Otherwise, method lookup and overloading
	 * check may not work.
	 * 
	 * @param name
	 * @param owner
	 * @param isStatic
	 * @param visibility
	 * @param returnType
	 * @param arguments
	 * @param tree
	 */
	public VMMethod(String name, VMClass owner, boolean isStatic,
			VMVisibilityModifier visibility, String returnType,
			Map<String, String> arguments, CommonTree tree) {
		super(ObjectType.METHOD);
		if (name == null || name.isEmpty() || visibility == null) {
			throw new VMParsingException(
					"Invalid VMMethod constructor parameters: " + name + ", "
							+ owner + ", " + visibility);
		}
		this.name = name;
		this.owner = owner;
		this.isStatic = isStatic;
		this.visibility = visibility;
		this.returnType = returnType;
		// TODO should be created in time of method call?
		this.env = new VMEnvironment();

		if (arguments == null) {
			this.arguments = Collections.emptyMap();
		} else {
			this.arguments = arguments;
			// TODO fill environment with arguments?
		}

		this.methodTree = tree;
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
		return isStatic;
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

	/**
	 * Check if this method is not the same as the specified one. </p>
	 * 
	 * This method assumes only that the two method have common owner class. If
	 * their names differ, true is returned (they are completely different). If
	 * the names are equal, argument check is done and if the argument lists
	 * differ (in length or types), it is overloading and true is returned.
	 * Otherwise, this method returns false. </p>
	 * 
	 * NOTE: the current implementation checks only for exact argument type
	 * match, inheritance or conversions are not taken into account.
	 * 
	 * @param other
	 *            The other method to compare this one with
	 * @return True if the methods differ
	 */
	public boolean isOverloadable(VMMethod other) {
		if (other == null) {
			throw new NullPointerException();
		}
		if (!name.equals(other.getName())) {
			return true;
		}
		if (getArgumentCount() != other.getArgumentCount()) {
			return true;
		}
		final Iterator<String> it = arguments.keySet().iterator();
		final Iterator<String> itOther = other.arguments.keySet().iterator();
		while (it.hasNext() && itOther.hasNext()) {
			if (!arguments.get(it.next()).equals(
					other.arguments.get(itOther.next()))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Check if this method matches the specified name and arguments. </p>
	 * 
	 * This method will be used by the method lookup. </p>
	 * 
	 * NOTE: the current implementation checks only for exact argument type
	 * match, inheritance or conversions are not taken into account.
	 * 
	 * @param name
	 *            Name of the method
	 * @param args
	 *            List of argument types
	 * @return True if this method matches the specified description
	 */
	public boolean doesMethodMatch(String name, List<String> args) {
		if (name == null || args == null) {
			throw new NullPointerException();
		}
		if (!this.name.equals(name) || arguments.size() != args.size()) {
			return false;
		}
		final Iterator<String> it = arguments.keySet().iterator();
		for (String type : args) {
			assert it.hasNext();
			if (!type.equals(arguments.get(it.next()))) {
				return false;
			}
		}
		return true;
	}
}

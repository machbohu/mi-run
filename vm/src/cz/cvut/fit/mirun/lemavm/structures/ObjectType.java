package cz.cvut.fit.mirun.lemavm.structures;

import cz.cvut.fit.mirun.lemavm.utils.VMConstants;

/**
 * This enumeration defines all the possible types of objects recognized by the
 * VM. </p>
 * 
 * Can be extended in the future, this is just the first sketch.
 * 
 * @author kidney
 * 
 */
public enum ObjectType {
	META_CLASS("meta_class"), OBJECT("object"), METHOD("method"), STRING(
			VMConstants.STRING), CODE_BLOCK("code"), NULL("null"), VOID("void"), ARRAY(
			"array"), FILE("File"), FORWARD_POINTER("fwd");

	private final String name;

	private ObjectType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}

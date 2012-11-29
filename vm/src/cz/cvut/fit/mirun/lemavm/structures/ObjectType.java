package cz.cvut.fit.mirun.lemavm.structures;

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
	META_CLASS("meta_class"), OBJECT("object"), METHOD("method"), SHORT("short"), INTEGER(
			"int"), LONG("long"), DOUBLE("double"), STRING("string"), BOOLEAN(
			"boolean"), OPERATOR("operator"), IF_ELSE("if-else"), FOR("for"), WHILE(
			"while"), CODE_BLOCK("code"), NULL("null"), VOID("void"), ARRAY(
			"array");

	private final String name;

	private ObjectType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}

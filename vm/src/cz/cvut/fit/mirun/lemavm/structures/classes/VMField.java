package cz.cvut.fit.mirun.lemavm.structures.classes;

/**
 * Container for storing variables/fields (especially those builded
 * during AST tree parsing phase)
 * 
 * Compatibility between type and value (val) is not guaranteed!
 * This compatibility should be tested before use. 
 */

public class VMField {
	private String name;
	private boolean isStatic;
	private VMVisibilityModifier visibility;
	private String type;
	private Object val;

	public VMField(String newField, boolean isStatic,
			VMVisibilityModifier visibility, String type, Object val) {
		this.name = newField;
		this.isStatic = isStatic;
		this.visibility = visibility;
		this.type = type;
		this.val = val;
	}

	public String getName() {
		return name;
	}

	public VMVisibilityModifier getVisibility() {
		return visibility;
	}

	public String getType() {
		return type;
	}

	public Object getVal() {
		return val;
	}
	
	public void setVal(Object val){
		this.val = val;
	}

	public boolean isStatic() {
		return isStatic;
	}

	@Override
	public String toString() {
		String out = "VMField: name = " + name + ", type = " + type
				+ ", value = " + val.toString() + ", visibility = "
				+ visibility.toString() + ", isStatic = "
				+ Boolean.valueOf(isStatic);
		return out;
	}
}

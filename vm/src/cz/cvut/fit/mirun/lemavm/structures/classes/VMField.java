package cz.cvut.fit.mirun.lemavm.structures.classes;


public class VMField {
	private String name;
	private boolean isStatic;
	private VMVisibilityModifier visibility;
	private String type;
	private Object val;

	public VMField(String newField, boolean isStatic, 
			VMVisibilityModifier visibility, String type, Object val){
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
	
	
}

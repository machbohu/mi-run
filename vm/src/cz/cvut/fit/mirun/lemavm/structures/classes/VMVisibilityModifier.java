package cz.cvut.fit.mirun.lemavm.structures.classes;

public enum VMVisibilityModifier {
	PUBLIC, PROTECTED, PRIVATE;
	
	public static VMVisibilityModifier fromString(String val){
		switch(val){
		case "public":
			return VMVisibilityModifier.PUBLIC;
		case "protected":
			return VMVisibilityModifier.PROTECTED;
		case "private":
			return VMVisibilityModifier.PRIVATE;
		default:
			return VMVisibilityModifier.PROTECTED;
		}
	}
}

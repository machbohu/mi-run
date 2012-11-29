package cz.cvut.fit.mirun.lemavm.structures.classes;

public enum VMVisibilityModifier {
	PUBLIC, PROTECTED, PRIVATE;
	
	public static VMVisibilityModifier fromString(String val){
		switch(val){
		case "public":
			return PUBLIC;
		case "protected":
			return PROTECTED;
		case "private":
			return PRIVATE;
		default:
			return getDefault();
		}
	}
	
	public static VMVisibilityModifier getDefault(){
		return PROTECTED;
	}
}

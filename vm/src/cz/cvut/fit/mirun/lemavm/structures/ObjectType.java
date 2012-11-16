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
	META_CLASS, OBJECT, METHOD, PRIMITIVE, OPERATOR, NULL, LITERAL
}

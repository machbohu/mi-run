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
	META_CLASS, OBJECT, METHOD, SHORT, INTEGER, LONG, DOUBLE, STRING, BOOLEAN, OPERATOR, IF_ELSE, FOR, WHILE, CODE_BLOCK, NULL
}

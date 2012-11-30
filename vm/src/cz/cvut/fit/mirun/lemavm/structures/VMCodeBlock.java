package cz.cvut.fit.mirun.lemavm.structures;

import java.util.ArrayList;
import java.util.List;

/**
 * Instances of this class represent a block of code. </p>
 * 
 * They can be used in methods, loops, if-else statements, switch statements
 * etc.
 * 
 * @author kidney
 * 
 */
public final class VMCodeBlock extends VMObject {

	private final List<VMObject> code;

	public VMCodeBlock() {
		super(ObjectType.CODE_BLOCK);
		this.code = new ArrayList<>();
	}
	
	public VMCodeBlock(List<VMObject> code) {
		super(ObjectType.CODE_BLOCK);
		this.code = code;
	}

	public List<VMObject> getCode() {
		return code;
	}

	@Override
	public VMObject evaluate() {
		// TODO
		return null;
	}
}

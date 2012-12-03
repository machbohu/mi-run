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
public final class VMCodeBlock {

	private final List<Object> code;

	public VMCodeBlock() {
		this.code = new ArrayList<>();
	}

	public VMCodeBlock(List<Object> code) {
		this.code = code;
	}

	public List<Object> getCode() {
		return code;
	}
}

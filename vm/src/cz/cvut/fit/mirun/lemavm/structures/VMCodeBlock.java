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

	private final List<Evaluable> code;

	public VMCodeBlock() {
		this.code = new ArrayList<>();
	}

	public VMCodeBlock(List<Evaluable> code) {
		this.code = code;
	}

	public List<Evaluable> getCode() {
		return code;
	}
	
	public void addCodePart(Object codePart){
		if(codePart instanceof Evaluable){
			code.add((Evaluable) codePart);
		}else{
			throw new IllegalArgumentException(
					"Illegal argument passed to VMCodeBlock.addCodePart "+codePart);
		}
	}
}

package cz.cvut.fit.mirun.lemavm.structures.classes;

/**
 * Inline Cache for method calls - every VMMethodCallOperator has
 * it's own ilc.
 */
public class VMInlineCache {
	private VMMethod method;

	public VMMethod getMethod() {
		return method;
	}

	public void setMethod(VMMethod method) {
		this.method = method;
	}
	
	
}

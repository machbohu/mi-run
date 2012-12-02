package cz.cvut.fit.mirun.lemavm.exceptions;

public class VMAmbiguousMethodDeclaration extends VMParsingException {

	private static final long serialVersionUID = 6265301162984756301L;

	public VMAmbiguousMethodDeclaration() {
	}

	public VMAmbiguousMethodDeclaration(String message) {
		super(message);
	}

	public VMAmbiguousMethodDeclaration(Throwable cause) {
		super(cause);
	}

	public VMAmbiguousMethodDeclaration(String message, Throwable cause) {
		super(message, cause);
	}

	public VMAmbiguousMethodDeclaration(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

package cz.cvut.fit.mirun.lemavm.core;

/**
 * This exception is thrown when an error occurs during AST parsing.
 * 
 * @author kidney
 * 
 */
public class VMParsingException extends RuntimeException {

	private static final long serialVersionUID = 3429700937138865618L;

	public VMParsingException() {
	}

	public VMParsingException(String message) {
		super(message);
	}

	public VMParsingException(Throwable cause) {
		super(cause);
	}

	public VMParsingException(String message, Throwable cause) {
		super(message, cause);
	}

	public VMParsingException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

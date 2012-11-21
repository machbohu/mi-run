package cz.cvut.fit.mirun.lemavm.core;

/**
 * This exception is thrown when an exception occurs during AST evaluation.
 * 
 * @author kidney
 * 
 */
public class VMEvaluationException extends RuntimeException {

	private static final long serialVersionUID = -5621138938505857282L;

	public VMEvaluationException() {
	}

	public VMEvaluationException(String message) {
		super(message);
	}

	public VMEvaluationException(Throwable cause) {
		super(cause);
	}

	public VMEvaluationException(String message, Throwable cause) {
		super(message, cause);
	}

	public VMEvaluationException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

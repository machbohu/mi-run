package cz.cvut.fit.mirun.lemavm.exceptions;

public class VMOutOfMemoryException extends VMEvaluationException {

	private static final long serialVersionUID = -7199095208280568088L;

	public VMOutOfMemoryException() {
	}

	public VMOutOfMemoryException(String message) {
		super(message);
	}

	public VMOutOfMemoryException(Throwable cause) {
		super(cause);
	}

	public VMOutOfMemoryException(String message, Throwable cause) {
		super(message, cause);
	}

	public VMOutOfMemoryException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

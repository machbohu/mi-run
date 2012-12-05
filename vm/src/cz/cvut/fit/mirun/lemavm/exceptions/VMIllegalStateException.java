package cz.cvut.fit.mirun.lemavm.exceptions;

public final class VMIllegalStateException extends VMEvaluationException {

	private static final long serialVersionUID = -7589385584482932239L;

	public VMIllegalStateException() {
		super();
	}

	public VMIllegalStateException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public VMIllegalStateException(String message, Throwable cause) {
		super(message, cause);
	}

	public VMIllegalStateException(String message) {
		super(message);
	}

	public VMIllegalStateException(Throwable cause) {
		super(cause);
	}
}

package cz.cvut.fit.mirun.lemavm.exceptions;

public final class VMIOException extends VMEvaluationException {

	private static final long serialVersionUID = 1109677676707154005L;

	public VMIOException() {
	}

	public VMIOException(String message) {
		super(message);
	}

	public VMIOException(Throwable cause) {
		super(cause);
	}

	public VMIOException(String message, Throwable cause) {
		super(message, cause);
	}

	public VMIOException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

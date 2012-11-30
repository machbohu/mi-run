package cz.cvut.fit.mirun.lemavm.exceptions;

public class VMClassNotFoundException extends VMEvaluationException {

	private static final long serialVersionUID = -8435136266026554317L;

	public VMClassNotFoundException() {
	}

	public VMClassNotFoundException(String message) {
		super(message);
	}

	public VMClassNotFoundException(Throwable cause) {
		super(cause);
	}

	public VMClassNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public VMClassNotFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

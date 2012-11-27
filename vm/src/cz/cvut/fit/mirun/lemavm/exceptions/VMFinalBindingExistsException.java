package cz.cvut.fit.mirun.lemavm.exceptions;

public class VMFinalBindingExistsException extends VMEvaluationException {

	private static final long serialVersionUID = -7344128262831313621L;

	public VMFinalBindingExistsException() {
		super();
	}

	public VMFinalBindingExistsException(String message) {
		super(message);
	}

	public VMFinalBindingExistsException(Throwable cause) {
		super(cause);
	}

	public VMFinalBindingExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public VMFinalBindingExistsException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

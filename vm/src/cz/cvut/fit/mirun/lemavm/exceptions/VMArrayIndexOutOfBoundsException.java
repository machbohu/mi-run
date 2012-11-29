package cz.cvut.fit.mirun.lemavm.exceptions;

public class VMArrayIndexOutOfBoundsException extends VMEvaluationException {

	private static final long serialVersionUID = -427270857949936048L;

	public VMArrayIndexOutOfBoundsException() {
		super();
	}

	public VMArrayIndexOutOfBoundsException(String message) {
		super(message);
	}

	public VMArrayIndexOutOfBoundsException(Throwable cause) {
		super(cause);
	}

	public VMArrayIndexOutOfBoundsException(String message, Throwable cause) {
		super(message, cause);
	}

	public VMArrayIndexOutOfBoundsException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

package cz.cvut.fit.mirun.lemavm.exceptions;

public class VMMethodNotFoundException extends VMEvaluationException {

	private static final long serialVersionUID = -7390294412976730576L;

	public VMMethodNotFoundException() {
	}

	public VMMethodNotFoundException(String message) {
		super(message);
	}

	public VMMethodNotFoundException(Throwable cause) {
		super(cause);
	}

	public VMMethodNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public VMMethodNotFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

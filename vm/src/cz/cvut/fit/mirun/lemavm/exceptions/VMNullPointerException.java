package cz.cvut.fit.mirun.lemavm.exceptions;

public class VMNullPointerException extends VMEvaluationException {

	private static final long serialVersionUID = 3440258564073335157L;

	public VMNullPointerException() {
		super();
	}

	public VMNullPointerException(String message) {
		super(message);
	}

	public VMNullPointerException(Throwable cause) {
		super(cause);
	}

	public VMNullPointerException(String message, Throwable cause) {
		super(message, cause);
	}

	public VMNullPointerException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

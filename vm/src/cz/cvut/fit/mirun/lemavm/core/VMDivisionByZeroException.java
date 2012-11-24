package cz.cvut.fit.mirun.lemavm.core;

public class VMDivisionByZeroException extends VMEvaluationException {

	private static final long serialVersionUID = -4722929910746197120L;

	public VMDivisionByZeroException() {
		super();
	}

	public VMDivisionByZeroException(String message) {
		super(message);
	}

	public VMDivisionByZeroException(Throwable cause) {
		super(cause);
	}

	public VMDivisionByZeroException(String message, Throwable cause) {
		super(message, cause);
	}

	public VMDivisionByZeroException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

package cz.cvut.fit.mirun.lemavm.exceptions;

public class VMUnknownTypeException extends VMEvaluationException {

	private static final long serialVersionUID = -5638478362641157900L;

	public VMUnknownTypeException() {
	}

	public VMUnknownTypeException(String message) {
		super(message);
	}

	public VMUnknownTypeException(Throwable cause) {
		super(cause);
	}

	public VMUnknownTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public VMUnknownTypeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

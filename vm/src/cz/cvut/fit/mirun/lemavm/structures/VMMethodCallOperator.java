package cz.cvut.fit.mirun.lemavm.structures;

import java.util.List;

import cz.cvut.fit.mirun.lemavm.core.VMInterpreter;
import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;

/**
 * This class represents a method call operator. When it is evaluated, the
 * method is invoked.
 * 
 * @author kidney
 * 
 */
public final class VMMethodCallOperator implements Evaluable {

	// TODO Add this operator to the rest of the operators.

	private final String receiver;
	private final String methodName;
	private final List<Object> arguments;

	public VMMethodCallOperator(String receiver, String methodName,
			List<Object> arguments) {
		if (methodName == null || methodName.isEmpty() || arguments == null) {
			throw new VMParsingException(
					"Illegal arguments passed to MethodCallOperator constructor. Method name = "
							+ methodName + ", args = " + arguments);
		}
		if (receiver != null) {
			this.receiver = receiver;
		} else {
			this.receiver = VMConstants.THIS;
		}
		this.methodName = methodName;
		this.arguments = arguments;
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		final VMObject recv = env.getBinding(receiver, VMObject.class);
		if (recv == null) {
			throw new VMEvaluationException("Receiver " + receiver
					+ " of the method call " + methodName
					+ " not found in this environment.");
		}
		return VMInterpreter.getInstance().invokeMethod(recv, methodName,
				arguments);
	}

	@Override
	public String toString() {
		String out = "MethodCall: receiver = " + receiver + ", method name = "
				+ methodName;
		return out;
	}
}

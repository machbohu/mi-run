package cz.cvut.fit.mirun.lemavm.structures.operators;

import java.util.List;

import cz.cvut.fit.mirun.lemavm.core.VMInterpreter;
import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.Evaluable;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMClass;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;

/**
 * This class represents a method call operator. When it is evaluated, the
 * method is invoked.
 * 
 * @author kidney
 * 
 */
public final class VMMethodCallOperator extends VMOperator {

	private final Object receiver;
	private final String methodName;
	private final List<Object> arguments;

	public VMMethodCallOperator(Object receiver, String methodName,
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
		VMObject recv = null;
		if (receiver instanceof Evaluable) {
			// support for e. g. items[i].methodCall()
			recv = (VMObject) ((Evaluable) receiver).evaluate(env);
		} else {
			if (!(receiver instanceof String)) {
				throw new VMEvaluationException(
						"Unsupported method call receiver type. Receiver: "
								+ receiver);
			}
			recv = env.getBinding((String) receiver, VMObject.class);
		}
		if (recv == null) {
			if (receiver.equals(VMConstants.SYSTEM)) {
				return VMInterpreter.getInstance().invokeSystemNativeMethod(
						methodName, arguments);
			}
			final VMClass cls = VMClass.getClasses().get(receiver);
			if (cls != null) {
				return VMInterpreter.getInstance().invokeStaticMethod(cls,
						methodName, arguments);
			}
			throw new VMEvaluationException("Receiver '" + receiver
					+ "' of the method call '" + methodName
					+ "' not found in this environment.");
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

	@Override
	public Double evaluateDouble(VMEnvironment env) {
		Object res = evaluate(env);
		try {
			final Number n = (Number) res;
			return Double.valueOf(n.doubleValue());
		} catch (ClassCastException e) {
			throw new VMEvaluationException(
					"The return value of invocation of " + methodName
							+ " cannot be cast to double.");
		}
	}

	@Override
	public Long evaluateLong(VMEnvironment env) {
		Object res = evaluate(env);
		try {
			final Number n = (Number) res;
			return Long.valueOf(n.longValue());
		} catch (ClassCastException e) {
			throw new VMEvaluationException(
					"The return value of invocation of " + methodName
							+ " cannot be cast to long.");
		}
	}

	@Override
	public Integer evaluateInt(VMEnvironment env) {
		Object res = evaluate(env);
		try {
			final Number n = (Number) res;
			return Integer.valueOf(n.intValue());
		} catch (ClassCastException e) {
			throw new VMEvaluationException(
					"The return value of invocation of " + methodName
							+ " cannot be cast to int.");
		}
	}

	@Override
	public Short evaluateShort(VMEnvironment env) {
		Object res = evaluate(env);
		try {
			final Number n = (Number) res;
			return Short.valueOf(n.shortValue());
		} catch (ClassCastException e) {
			throw new VMEvaluationException(
					"The return value of invocation of " + methodName
							+ " cannot be cast to short.");
		}
	}

	@Override
	public Boolean evaluateBoolean(VMEnvironment env) {
		Object res = evaluate(env);
		try {
			Boolean b = (Boolean) res;
			return b;
		} catch (ClassCastException e) {
			throw new VMEvaluationException(
					"The return value of invocation of " + methodName
							+ " cannot be cast to boolean.");
		}
	}

	@Override
	public VMString evaluateString(VMEnvironment env) {
		Object res = evaluate(env);
		try {
			if (res instanceof VMString) {
				return (VMString) res;
			} else {
				return new VMString(res.toString());
			}
		} catch (ClassCastException e) {
			throw new VMEvaluationException(
					"The return value of invocation of " + methodName
							+ " cannot be cast to VMString.");
		}
	}
}

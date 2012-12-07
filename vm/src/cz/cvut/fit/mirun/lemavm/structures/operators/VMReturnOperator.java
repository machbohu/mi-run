package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.Evaluable;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMNull;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMClass;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.ParsingUtils;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;
import cz.cvut.fit.mirun.lemavm.utils.VMUtils;

public final class VMReturnOperator implements Evaluable {

	private final Object expr;

	public VMReturnOperator(Object expr) {
		this.expr = expr;
	}

	@Override
	public Object evaluate(VMEnvironment env) {
		final String retType = env.getReturnType();
		if (retType.equals(VMConstants.VOID)) {
			if (expr == null) {
				return null;
			} else {
				throw new VMEvaluationException(
						"Method with return type \'void\' cannot return a value.");
			}
		}
		if (expr == null) {
			throw new VMEvaluationException("Metod with return type " + retType
					+ " must return a value.");
		}
		Object res = null;
		if (expr instanceof Evaluable) {
			res = ((Evaluable) expr).evaluate(env);
		} else if (expr instanceof String) {
			final String s = (String) expr;
			if (s.startsWith("\"")) {
				res = s.substring(1, s.length() - 1);
			} else {
				if (s.equals(VMConstants.NULL)) {
					res = VMNull.getInstance();
				} else {
					Boolean b = ParsingUtils.tryParsingBoolean(s);
					if (b != null) {
						res = b;
					} else {
						Number n = ParsingUtils.tryParsingNumber(s);
						if (n != null) {
							res = n;
						} else {
							res = env.getBinding(s, Object.class);
						}
					}
				}
			}
		} else {
			throw new VMEvaluationException(
					"Unsupported argument for File constructor. Argument: "
							+ expr);
		}
		checkTypeCompatibility(retType, res);
		env.setReturnValue(res);
		return null;
	}

	private void checkTypeCompatibility(String type, Object value) {
		if (VMUtils.isTypePrimitive(type)) {
			if (!type.equals(value.getClass().getSimpleName().toLowerCase())) {
				throw new VMEvaluationException("Incompatible types. Expected "
						+ type + ", but got "
						+ value.getClass().getSimpleName());
			} else {
				return;
			}
		}
		assert (value instanceof VMObject);
		final VMObject o = (VMObject) value;
		final VMClass decl = VMClass.getClasses().get(type);
		final VMClass runtime = VMClass.getClasses().get(o.getTypeName());
		if (!decl.isAssignableFrom(runtime)) {
			throw new VMEvaluationException("Incompatible types. Expected "
					+ type + ", but got " + runtime.getName());
		}
	}
}

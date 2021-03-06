package cz.cvut.fit.mirun.lemavm.structures.operators;

import org.apache.log4j.Logger;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.Evaluable;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

/**
 * Base class for operators. It just defines the type. </p>
 * 
 * @author kidney
 * 
 */
public abstract class VMOperator implements Evaluable {

	protected static final Logger LOG = Logger.getLogger(VMOperator.class);

	protected ObjectType returnType;

	public VMOperator() {
		super();
	}

	/**
	 * Evaluate this operator and return result
	 * 
	 * @return Double
	 */
	public abstract Double evaluateDouble(VMEnvironment env);

	/**
	 * Evaluate this operator and return result
	 * 
	 * @return Long
	 */
	public abstract Long evaluateLong(VMEnvironment env);

	/**
	 * Evaluate this operator and return result
	 * 
	 * @return Integer
	 */
	public abstract Integer evaluateInt(VMEnvironment env);

	/**
	 * Evaluate this operator and return result
	 * 
	 * @return Short
	 */
	public abstract Short evaluateShort(VMEnvironment env);

	/**
	 * Evaluate this operator and return result
	 * 
	 * @return Boolean
	 */
	public abstract Boolean evaluateBoolean(VMEnvironment env);

	/**
	 * Evaluate this operator and return result
	 * 
	 * @return VMString
	 */
	public abstract VMString evaluateString(VMEnvironment env);

	public ObjectType getReturnType() {
		return returnType;
	}

	public void setReturnType(ObjectType returnType) {
		this.returnType = returnType;
	}

	protected <T> T getBindingValue(String name, Class<T> type,
			VMEnvironment env) {
		try {
			T n = env.getBinding(name, type);
			if (n == null) {
				throw new VMEvaluationException("Variable with name '" + name
						+ "' not found.");
			}
			return n;
		} catch (ClassCastException e) {
			throw new VMEvaluationException(
					"Incompatible types in operator. Expected "
							+ type.getName() + ", but got "
							+ env.getNameType(name));
		}
	}
}

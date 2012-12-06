package cz.cvut.fit.mirun.lemavm.assignment;

import org.apache.log4j.Logger;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMUnknownTypeException;
import cz.cvut.fit.mirun.lemavm.structures.Evaluable;
import cz.cvut.fit.mirun.lemavm.structures.VMArray;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMClass;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.utils.VMConstants;
import cz.cvut.fit.mirun.lemavm.utils.VMUtils;

public abstract class VMAssignOperator implements Evaluable {

	protected static final Logger LOG = Logger
			.getLogger(VMAssignOperator.class);

	protected final String name;
	protected String type;
	protected final boolean isFinal;

	public VMAssignOperator(String name, String type, boolean isFinal) {
		if (name == null) {
			throw new NullPointerException();
		}
		this.name = name;
		// Type can be null if it is assignment to already existing name
		this.type = type;
		this.isFinal = isFinal;
	}

	protected void resolveType(VMEnvironment env) {
		if (type == null) {
			// This is an assignment into an existing variable
			type = env.getNameType(name);
			if (type == null) {
				throw new VMEvaluationException(
						"Assignment to a name without any declared type.");
			}
		}
	}

	protected void checkPrimitiveTypeCompatibility(String declType,
			String runtimeType) {
		assert declType != null;
		assert runtimeType != null;
		switch (runtimeType) {
		case VMConstants.SHORT:
			checkShort(declType);
			break;
		case VMConstants.INT:
			checkInt(declType);
			break;
		case VMConstants.LONG:
			checkLong(declType);
			break;
		case VMConstants.DOUBLE:
			if (!declType.equals(VMConstants.DOUBLE)) {
				throw new VMEvaluationException(
						"Incompatible types in assigment. Expected " + declType
								+ ", but got double");
			}
			break;
		case VMConstants.BOOLEAN:
			if (!declType.equals(VMConstants.BOOLEAN)) {
				throw new VMEvaluationException(
						"Incompatible types in assigment. Expected " + declType
								+ ", but got boolean");
			}
			break;
		default:
			throw new VMEvaluationException(
					"Expected a primitive type, but got " + runtimeType);
		}
	}

	protected void checkReferenceTypeCompatibility(String declType,
			String runtimeType, Object value) {
		assert declType != null;
		assert runtimeType != null;
		switch (runtimeType) {
		case VMConstants.STRING:
			if (!declType.equals(VMConstants.STRING)) {
				throw new VMEvaluationException(
						"Incompatible types in assigment. Expected " + declType
								+ ", but got " + runtimeType);
			}
			break;
		case VMConstants.ARRAY:
			final VMArray<?> arr = (VMArray<?>) value;
			checkArrayElementType(declType, arr.getElementTypeName());
			break;
		case VMConstants.NULL:
			// Null can be assigned to any reference type
			break;
		default:
			// Check class compatibility
			checkClassTypes(declType, runtimeType);
		}

	}

	private void checkShort(String declType) {
		switch (declType) {
		case VMConstants.DOUBLE:
		case VMConstants.LONG:
		case VMConstants.INT:
		case VMConstants.SHORT:
			break;
		default:
			throw new VMEvaluationException(
					"Incompatible types in assigment. Expected " + declType
							+ ", but got short");
		}
	}

	private void checkInt(String declType) {
		switch (declType) {
		case VMConstants.DOUBLE:
		case VMConstants.LONG:
		case VMConstants.INT:
			break;
		default:
			throw new VMEvaluationException(
					"Incompatible types in assigment. Expected " + declType
							+ ", but got int");
		}
	}

	private void checkLong(String declType) {
		switch (declType) {
		case VMConstants.DOUBLE:
		case VMConstants.LONG:
			break;
		default:
			throw new VMEvaluationException(
					"Incompatible types in assigment. Expected " + declType
							+ ", but got long");
		}
	}

	private void checkArrayElementType(String declType, String runtimeType) {
		String elemType = declType.substring(0, declType.indexOf("["));
		elemType = elemType.trim();
		if (VMUtils.isTypePrimitive(declType) && !elemType.equals(runtimeType)) {
			throw new VMEvaluationException(
					"Incompatible types in array assignment. Expected "
							+ elemType + ", but got " + runtimeType);
		} else {
			checkClassTypes(elemType, runtimeType);
		}
	}

	private void checkClassTypes(String elemType, String runtimeType) {
		VMClass decl = VMClass.getClasses().get(elemType);
		if (decl == null) {
			throw new VMUnknownTypeException(elemType);
		}
		VMClass runt = VMClass.getClasses().get(runtimeType);
		if (runt == null) {
			throw new VMUnknownTypeException(runtimeType);
		}
		if (!decl.isAssignableFrom(runt)) {
			throw new VMEvaluationException(
					"Incompatible types in assigment. Expected " + elemType
							+ ", but got " + runtimeType);
		}
	}
}

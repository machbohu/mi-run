package cz.cvut.fit.mirun.lemavm.assignment;

import org.apache.log4j.Logger;

import cz.cvut.fit.mirun.lemavm.core.VMConstants;
import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

public abstract class VMAssignOperator {

	protected static final Logger LOG = Logger
			.getLogger(VMAssignOperator.class);

	protected final String name;
	protected String type;
	protected final VMEnvironment environment;
	protected final boolean isFinal;

	public VMAssignOperator(String name, String type,
			VMEnvironment environment, boolean isFinal) {
		if (name == null || environment == null) {
			throw new NullPointerException();
		}
		this.name = name;
		// Type can be null if it is assignment to already existing name
		this.type = type;
		this.environment = environment;
		this.isFinal = isFinal;
	}

	/**
	 * Evaluate this assignment.
	 */
	public abstract void evaluate();

	protected void resolveType() {
		if (type == null) {
			// This is an assignment into an existing variable
			type = environment.getNameType(name);
			if (type == null) {
				throw new VMEvaluationException(
						"Assignment to a name without any declared type.");
			}
		}
	}

	protected void checkTypeCompatibility(String declType, String runtimeType) {
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
		case VMConstants.STRING:
			if (!declType.equals(VMConstants.STRING)
					&& !declType.equals(VMConstants.NULL)) {
				throw new VMEvaluationException(
						"Incompatible types in assigment. Expected " + declType
								+ ", but got string");
			}
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
}
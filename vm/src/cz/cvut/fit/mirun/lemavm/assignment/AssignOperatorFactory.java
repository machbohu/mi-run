package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMNull;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class AssignOperatorFactory {

	public VMAssignOperator createOperator(String name, String type,
			VMEnvironment environment, boolean isFinal, double value) {
		return new VMAssignDouble(name, type, environment, isFinal, value);
	}

	public VMAssignOperator createOperator(String name, String type,
			VMEnvironment environment, boolean isFinal, long value) {
		return new VMAssignLong(name, type, environment, isFinal, value);
	}

	public VMAssignOperator createOperator(String name, String type,
			VMEnvironment environment, boolean isFinal, int value) {
		return new VMAssignInt(name, type, environment, isFinal, value);
	}

	public VMAssignOperator createOperator(String name, String type,
			VMEnvironment environment, boolean isFinal, short value) {
		return new VMAssignShort(name, type, environment, isFinal, value);
	}

	public VMAssignOperator createOperator(String name, String type,
			VMEnvironment environment, boolean isFinal, boolean value) {
		return new VMAssignBoolean(name, type, environment, isFinal, value);
	}

	public VMAssignOperator createOperator(String name, String type,
			VMEnvironment environment, boolean isFinal, VMString value) {
		return new VMAssignString(name, type, environment, isFinal, value);
	}

	public VMAssignOperator createOperator(String name, String type,
			VMEnvironment environment, boolean isFinal, VMOperator value) {
		return new VMAssignExpr(name, type, environment, isFinal, value);
	}

	public VMAssignOperator createOperator(String name, String type,
			VMEnvironment environment, boolean isFinal, VMNull value) {
		return new VMAssignNull(name, type, environment, isFinal, value);
	}

	public VMAssignOperator createOperator(String name, String type,
			VMEnvironment environment, boolean isFinal, VMObject value) {
		return new VMAssignReference(name, type, environment, isFinal, value);
	}
}

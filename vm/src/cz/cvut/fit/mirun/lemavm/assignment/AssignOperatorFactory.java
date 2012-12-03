package cz.cvut.fit.mirun.lemavm.assignment;

import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMNull;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class AssignOperatorFactory {

	// TODO Create unified API like for the Binary and Unary operators

	public VMAssignOperator createOperator(String name, String type,
			boolean isFinal, double value) {
		return new VMAssignDouble(name, type, isFinal, value);
	}

	public VMAssignOperator createOperator(String name, String type,
			boolean isFinal, long value) {
		return new VMAssignLong(name, type, isFinal, value);
	}

	public VMAssignOperator createOperator(String name, String type,
			boolean isFinal, int value) {
		return new VMAssignInt(name, type, isFinal, value);
	}

	public VMAssignOperator createOperator(String name, String type,
			boolean isFinal, short value) {
		return new VMAssignShort(name, type, isFinal, value);
	}

	public VMAssignOperator createOperator(String name, String type,
			boolean isFinal, boolean value) {
		return new VMAssignBoolean(name, type, isFinal, value);
	}

	public VMAssignOperator createOperator(String name, String type,
			boolean isFinal, VMString value) {
		return new VMAssignString(name, type, isFinal, value);
	}

	public VMAssignOperator createOperator(String name, String type,
			boolean isFinal, VMOperator value) {
		return new VMAssignExpr(name, type, isFinal, value);
	}

	public VMAssignOperator createOperator(String name, String type,
			boolean isFinal, VMNull value) {
		return new VMAssignNull(name, type, isFinal, value);
	}

	public VMAssignOperator createOperator(String name, String type,
			boolean isFinal, VMObject value) {
		return new VMAssignReference(name, type, isFinal, value);
	}
}

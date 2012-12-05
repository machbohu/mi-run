package cz.cvut.fit.mirun.lemavm.structures.operators.factories;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.structures.operators.division.CompNumberBinaryDivision;
import cz.cvut.fit.mirun.lemavm.structures.operators.division.CompVariableBinaryDivision;
import cz.cvut.fit.mirun.lemavm.structures.operators.division.NumberCompBinaryDivision;
import cz.cvut.fit.mirun.lemavm.structures.operators.division.NumberNumberBinaryDivision;
import cz.cvut.fit.mirun.lemavm.structures.operators.division.NumberVariableBinaryDivision;
import cz.cvut.fit.mirun.lemavm.structures.operators.division.VMCompoundDivision;
import cz.cvut.fit.mirun.lemavm.structures.operators.division.VariableCompBinaryDivision;
import cz.cvut.fit.mirun.lemavm.structures.operators.division.VariableNumberBinaryDivision;
import cz.cvut.fit.mirun.lemavm.structures.operators.division.VariableVariableBinaryDivision;

public final class VMDivisionOperatorFactory extends VMBinaryOperatorFactory {

	@Override
	protected VMOperator createOperator(VMOperator opOne, VMOperator opTwo) {
		return new VMCompoundDivision(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(VMOperator opOne, Number opTwo) {
		return new CompNumberBinaryDivision(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(Number opOne, VMOperator opTwo) {
		return new NumberCompBinaryDivision(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(Number opOne, Number opTwo) {
		return new NumberNumberBinaryDivision(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(String opOne, VMOperator opTwo) {
		return new VariableCompBinaryDivision(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(VMOperator opOne, String opTwo) {
		return new CompVariableBinaryDivision(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(String opOne, Number opTwo) {
		return new VariableNumberBinaryDivision(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(Number opOne, String opTwo) {
		return new NumberVariableBinaryDivision(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(String opOne, String opTwo) {
		return new VariableVariableBinaryDivision(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(String opOne, VMString opTWo) {
		throw new VMParsingException("Operator / is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	protected VMOperator createOperator(VMString opOne, String opTwo) {
		throw new VMParsingException("Operator / is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	protected VMOperator createOperator(VMString opOne, VMOperator opTwo) {
		throw new VMParsingException("Operator / is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	protected VMOperator createOperator(VMOperator opOne, VMString opTwo) {
		throw new VMParsingException("Operator / is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	protected VMOperator createOperator(VMString opOne, Number opTwo) {
		throw new VMParsingException("Operator / is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	protected VMOperator createOperator(Number opOne, VMString opTWo) {
		throw new VMParsingException("Operator / is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	protected VMOperator createOperator(VMString opOne, VMString opTwo) {
		throw new VMParsingException("Operator / is not applicable for type "
				+ VMString.class.getName());
	}
}

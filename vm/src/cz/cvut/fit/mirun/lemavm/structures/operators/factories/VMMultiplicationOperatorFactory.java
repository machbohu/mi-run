package cz.cvut.fit.mirun.lemavm.structures.operators.factories;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.structures.operators.multiplication.CompNumberBinaryMultiplication;
import cz.cvut.fit.mirun.lemavm.structures.operators.multiplication.CompVariableBinaryMultiplication;
import cz.cvut.fit.mirun.lemavm.structures.operators.multiplication.NumberCompBinaryMultiplication;
import cz.cvut.fit.mirun.lemavm.structures.operators.multiplication.NumberNumberBinaryMultiplication;
import cz.cvut.fit.mirun.lemavm.structures.operators.multiplication.NumberVariableBinaryMultiplication;
import cz.cvut.fit.mirun.lemavm.structures.operators.multiplication.VMCompoundMultiplication;
import cz.cvut.fit.mirun.lemavm.structures.operators.multiplication.VariableCompBinaryMultiplication;
import cz.cvut.fit.mirun.lemavm.structures.operators.multiplication.VariableNumberBinaryMultiplication;
import cz.cvut.fit.mirun.lemavm.structures.operators.multiplication.VariableVariableBinaryMultiplication;

public final class VMMultiplicationOperatorFactory extends
		VMBinaryOperatorFactory {

	@Override
	protected VMOperator createOperator(VMOperator opOne, VMOperator opTwo) {
		return new VMCompoundMultiplication(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(VMOperator opOne, Number opTwo) {
		return new CompNumberBinaryMultiplication(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(Number opOne, VMOperator opTwo) {
		return new NumberCompBinaryMultiplication(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(Number opOne, Number opTwo) {
		return new NumberNumberBinaryMultiplication(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(String opOne, VMOperator opTwo) {
		return new VariableCompBinaryMultiplication(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(VMOperator opOne, String opTwo) {
		return new CompVariableBinaryMultiplication(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(String opOne, Number opTwo) {
		return new VariableNumberBinaryMultiplication(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(Number opOne, String opTwo) {
		return new NumberVariableBinaryMultiplication(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(String opOne, String opTwo) {
		return new VariableVariableBinaryMultiplication(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(String opOne, VMString opTWo) {
		throw new VMParsingException("Operator * is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	protected VMOperator createOperator(VMString opOne, String opTwo) {
		throw new VMParsingException("Operator * is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	protected VMOperator createOperator(VMString opOne, VMOperator opTwo) {
		throw new VMParsingException("Operator * is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	protected VMOperator createOperator(VMOperator opOne, VMString opTwo) {
		throw new VMParsingException("Operator * is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	protected VMOperator createOperator(VMString opOne, Number opTwo) {
		throw new VMParsingException("Operator * is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	protected VMOperator createOperator(Number opOne, VMString opTWo) {
		throw new VMParsingException("Operator * is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	protected VMOperator createOperator(VMString opOne, VMString opTwo) {
		throw new VMParsingException("Operator * is not applicable for type "
				+ VMString.class.getName());
	}
}

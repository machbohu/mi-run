package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.operators.compounds.VMCompoundMinus;
import cz.cvut.fit.mirun.lemavm.structures.operators.minus.CompNumberBinaryMinus;
import cz.cvut.fit.mirun.lemavm.structures.operators.minus.CompVariableBinaryMinus;
import cz.cvut.fit.mirun.lemavm.structures.operators.minus.NumberCompBinaryMinus;
import cz.cvut.fit.mirun.lemavm.structures.operators.minus.NumberNumberBinaryMinus;
import cz.cvut.fit.mirun.lemavm.structures.operators.minus.NumberVariableBinaryMinus;
import cz.cvut.fit.mirun.lemavm.structures.operators.minus.VariableCompBinaryMinus;
import cz.cvut.fit.mirun.lemavm.structures.operators.minus.VariableNumberBinaryMinus;
import cz.cvut.fit.mirun.lemavm.structures.operators.minus.VariableVariableBinaryMinus;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

public final class VMBinaryMinusOperatorFactory extends VMBinaryOperatorFactory {

	@Override
	protected VMOperator createOperator(VMOperator opOne, VMOperator opTwo) {
		return new VMCompoundMinus(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(VMOperator opOne, Number opTwo) {
		return new CompNumberBinaryMinus(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(Number opOne, VMOperator opTwo) {
		return new NumberCompBinaryMinus(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(Number opOne, Number opTwo) {
		return new NumberNumberBinaryMinus(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(VMString opOne, VMOperator opTwo) {
		throw new VMParsingException("Operator - is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	protected VMOperator createOperator(VMOperator opOne, VMString opTwo) {
		throw new VMParsingException("Operator - is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	protected VMOperator createOperator(VMString opOne, Number opTwo) {
		throw new VMParsingException("Operator - is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	protected VMOperator createOperator(Number opOne, VMString opTWo) {
		throw new VMParsingException("Operator - is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	protected VMOperator createOperator(VMString opOne, VMString opTwo) {
		throw new VMParsingException("Operator - is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	protected VMOperator createOperator(String opOne, VMOperator opTwo) {
		return new VariableCompBinaryMinus(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(VMOperator opOne, String opTwo) {
		return new CompVariableBinaryMinus(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(String opOne, Number opTwo) {
		return new VariableNumberBinaryMinus(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(Number opOne, String opTwo) {
		return new NumberVariableBinaryMinus(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(String opOne, String opTwo) {
		return new VariableVariableBinaryMinus(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(String opOne, VMString opTWo) {
		throw new VMParsingException("Operator - is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	protected VMOperator createOperator(VMString opOne, String opTwo) {
		throw new VMParsingException("Operator - is not applicable for type "
				+ VMString.class.getName());
	}
}

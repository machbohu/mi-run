package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.operators.compounds.VMCompoundDivide;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

public final class VMDivideOperatorFactory implements VMBinaryOperatorFactory {

	@Override
	public VMOperator createOperator(VMOperator opOne, VMOperator opTwo) {
		return new VMCompoundDivide(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(VMOperator opOne, Number opTwo) {
		throw new VMParsingException("Operator / is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	public VMOperator createOperator(Number opOne, VMOperator opTwo) {
		throw new VMParsingException("Operator / is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	public VMOperator createOperator(Number opOne, Number opTwo) {
		throw new VMParsingException("Operator / is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	public VMOperator createOperator(VMString opOne, VMOperator opTwo) {
		throw new VMParsingException("Operator / is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	public VMOperator createOperator(VMOperator opOne, VMString opTwo) {
		throw new VMParsingException("Operator / is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	public VMOperator createOperator(VMString opOne, Number opTwo) {
		throw new VMParsingException("Operator / is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	public VMOperator createOperator(Number opOne, VMString opTWo) {
		throw new VMParsingException("Operator / is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	public VMOperator createOperator(VMString opOne, VMString opTwo) {
		throw new VMParsingException("Operator / is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	public VMOperator createOperator(String opOne, VMOperator opTwo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VMOperator createOperator(VMOperator opOne, String opTwo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VMOperator createOperator(String opOne, Number opTwo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VMOperator createOperator(Number opOne, String opTwo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VMOperator createOperator(String opOne, String opTwo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VMOperator createOperator(String opOne, VMString opTWo) {
		throw new VMParsingException("Operator / is not applicable for type "
				+ VMString.class.getName());
	}

	@Override
	public VMOperator createOperator(VMString opOne, String opTwo) {
		throw new VMParsingException("Operator / is not applicable for type "
				+ VMString.class.getName());
	}
}

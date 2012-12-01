package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.structures.operators.compounds.VMCompoundPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.plus.NumberCompBinaryPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.plus.NumberNumberBinaryPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.plus.VariableCompBinaryPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.plus.VariableNumberBinaryPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.plus.VariableVariableBinaryPlus;
import cz.cvut.fit.mirun.lemavm.structures.primitives.VMString;

public final class VMBinaryPlusOperatorFactory implements
		VMBinaryOperatorFactory {

	@Override
	public VMOperator createOperator(VMOperator opOne, VMOperator opTwo) {
		return new VMCompoundPlus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(VMOperator opOne, Number opTwo) {
		return createOperator(opTwo, opOne);
	}

	@Override
	public VMOperator createOperator(Number opOne, VMOperator opTwo) {
		return new NumberCompBinaryPlus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(Number opOne, Number opTwo) {
		return new NumberNumberBinaryPlus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(VMString opOne, VMOperator opTwo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VMOperator createOperator(VMOperator opOne, VMString opTwo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VMOperator createOperator(VMString opOne, Number opTwo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VMOperator createOperator(Number opOne, VMString opTWo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VMOperator createOperator(VMString opOne, VMString opTwo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VMOperator createOperator(String opOne, VMOperator opTwo) {
		return new VariableCompBinaryPlus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(VMOperator opOne, String opTwo) {
		return createOperator(opTwo, opOne);
	}

	@Override
	public VMOperator createOperator(String opOne, Number opTwo) {
		return new VariableNumberBinaryPlus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(Number opOne, String opTwo) {
		return createOperator(opTwo, opOne);
	}

	@Override
	public VMOperator createOperator(String opOne, String opTwo) {
		return new VariableVariableBinaryPlus(opOne, opTwo);
	}

	@Override
	public VMOperator createOperator(String opOne, VMString opTWo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VMOperator createOperator(VMString opOne, String opTwo) {
		// TODO Auto-generated method stub
		return null;
	}
}

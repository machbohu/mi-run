package cz.cvut.fit.mirun.lemavm.structures.operators;

import cz.cvut.fit.mirun.lemavm.structures.builtin.VMString;
import cz.cvut.fit.mirun.lemavm.structures.operators.plus.CompVMStringBinaryPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.plus.NumberCompBinaryPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.plus.NumberNumberBinaryPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.plus.NumberVMStringBinaryPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.plus.VMCompoundPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.plus.VMStringCompBinaryPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.plus.VMStringNumberBinaryPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.plus.VMStringVMStringBinaryPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.plus.VMStringVariableBinaryPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.plus.VariableCompBinaryPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.plus.VariableNumberBinaryPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.plus.VariableVMStringBinaryPlus;
import cz.cvut.fit.mirun.lemavm.structures.operators.plus.VariableVariableBinaryPlus;

public final class VMBinaryPlusOperatorFactory extends VMBinaryOperatorFactory {

	@Override
	protected VMOperator createOperator(VMOperator opOne, VMOperator opTwo) {
		return new VMCompoundPlus(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(VMOperator opOne, Number opTwo) {
		return createOperator(opTwo, opOne);
	}

	@Override
	protected VMOperator createOperator(Number opOne, VMOperator opTwo) {
		return new NumberCompBinaryPlus(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(Number opOne, Number opTwo) {
		return new NumberNumberBinaryPlus(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(VMString opOne, VMOperator opTwo) {
		return new VMStringCompBinaryPlus(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(VMOperator opOne, VMString opTwo) {
		return new CompVMStringBinaryPlus(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(VMString opOne, Number opTwo) {
		return new VMStringNumberBinaryPlus(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(Number opOne, VMString opTwo) {
		return new NumberVMStringBinaryPlus(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(VMString opOne, VMString opTwo) {
		return new VMStringVMStringBinaryPlus(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(String opOne, VMOperator opTwo) {
		return new VariableCompBinaryPlus(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(VMOperator opOne, String opTwo) {
		return createOperator(opTwo, opOne);
	}

	@Override
	protected VMOperator createOperator(String opOne, Number opTwo) {
		return new VariableNumberBinaryPlus(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(Number opOne, String opTwo) {
		return createOperator(opTwo, opOne);
	}

	@Override
	protected VMOperator createOperator(String opOne, String opTwo) {
		return new VariableVariableBinaryPlus(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(String opOne, VMString opTwo) {
		return new VariableVMStringBinaryPlus(opOne, opTwo);
	}

	@Override
	protected VMOperator createOperator(VMString opOne, String opTwo) {
		return new VMStringVariableBinaryPlus(opOne, opTwo);
	}
}

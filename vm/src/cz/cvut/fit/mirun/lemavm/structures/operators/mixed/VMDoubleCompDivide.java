package cz.cvut.fit.mirun.lemavm.structures.operators.mixed;

import cz.cvut.fit.mirun.lemavm.exceptions.VMDivisionByZeroException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class VMDoubleCompDivide extends VMBinaryDoubleCompOperator {

	public VMDoubleCompDivide(double opOne, VMOperator opTwo) {
		super(opOne, opTwo);
	}

	public VMDoubleCompDivide(VMOperator opOne, double opTwo) {
		super(opOne, opTwo);
	}

	@Override
	public double evaluateDouble() {
		if (operOne != null) {
			double d = operOne.evaluateDouble();
			return (d / opTwo);
		} else {
			double d = operTwo.evaluateDouble();
			return opOne / d;
		}
	}

	@Override
	public long evaluateLong() {
		if (operOne != null) {
			double d = operOne.evaluateDouble();
			if (opTwo == 0) {
				throw new VMDivisionByZeroException();
			}
			return (long) (d / opTwo);
		} else {
			double d = operTwo.evaluateDouble();
			if (d == 0) {
				throw new VMDivisionByZeroException();
			}
			return (long) (opOne / d);
		}
	}

	@Override
	public int evaluateInt() {
		if (operOne != null) {
			double d = operOne.evaluateDouble();
			if (opTwo == 0) {
				throw new VMDivisionByZeroException();
			}
			return (int) (d / opTwo);
		} else {
			double d = operTwo.evaluateDouble();
			if (d == 0) {
				throw new VMDivisionByZeroException();
			}
			return (int) (opOne / d);
		}
	}

	@Override
	public short evaluateShort() {
		if (operOne != null) {
			double d = operOne.evaluateDouble();
			if (opTwo == 0) {
				throw new VMDivisionByZeroException();
			}
			return (short) (d / opTwo);
		} else {
			double d = operTwo.evaluateDouble();
			if (d == 0) {
				throw new VMDivisionByZeroException();
			}
			return (short) (opOne / d);
		}
	}

	@Override
	public boolean evaluateBoolean() {
		throw new VMEvaluationException("Operator cannot return boolean value.");
	}

	@Override
	public String evaluateString() {
		return ("" + opOne + " / " + opTwo);
	}
}

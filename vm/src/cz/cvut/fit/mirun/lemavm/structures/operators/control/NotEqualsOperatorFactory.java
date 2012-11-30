package cz.cvut.fit.mirun.lemavm.structures.operators.control;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class NotEqualsOperatorFactory {

	/**
	 * Create equality operator.
	 */
	public VMRelationalOperator createNotEqualsOperator(double opOne,
			double opTwo) {
		return new DoubleNotEquals(opOne, opTwo);
	}

	/**
	 * Create equality operator.
	 */
	public VMRelationalOperator createNotEqualsOperator(long opOne, long opTwo) {
		return new LongNotEquals(opOne, opTwo);
	}

	/**
	 * Create equality operator.
	 */
	public VMRelationalOperator createNotEqualsOperator(boolean opOne,
			boolean opTwo) {
		return new BooleanNotEquals(opOne, opTwo);
	}

	/**
	 * Create equality operator.
	 */
	public VMRelationalOperator createNotEqualsOperator(double opOne,
			VMOperator opTwo) {
		return new DoubleCompNotEquals(opOne, opTwo);
	}

	/**
	 * Create equality operator.
	 */
	public VMRelationalOperator createNotEqualsOperator(long opOne,
			VMOperator opTwo) {
		return new LongCompNotEquals(opOne, opTwo);
	}

	/**
	 * Create equality operator.
	 */
	public VMRelationalOperator createNotEqualsOperator(boolean opOne,
			VMOperator opTwo) {
		return new BooleanCompNotEquals(opOne, opTwo);
	}

	/**
	 * Create equality operator.
	 */
	public VMRelationalOperator createNotEqualsOperator(VMOperator opOne,
			double opTwo) {
		return createNotEqualsOperator(opTwo, opOne);
	}

	/**
	 * Create equality operator.
	 */
	public VMRelationalOperator createNotEqualsOperator(VMOperator opOne,
			long opTwo) {
		return createNotEqualsOperator(opTwo, opOne);
	}

	/**
	 * Create equality operator.
	 */
	public VMRelationalOperator createNotEqualsOperator(VMOperator opOne,
			boolean opTwo) {
		return new BooleanCompNotEquals(opTwo, opOne);
	}

	/**
	 * Create equality operator.
	 */
	public VMRelationalOperator createNotEqualsOperator(VMOperator opOne,
			VMOperator opTwo) {
		return new VMOperatorNotEquals(opOne, opTwo);
	}

	/**
	 * Create equality operator.
	 */
	public VMRelationalOperator createNotEqualsOperator(VMObject opOne,
			VMObject opTwo) {
		return new VMGeneralNotEquals(opOne, opTwo);
	}

	// Operator classes definitions

	public static final class DoubleNotEquals extends VMRelationalOperator {
		private final double dOne;
		private final double dTwo;

		public DoubleNotEquals(double dOne, double dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public Boolean evaluateBoolean(VMEnvironment env) {
			return (Double.compare(dOne, dTwo) != 0);
		}
	}

	/**
	 * This one is for integral types (long, int and short).
	 * 
	 * @author kidney
	 * 
	 */
	public static final class LongNotEquals extends VMRelationalOperator {
		private final long dOne;
		private final long dTwo;

		public LongNotEquals(long dOne, long dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return dOne != dTwo;
		}
	}

	public static final class BooleanNotEquals extends VMRelationalOperator {
		private final boolean dOne;
		private final boolean dTwo;

		public BooleanNotEquals(boolean dOne, boolean dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (dOne != dTwo);
		}
	}

	public static final class DoubleCompNotEquals extends VMRelationalOperator {
		private final double dOne;
		private final VMOperator dTwo;

		public DoubleCompNotEquals(double dOne, VMOperator dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (Double.compare(dOne, dTwo.evaluateDouble()) != 0);
		}
	}

	public static final class LongCompNotEquals extends VMRelationalOperator {
		private final long dOne;
		private final VMOperator dTwo;

		public LongCompNotEquals(long dOne, VMOperator dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (dOne != dTwo.evaluateLong());
		}
	}

	public static final class BooleanCompNotEquals extends VMRelationalOperator {
		private final boolean dOne;
		private final VMOperator dTwo;

		public BooleanCompNotEquals(boolean dOne, VMOperator dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (dOne != dTwo.evaluateBoolean());
		}
	}

	public static final class VMOperatorNotEquals extends VMRelationalOperator {
		private final VMOperator dOne;
		private final VMOperator dTwo;

		public VMOperatorNotEquals(VMOperator dOne, VMOperator dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			try {
				return (Double.compare(dOne.evaluateDouble(),
						dTwo.evaluateDouble()) != 0);
			} catch (VMEvaluationException e) {
				return (dOne.evaluateBoolean() == dTwo.evaluateBoolean());
			}
		}
	}

	public static final class VMGeneralNotEquals extends VMRelationalOperator {
		private final VMObject oOne;
		private final VMObject oTwo;

		public VMGeneralNotEquals(VMObject oOne, VMObject oTwo) {
			this.oOne = oOne;
			this.oTwo = oTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return !oOne.equals(oTwo);
		}
	}
}

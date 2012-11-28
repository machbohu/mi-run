package cz.cvut.fit.mirun.lemavm.structures.operators.control;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class VMEqualsOperatorFactory {

	private VMEqualsOperatorFactory() {
	}

	/**
	 * This method creates an operator with literal value - for using in e. g.
	 * while (true)...
	 * 
	 * @param value
	 *            The literal value, true or false
	 * @return VMRelationalOperator
	 */
	public static VMRelationalOperator createEqualsOperator(boolean value) {
		if (value) {
			return VMLiteralEquals.TRUE;
		} else {
			return VMLiteralEquals.FALSE;
		}
	}

	/**
	 * Create equality operator.
	 */
	public static VMRelationalOperator createEqualsOperator(double opOne,
			double opTwo) {
		return new DoubleEquals(opOne, opTwo);
	}

	/**
	 * Create equality operator.
	 */
	public static VMRelationalOperator createEqualsOperator(long opOne,
			long opTwo) {
		return new LongEquals(opOne, opTwo);
	}

	/**
	 * Create equality operator.
	 */
	public static VMRelationalOperator createEqualsOperator(boolean opOne,
			boolean opTwo) {
		return new BooleanEquals(opOne, opTwo);
	}

	/**
	 * Create equality operator.
	 */
	public static VMRelationalOperator createEqualsOperator(double opOne,
			VMOperator opTwo) {
		return new DoubleCompEquals(opOne, opTwo);
	}

	/**
	 * Create equality operator.
	 */
	public static VMRelationalOperator createEqualsOperator(long opOne,
			VMOperator opTwo) {
		return new LongCompEquals(opOne, opTwo);
	}

	/**
	 * Create equality operator.
	 */
	public static VMRelationalOperator createEqualsOperator(boolean opOne,
			VMOperator opTwo) {
		return new BooleanCompEquals(opOne, opTwo);
	}

	/**
	 * Create equality operator.
	 */
	public static VMRelationalOperator createEqualsOperator(VMOperator opOne,
			double opTwo) {
		return createEqualsOperator(opTwo, opOne);
	}

	/**
	 * Create equality operator.
	 */
	public static VMRelationalOperator createEqualsOperator(VMOperator opOne,
			long opTwo) {
		return createEqualsOperator(opTwo, opOne);
	}

	/**
	 * Create equality operator.
	 */
	public static VMRelationalOperator createEqualsOperator(VMOperator opOne,
			boolean opTwo) {
		return new BooleanCompEquals(opTwo, opOne);
	}

	/**
	 * Create equality operator.
	 */
	public static VMRelationalOperator createEqualsOperator(VMOperator opOne,
			VMOperator opTwo) {
		return new VMOperatorEquals(opOne, opTwo);
	}

	/**
	 * Create equality operator.
	 */
	public static VMRelationalOperator createEqualsOperator(VMObject opOne,
			VMObject opTwo) {
		return new VMGeneralEquals(opOne, opTwo);
	}

	// Operator classes definitions

	public static final class DoubleEquals extends VMRelationalOperator {
		private final double dOne;
		private final double dTwo;

		public DoubleEquals(double dOne, double dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (Double.compare(dOne, dTwo) == 0);
		}
	}

	/**
	 * This one is for integral types (long, int and short).
	 * 
	 * @author kidney
	 * 
	 */
	public static final class LongEquals extends VMRelationalOperator {
		private final long dOne;
		private final long dTwo;

		public LongEquals(long dOne, long dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return dOne == dTwo;
		}
	}

	public static final class BooleanEquals extends VMRelationalOperator {
		private final boolean dOne;
		private final boolean dTwo;

		public BooleanEquals(boolean dOne, boolean dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (dOne == dTwo);
		}
	}

	public static final class DoubleCompEquals extends VMRelationalOperator {
		private final double dOne;
		private final VMOperator dTwo;

		public DoubleCompEquals(double dOne, VMOperator dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (Double.compare(dOne, dTwo.evaluateDouble()) == 0);
		}
	}

	public static final class LongCompEquals extends VMRelationalOperator {
		private final long dOne;
		private final VMOperator dTwo;

		public LongCompEquals(long dOne, VMOperator dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (dOne == dTwo.evaluateLong());
		}
	}

	public static final class BooleanCompEquals extends VMRelationalOperator {
		private final boolean dOne;
		private final VMOperator dTwo;

		public BooleanCompEquals(boolean dOne, VMOperator dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (dOne == dTwo.evaluateBoolean());
		}
	}

	public static final class VMOperatorEquals extends VMRelationalOperator {
		private final VMOperator dOne;
		private final VMOperator dTwo;

		public VMOperatorEquals(VMOperator dOne, VMOperator dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			try {
				return (Double.compare(dOne.evaluateDouble(),
						dTwo.evaluateDouble()) == 0);
			} catch (VMEvaluationException e) {
				return (dOne.evaluateBoolean() == dTwo.evaluateBoolean());
			}
		}
	}

	public static final class VMGeneralEquals extends VMRelationalOperator {
		private final VMObject oOne;
		private final VMObject oTwo;

		public VMGeneralEquals(VMObject oOne, VMObject oTwo) {
			this.oOne = oOne;
			this.oTwo = oTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return oOne.equals(oTwo);
		}
	}

	public static final class VMLiteralEquals extends VMRelationalOperator {

		public static final VMLiteralEquals TRUE = new VMLiteralEquals(true);
		public static final VMLiteralEquals FALSE = new VMLiteralEquals(false);

		private final boolean value;

		private VMLiteralEquals(boolean value) {
			this.value = value;
		}

		@Override
		public boolean evaluateBoolean() {
			return value;
		}

	}
}

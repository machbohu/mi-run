package cz.cvut.fit.mirun.lemavm.structures.operators.control;

import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class VMGreaterThanOperatorFactory {

	private VMGreaterThanOperatorFactory() {
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessThanOperator(double opOne,
			double opTwo) {
		return new DoubleGreaterThan(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessThanOperator(long opOne, long opTwo) {
		return new LongGreaterThan(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessThanOperator(double opOne,
			VMOperator opTwo) {
		return new DoubleCompGreaterThan(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessThanOperator(long opOne,
			VMOperator opTwo) {
		return new LongCompGreaterThan(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessThanOperator(VMOperator opOne,
			double opTwo) {
		return new CompDoubleGreaterThan(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessThanOperator(VMOperator opOne,
			long opTwo) {
		return new CompLongGreaterThan(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessThanOperator(VMOperator opOne,
			VMOperator opTwo) {
		return new CompCompGreaterThan(opOne, opTwo);
	}

	// Operators definitions

	public static final class DoubleGreaterThan extends VMRelationalOperator {
		private final double dOne;
		private final double dTwo;

		public DoubleGreaterThan(double dOne, double dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (Double.compare(dOne, dTwo) > 0);
		}
	}

	public static final class LongGreaterThan extends VMRelationalOperator {
		private final long dOne;
		private final long dTwo;

		public LongGreaterThan(long dOne, long dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (dOne > dTwo);
		}
	}

	public static final class DoubleCompGreaterThan extends
			VMRelationalOperator {
		private final double dOne;
		private final VMOperator dTwo;

		public DoubleCompGreaterThan(double dOne, VMOperator dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (Double.compare(dOne, dTwo.evaluateDouble()) > 0);
		}
	}

	public static final class CompDoubleGreaterThan extends
			VMRelationalOperator {
		private final VMOperator dOne;
		private final double dTwo;

		public CompDoubleGreaterThan(VMOperator dOne, double dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (Double.compare(dOne.evaluateDouble(), dTwo) > 0);
		}
	}

	public static final class LongCompGreaterThan extends VMRelationalOperator {
		private final long dOne;
		private final VMOperator dTwo;

		public LongCompGreaterThan(long dOne, VMOperator dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (dOne > dTwo.evaluateLong());
		}
	}

	public static final class CompLongGreaterThan extends VMRelationalOperator {
		private final VMOperator dOne;
		private final long dTwo;

		public CompLongGreaterThan(VMOperator dOne, long dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (dOne.evaluateLong() > dTwo);
		}
	}

	public static final class CompCompGreaterThan extends VMRelationalOperator {
		private final VMOperator dOne;
		private final VMOperator dTwo;

		public CompCompGreaterThan(VMOperator dOne, VMOperator dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (Double
					.compare(dOne.evaluateDouble(), dTwo.evaluateDouble()) > 0);
		}
	}
}

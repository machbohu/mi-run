package cz.cvut.fit.mirun.lemavm.structures.operators.control;

import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class VMGreaterEqualsOperatorFactory {

	private VMGreaterEqualsOperatorFactory() {
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessEqualOperator(double opOne,
			double opTwo) {
		return new DoubleGreaterEqual(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessEqualOperator(long opOne, long opTwo) {
		return new LongGreaterEqual(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessEqualOperator(double opOne,
			VMOperator opTwo) {
		return new DoubleCompGreaterEqual(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessEqualOperator(long opOne,
			VMOperator opTwo) {
		return new LongCompGreaterEqual(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessEqualOperator(VMOperator opOne,
			double opTwo) {
		return new CompDoubleGreaterEqual(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessEqualOperator(VMOperator opOne,
			long opTwo) {
		return new CompLongGreaterEqual(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessEqualOperator(VMOperator opOne,
			VMOperator opTwo) {
		return new CompCompGreaterEqual(opOne, opTwo);
	}

	// Operators definitions

	public static final class DoubleGreaterEqual extends VMRelationalOperator {
		private final double dOne;
		private final double dTwo;

		public DoubleGreaterEqual(double dOne, double dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (Double.compare(dOne, dTwo) >= 0);
		}
	}

	public static final class LongGreaterEqual extends VMRelationalOperator {
		private final long dOne;
		private final long dTwo;

		public LongGreaterEqual(long dOne, long dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (dOne >= dTwo);
		}
	}

	public static final class DoubleCompGreaterEqual extends
			VMRelationalOperator {
		private final double dOne;
		private final VMOperator dTwo;

		public DoubleCompGreaterEqual(double dOne, VMOperator dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (Double.compare(dOne, dTwo.evaluateDouble()) >= 0);
		}
	}

	public static final class CompDoubleGreaterEqual extends
			VMRelationalOperator {
		private final VMOperator dOne;
		private final double dTwo;

		public CompDoubleGreaterEqual(VMOperator dOne, double dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (Double.compare(dOne.evaluateDouble(), dTwo) >= 0);
		}
	}

	public static final class LongCompGreaterEqual extends VMRelationalOperator {
		private final long dOne;
		private final VMOperator dTwo;

		public LongCompGreaterEqual(long dOne, VMOperator dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (dOne >= dTwo.evaluateLong());
		}
	}

	public static final class CompLongGreaterEqual extends VMRelationalOperator {
		private final VMOperator dOne;
		private final long dTwo;

		public CompLongGreaterEqual(VMOperator dOne, long dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (dOne.evaluateLong() >= dTwo);
		}
	}

	public static final class CompCompGreaterEqual extends VMRelationalOperator {
		private final VMOperator dOne;
		private final VMOperator dTwo;

		public CompCompGreaterEqual(VMOperator dOne, VMOperator dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (Double
					.compare(dOne.evaluateDouble(), dTwo.evaluateDouble()) >= 0);
		}
	}

}

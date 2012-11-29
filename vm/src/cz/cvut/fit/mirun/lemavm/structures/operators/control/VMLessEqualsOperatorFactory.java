package cz.cvut.fit.mirun.lemavm.structures.operators.control;

import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class VMLessEqualsOperatorFactory {

	private VMLessEqualsOperatorFactory() {
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessEqualOperator(double opOne,
			double opTwo) {
		return new DoubleLessEqual(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessEqualOperator(long opOne, long opTwo) {
		return new LongLessEqual(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessEqualOperator(double opOne,
			VMOperator opTwo) {
		return new DoubleCompLessEqual(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessEqualOperator(long opOne,
			VMOperator opTwo) {
		return new LongCompLessEqual(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessEqualOperator(VMOperator opOne,
			double opTwo) {
		return new CompDoubleLessEqual(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessEqualOperator(VMOperator opOne,
			long opTwo) {
		return new CompLongLessEqual(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessEqualOperator(VMOperator opOne,
			VMOperator opTwo) {
		return new CompCompLessEqual(opOne, opTwo);
	}

	// Operator definitions

	public static final class DoubleLessEqual extends VMRelationalOperator {
		private final double dOne;
		private final double dTwo;

		public DoubleLessEqual(double dOne, double dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (Double.compare(dOne, dTwo) <= 0);
		}
	}

	public static final class LongLessEqual extends VMRelationalOperator {
		private final long dOne;
		private final long dTwo;

		public LongLessEqual(long dOne, long dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (dOne <= dTwo);
		}
	}

	public static final class DoubleCompLessEqual extends VMRelationalOperator {
		private final double dOne;
		private final VMOperator dTwo;

		public DoubleCompLessEqual(double dOne, VMOperator dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (Double.compare(dOne, dTwo.evaluateDouble()) <= 0);
		}
	}

	public static final class CompDoubleLessEqual extends VMRelationalOperator {
		private final VMOperator dOne;
		private final double dTwo;

		public CompDoubleLessEqual(VMOperator dOne, double dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (Double.compare(dOne.evaluateDouble(), dTwo) <= 0);
		}
	}

	public static final class LongCompLessEqual extends VMRelationalOperator {
		private final long dOne;
		private final VMOperator dTwo;

		public LongCompLessEqual(long dOne, VMOperator dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (dOne <= dTwo.evaluateLong());
		}
	}

	public static final class CompLongLessEqual extends VMRelationalOperator {
		private final VMOperator dOne;
		private final long dTwo;

		public CompLongLessEqual(VMOperator dOne, long dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (dOne.evaluateLong() <= dTwo);
		}
	}

	public static final class CompCompLessEqual extends VMRelationalOperator {
		private final VMOperator dOne;
		private final VMOperator dTwo;

		public CompCompLessEqual(VMOperator dOne, VMOperator dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (Double
					.compare(dOne.evaluateDouble(), dTwo.evaluateDouble()) <= 0);
		}
	}
}

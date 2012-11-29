package cz.cvut.fit.mirun.lemavm.structures.operators.control;

import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public final class VMLessThanOperatorFactory {

	private VMLessThanOperatorFactory() {
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessThanOperator(double opOne,
			double opTwo) {
		return new DoubleLessThan(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessThanOperator(long opOne, long opTwo) {
		return new LongLessThan(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessThanOperator(double opOne,
			VMOperator opTwo) {
		return new DoubleCompLessThan(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessThanOperator(long opOne,
			VMOperator opTwo) {
		return new LongCompLessThan(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessThanOperator(VMOperator opOne,
			double opTwo) {
		return new CompDoubleLessThan(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessThanOperator(VMOperator opOne,
			long opTwo) {
		return new CompLongLessThan(opOne, opTwo);
	}

	/**
	 * Create the relational operator.
	 */
	public VMRelationalOperator createLessThanOperator(VMOperator opOne,
			VMOperator opTwo) {
		return new CompCompLessThan(opOne, opTwo);
	}

	// Operators definitions

	public static final class DoubleLessThan extends VMRelationalOperator {
		private final double dOne;
		private final double dTwo;

		public DoubleLessThan(double dOne, double dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (Double.compare(dOne, dTwo) < 0);
		}
	}

	public static final class LongLessThan extends VMRelationalOperator {
		private final long dOne;
		private final long dTwo;

		public LongLessThan(long dOne, long dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (dOne < dTwo);
		}
	}

	public static final class DoubleCompLessThan extends VMRelationalOperator {
		private final double dOne;
		private final VMOperator dTwo;

		public DoubleCompLessThan(double dOne, VMOperator dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (Double.compare(dOne, dTwo.evaluateDouble()) < 0);
		}
	}

	public static final class CompDoubleLessThan extends VMRelationalOperator {
		private final VMOperator dOne;
		private final double dTwo;

		public CompDoubleLessThan(VMOperator dOne, double dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (Double.compare(dOne.evaluateDouble(), dTwo) < 0);
		}
	}

	public static final class LongCompLessThan extends VMRelationalOperator {
		private final long dOne;
		private final VMOperator dTwo;

		public LongCompLessThan(long dOne, VMOperator dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (dOne < dTwo.evaluateLong());
		}
	}

	public static final class CompLongLessThan extends VMRelationalOperator {
		private final VMOperator dOne;
		private final long dTwo;

		public CompLongLessThan(VMOperator dOne, long dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (dOne.evaluateLong() < dTwo);
		}
	}

	public static final class CompCompLessThan extends VMRelationalOperator {
		private final VMOperator dOne;
		private final VMOperator dTwo;

		public CompCompLessThan(VMOperator dOne, VMOperator dTwo) {
			this.dOne = dOne;
			this.dTwo = dTwo;
		}

		@Override
		public boolean evaluateBoolean() {
			return (Double
					.compare(dOne.evaluateDouble(), dTwo.evaluateDouble()) < 0);
		}
	}
}

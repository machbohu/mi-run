package cz.cvut.fit.mirun.lemavm.structures.builtin;

import org.apache.log4j.Logger;

import cz.cvut.fit.mirun.lemavm.observers.StaticObservable;
import cz.cvut.fit.mirun.lemavm.structures.Printable;

/**
 * This class will be used for console output and other system interactions.
 * </p>
 * 
 * It gets very special treatment in the method invocation procedure.
 * 
 * @author kidney
 * 
 */
public final class VMSystem extends StaticObservable {

	private static final Logger LOG = Logger.getLogger(VMSystem.class);

	/**
	 * Print the specified value on standard output.
	 * 
	 * @param str
	 *            The value to print
	 */
	public static void print(Object str) {
		final String toPrint = extractValue(str);
		if (LOG.isTraceEnabled()) {
			LOG.trace("Printing out value: " + toPrint);
		}
		System.out.print(toPrint);
		notifyObservers(toPrint);
	}

	/**
	 * Print the specified value on standard output and terminate the line.
	 * 
	 * @param str
	 *            The value to print
	 */
	public static void println(Object str) {
		final String toPrint = extractValue(str);
		if (LOG.isTraceEnabled()) {
			LOG.trace("Printing out line: " + toPrint);
		}
		System.out.println(toPrint);
		notifyObservers(toPrint);
	}

	/**
	 * Print the specified value on error output and terminate the line.
	 * 
	 * @param str
	 *            The value to print
	 */
	public static void errorln(Object str) {
		final String toPrint = extractValue(str);
		if (LOG.isTraceEnabled()) {
			LOG.trace("Error line: " + toPrint);
		}
		System.err.println(toPrint);
		notifyObservers(toPrint);
	}

	private static String extractValue(Object str) {
		if (str == null) {
			throw new NullPointerException();
		}
		String value = null;
		if (str instanceof Printable) {
			value = ((Printable) str).printValue();
		} else {
			value = str.toString();
		}
		return value;
	}
	
//	public static 
}

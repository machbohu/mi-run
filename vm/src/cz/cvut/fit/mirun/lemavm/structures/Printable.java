package cz.cvut.fit.mirun.lemavm.structures;

public interface Printable {

	/**
	 * Get a printable representation of this object. </p>
	 * 
	 * In contrast to the {@code toString} method, this method returns a
	 * {@code String} value that can be printed out by the Virtual Machine.
	 * 
	 * @return Printable representation of this object
	 */
	public String printValue();

}

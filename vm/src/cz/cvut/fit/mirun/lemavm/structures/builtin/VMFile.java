package cz.cvut.fit.mirun.lemavm.structures.builtin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

import cz.cvut.fit.mirun.lemavm.exceptions.VMEvaluationException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMIOException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMIllegalStateException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMNullPointerException;
import cz.cvut.fit.mirun.lemavm.structures.Evaluable;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.Printable;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMEnvironment;

public final class VMFile extends VMObject {

	private static final Logger LOG = Logger.getLogger(VMFile.class);

	private final String fileName;
	private final File file;

	private BufferedReader reader;
	private BufferedWriter writer;

	private boolean readerOpen;
	private boolean writerOpen;

	public VMFile(Object fileName, VMEnvironment env) {
		super(ObjectType.FILE);
		if (fileName == null) {
			throw new NullPointerException();
		}
		this.fileName = getFileName(fileName, env);
		this.file = new File(this.fileName);
		this.readerOpen = this.writerOpen = true;
	}

	public Boolean doesFileExist() {
		return file.exists();
	}

	public Boolean canRead() {
		return (file.canRead() && readerOpen);
	}

	public Boolean canWrite() {
		return (file.canWrite() && writerOpen);
	}

	/**
	 * Create new file (with parent directories, if necessary). </p>
	 */
	public void createFile() {
		if (!file.exists()) {
			try {
				file.mkdirs();
				file.createNewFile();
			} catch (IOException e) {
				LOG.error("Unable to create file.", e);
				throw new VMIOException("Unable to create file " + fileName);
			}
		}
	}

	/**
	 * Read a single line from this file. </p>
	 * 
	 * If nothing more can be read, {@code VMNull} is returned.
	 * 
	 * @return A {@code VMString} representing the line read from the file or a
	 *         {@code VMNull} if nothing was read
	 */
	public VMPrimitive readLine() {
		ensureReaderOpen();
		try {
			if (reader == null) {
				reader = new BufferedReader(new FileReader(file));
			}
			final String s = reader.readLine();
			if (LOG.isTraceEnabled()) {
				LOG.trace("Line " + s + " read from file " + fileName);
			}
			if (s == null) {
				return VMNull.getInstance();
			} else {
				return new VMString(s);
			}
		} catch (IOException e) {
			LOG.error("Unable to read from file " + fileName, e);
			throw new VMIOException("Unable to read from file " + fileName);
		}
	}

	/**
	 * Write a single line into the file. </p>
	 * 
	 * If the specified argument is a {@code Printable}, its
	 * {@link Printable#printValue()} method is used to get the value to write,
	 * otherwise, {@code toString()} is called on the argument. A new line is
	 * then appended to the value.
	 * 
	 * @param str
	 *            The value to write to this file
	 */
	public void writeLine(Object str) {
		if (str == null) {
			// This is our problem
			throw new NullPointerException();
		}
		if (str.equals(VMNull.getInstance())) {
			// This is the application's problem
			throw new VMNullPointerException();
		}
		ensureWriterOpen();
		try {
			if (writer == null) {
				this.writer = new BufferedWriter(new FileWriter(file));
			}
			String toWrite = null;
			if (str instanceof Printable) {
				toWrite = ((Printable) str).printValue();
			} else {
				toWrite = str.toString();
			}
			if (LOG.isTraceEnabled()) {
				LOG.trace("Writing string " + toWrite + " into the file "
						+ fileName);
			}
			writer.write(toWrite);
			writer.newLine();
		} catch (IOException e) {
			LOG.error("Unable to write to file " + fileName, e);
			throw new VMIOException("Unable to write to file " + fileName);
		}
	}

	/**
	 * Close the file reader. </p>
	 * 
	 * Closing already closed reader does nothing.
	 */
	public void closeReader() {
		if (reader != null && readerOpen) {
			try {
				readerOpen = false;
				reader.close();
			} catch (IOException e) {
				LOG.error("Error when closing input stream", e);
				throw new VMIOException("Unable to close the file reader.");
			}
		}
	}

	/**
	 * Close the file writer. </p>
	 * 
	 * Closing already closed writer does nothing.
	 */
	public void closeWriter() {
		if (writer != null && writerOpen) {
			try {
				writerOpen = false;
				writer.flush();
				writer.close();
			} catch (IOException e) {
				LOG.error("Error when closing output stream", e);
				throw new VMIOException("Unable to close the file writer.");
			}
		}
	}

	/**
	 * Close this file. </p>
	 * 
	 * This operation cannot be undone, both reader and writer are closed and
	 * cannot be used any more.
	 */
	public void close() {
		closeReader();
		closeWriter();
	}

	private void ensureReaderOpen() {
		if (!readerOpen) {
			throw new VMIllegalStateException(
					"Cannot read from already closed file.");
		}
	}

	private void ensureWriterOpen() {
		if (!writerOpen) {
			throw new VMIllegalStateException(
					"Cannot write to already closed file.");
		}
	}

	private String getFileName(Object file, VMEnvironment env) {
		String name = null;
		if (file instanceof Evaluable) {
			Object res = ((Evaluable) file).evaluate(env);
			if (!(res instanceof VMString)) {
				throw new VMEvaluationException(
						"File got constructor argument that cannot be cast to string. Argument: "
								+ res);
			}
		} else if (file instanceof String) {
			final String s = (String) file;
			if (s.startsWith("\"")) {
				name = s.substring(1, s.length() - 1);
			} else {
				final VMString var = env.getBinding(s, VMString.class);
				name = var.getValue();
			}
		} else {
			throw new VMEvaluationException(
					"Unsupported argument for File constructor. Argument: "
							+ file);
		}
		return name;
	}
}

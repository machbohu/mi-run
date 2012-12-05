package cz.cvut.fit.mirun.lemavm.structures.builtin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

import cz.cvut.fit.mirun.lemavm.exceptions.VMIOException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMIllegalStateException;
import cz.cvut.fit.mirun.lemavm.exceptions.VMNullPointerException;
import cz.cvut.fit.mirun.lemavm.structures.ObjectType;
import cz.cvut.fit.mirun.lemavm.structures.Printable;
import cz.cvut.fit.mirun.lemavm.structures.VMObject;

public class VMFile extends VMObject {

	private static final Logger LOG = Logger.getLogger(VMFile.class);

	private final String fileName;
	private final File file;

	private BufferedReader reader;
	private BufferedWriter writer;

	private boolean readerOpen;
	private boolean writerOpen;

	public VMFile(VMString fileName) {
		super(ObjectType.FILE);
		if (fileName == null) {
			throw new NullPointerException();
		}
		this.fileName = fileName.getValue();
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
			if (str instanceof Printable) {
				writer.write(((Printable) str).printValue());
			} else {
				writer.write(str.toString());
			}
			writer.newLine();
		} catch (IOException e) {
			LOG.error("Unable to write to file " + fileName, e);
			throw new VMIOException("Unable to write to file " + fileName);
		}
	}

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
}

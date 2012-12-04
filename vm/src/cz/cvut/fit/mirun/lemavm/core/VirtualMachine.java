package cz.cvut.fit.mirun.lemavm.core;

import java.io.IOException;
import java.util.Arrays;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.TokenRewriteStream;
import org.apache.log4j.Logger;

import cz.cvut.fit.mirun.lemavm.antlr.LeMaVMLexer;
import cz.cvut.fit.mirun.lemavm.antlr.LeMaVMParser;

/**
 * This is the main entry point of the LeMaVM virtual machine.
 * 
 * @author kidney
 * 
 */
public class VirtualMachine {

	private static final Logger LOG = Logger.getLogger(VirtualMachine.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			LOG.error("Insuficient number of arguments. You have to specify at least the name of the file to run.");
			System.exit(1);
		}
		final String file = args[0];
		try {
			final ANTLRFileStream fs = new ANTLRFileStream(file);
			LeMaVMLexer lex = new LeMaVMLexer(fs);
			TokenRewriteStream tokens = new TokenRewriteStream(lex);
			LeMaVMParser grammar = new LeMaVMParser(tokens);
			// TODO Get the AST from the grammar
			final String[] appArgs = Arrays.copyOfRange(args, 1, args.length);
			VMInterpreter.getInstance().executeApplication(appArgs);
		} catch (IOException e) {
			LOG.error("Unable to read the specified file.", e);
			System.exit(2);
		}
	}
}

package cz.cvut.fit.mirun.lemavm.builder;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

import cz.cvut.fit.mirun.lemavm.structures.VMCodeBlock;

public class VMCreator {
	private static VMCodeBlock create(VMBuilder b) throws RecognitionException{
		b.build();
		return b.getCodeBlock();
	}
	
	public static VMCodeBlock createBaseStructureFromTree(CharStream cs) throws RecognitionException{
		return create(new VMBaseStructureBuilder(cs));

	}
	
	public static VMCodeBlock createCodeBlockFromTree(CommonTree node) throws RecognitionException{
		return create(new VMCodeBlockBuilder(node));
	}
}

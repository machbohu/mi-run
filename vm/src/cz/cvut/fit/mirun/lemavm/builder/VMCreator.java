package cz.cvut.fit.mirun.lemavm.builder;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

import cz.cvut.fit.mirun.lemavm.structures.VMCodeBlock;

public class VMCreator {
	private static VMCodeBlock create(VMBuilder b){
		b.build();
		return b.getCodeBlock();
	}
	
	public static VMCodeBlock createBaseStructureFromTree(CharStream cs){
		return create(new VMBaseStructureBuilder(cs));

	}
	
	public static VMCodeBlock createCodeBlockFromTree(CommonTree node){
		return create(new VMCodeBlockBuilder(node));
	}
}

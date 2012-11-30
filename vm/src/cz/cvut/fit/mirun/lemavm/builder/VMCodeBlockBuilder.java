package cz.cvut.fit.mirun.lemavm.builder;

import org.antlr.runtime.tree.CommonTree;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.VMCodeBlock;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMField;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;

public class VMCodeBlockBuilder extends VMBuilder {
	private CommonTree top;
	private VMCodeBlock code;
	
	public VMCodeBlockBuilder(CommonTree node){
		this.top = node;
	}
	
	public void build(){
		CommonTree child = null;
		Object expr = null;
		
		for(Object o : top.getChildren()){
			child = (CommonTree) o;
			
			switch(child.toString()){
			case "VAR_DECLARATION":
				for(VMField f : buildVarFromTree(child)){
					// create assign operator and add it to the codeBlock
				}
				break;
			case "EXPR":
				expr = buildExpressionFromTree(child);
				break;
			case "if":
				
				break;
			case "while":
				break;
			case "for":
				break;
			case "return":
				break;
			}
		}
	}
	
	public VMCodeBlock getCodeBlock(){
		return code;
	}
}

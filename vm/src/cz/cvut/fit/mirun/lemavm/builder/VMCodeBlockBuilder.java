package cz.cvut.fit.mirun.lemavm.builder;

import org.antlr.runtime.tree.CommonTree;

import cz.cvut.fit.mirun.lemavm.structures.VMCodeBlock;

public class VMCodeBlockBuilder extends VMBuilder {
	private CommonTree top;
	private VMCodeBlock code;
	
	public VMCodeBlockBuilder(CommonTree node){
		this.top = node;
	}
	
	public void build(){
		CommonTree node = null;
		
		for(Object o : top.getChildren()){
			node = (CommonTree) o;
			
			switch(node.toString()){
			case "VAR_DECLARATION":
				break;
			case "EXPR":
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

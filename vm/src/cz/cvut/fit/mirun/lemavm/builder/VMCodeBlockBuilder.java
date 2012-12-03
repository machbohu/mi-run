package cz.cvut.fit.mirun.lemavm.builder;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.tree.CommonTree;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.Evaluable;
import cz.cvut.fit.mirun.lemavm.structures.VMCodeBlock;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMField;
import cz.cvut.fit.mirun.lemavm.structures.control.VMFor;

public class VMCodeBlockBuilder extends VMBuilder {
	private CommonTree top;
	private VMCodeBlock code;
	
	public VMCodeBlockBuilder(CommonTree node){
		this.top = node;
		this.code = new VMCodeBlock();
	}
	
	private Evaluable buildForFromTree(CommonTree node){
		CommonTree child = null, codeTree = null;
		List<Object> inits = null;
		Object condition = null, operation = null;
	
		for(Object o : node.getChildren()){
			child = (CommonTree) o;
			
			if(child.getChildCount() <= 0){
				throw new VMParsingException("FOR cycle must be properly initialized");
			}
			
			switch(child.toString()){
			case "FOR_INIT":
				child = (CommonTree) child.getChild(0);
				
				switch(child.toString()){
				case "VAR_DECLARATION":
					inits = new ArrayList<>();
					
					for(VMField f : buildVarFromTree(child)){
						// TODO create assign operator and add it to the for
//							inits.add(operator);
					}
					break;
				case "EXPR":
					inits.add(buildExpressionFromTree(child));
					break;
				}
				break;
			case "FOR_CONDITION":
				condition = buildExpressionFromTree((CommonTree) child.getChild(0));
				break;
			case "FOR_UPDATE":
				operation = buildExpressionFromTree((CommonTree) child.getChild(0));
				break;
			case "BLOCK_SCOPE":
				codeTree = child;
				break;
			default:
				throw new VMParsingException("Unsupported operation '"+child.toString()+"'");
			}
		}
		
		return new VMFor(inits, condition, operation, codeTree);
	}
	
	public void build(){
		CommonTree child = null;
		Object condition = null;
		
		for(Object o : top.getChildren()){
			child = (CommonTree) o;
			
			// TODO add every case to codeBlock
			switch(child.toString()){
			case "VAR_DECLARATION":
				for(VMField f : buildVarFromTree(child)){
					// TODO create assign operator and add it to the codeBlock
				}
				break;
			case "EXPR":
				buildExpressionFromTree(child);
				break;
			case "if":
				condition = buildExpressionFromTree((CommonTree) child.getChild(0));
//				new VMIfElse(condition, (CommonTree) child.getChild(1), (CommonTree) child.getChild(2));
				break;
			case "while":
				condition = buildExpressionFromTree((CommonTree) child.getChild(0));
//				new VMWhile(condition, (CommonTree) child.getChild(1));
				break;
			case "for":
				buildForFromTree(child);
				break;
			case "return":
				// TODO
				break;
			default:
				throw new VMParsingException("Unsupported operation '"+child.toString()+"'");
			}
		}
	}
	
	public VMCodeBlock getCodeBlock(){
		return code;
	}
}

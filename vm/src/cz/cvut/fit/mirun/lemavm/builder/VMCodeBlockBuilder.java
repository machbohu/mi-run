package cz.cvut.fit.mirun.lemavm.builder;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.tree.CommonTree;
import org.apache.log4j.Logger;

import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.Evaluable;
import cz.cvut.fit.mirun.lemavm.structures.VMCodeBlock;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMField;
import cz.cvut.fit.mirun.lemavm.structures.control.VMFor;
import cz.cvut.fit.mirun.lemavm.structures.control.VMIfElse;
import cz.cvut.fit.mirun.lemavm.structures.control.VMWhile;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMReturnOperator;

public class VMCodeBlockBuilder extends VMBuilder {
	private static final Logger LOG = Logger.getLogger(VMCodeBlockBuilder.class);
	
	private CommonTree top;
	private VMCodeBlock code;
	
	public VMCodeBlockBuilder(CommonTree node){
		this.top = node;
		this.code = new VMCodeBlock();
	}
	/**
	 * Build FOR cycle from AST tree;
	 * AST tree node [for] 
	 * @param node
	 * @return
	 */
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
				inits = new ArrayList<>();
				
				switch(child.toString()){
				case "VAR_DECLARATION":
					for(VMField f : buildVarFromTree(child)){
						operation = assignFactory.createOperator(f.getName(), f.getType(), false, f.getVal());
						inits.add(operation);
						LOG.debug("Creating FOR cycle init declaration "+f);
					}
					break;
				case "EXPR":
					inits.add(buildExpressionFromTree(child));
					break;
				default:
					throw new VMParsingException("FOR init: Unsupported operation '"+child+"'");
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
				throw new VMParsingException("FOR init: Unsupported operation '"+child+"'");
			}
		}
		
		LOG.debug("Creating FOR cycle "+inits+", "+condition+" "+operation+" "+codeTree);
		
		return new VMFor(inits, condition, operation, codeTree);
	}
	
	/**
	 * Build block scope from AST tree;
	 * AST tree node [BLOCK_SCOPE]
	 */
	public void build(){
		CommonTree child = null;
		Object condition = null, operation = null;
		
		if(top.getChildCount() <= 0){
			return;
		}
		
		for(Object o : top.getChildren()){
			child = (CommonTree) o;
			
			switch(child.toString()){
			case "VAR_DECLARATION":
				for(VMField f : buildVarFromTree(child)){
					operation = assignFactory.createOperator(f.getName(), f.getType(), f.isFinal(), f.getVal());
					code.addCodePart(operation);
					LOG.debug("Creating variable declaration "+f);
				}
				break;
			case "EXPR":
				code.addCodePart(buildExpressionFromTree(child));
				LOG.debug("Creating expression");
				break;
			case "if":
				condition = buildExpressionFromTree((CommonTree) child.getChild(0));
				code.addCodePart(new VMIfElse(condition, (CommonTree) child.getChild(1), 
						(CommonTree) child.getChild(2)));
				LOG.debug("Creating IF-ELSE "+condition+" "+child.getChild(1)+" "+child.getChild(2));
				break;
			case "while":
				condition = buildExpressionFromTree((CommonTree) child.getChild(0));
				code.addCodePart(new VMWhile(condition, (CommonTree) child.getChild(1)));
				LOG.debug("Creating WHILE cycle "+condition+" "+child.getChild(1));
				break;
			case "for":
				code.addCodePart(buildForFromTree(child));
				break;
			case "return":
				if(child.getChildCount() > 0){
					operation = buildExpressionFromTree((CommonTree) child.getChild(0));
					code.addCodePart(new VMReturnOperator(operation));
				}else{
					// TODO what about return; in void?
				}
				LOG.debug("Creating return");
				break;
			default:
				throw new VMParsingException("Unsupported operation '"+child+"'");
			}
		}
	}
	
	public VMCodeBlock getCodeBlock(){
		return code;
	}
}

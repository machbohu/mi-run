package cz.cvut.fit.mirun.lemavm.builder;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

import cz.cvut.fit.mirun.lemavm.assignment.AssignOperatorFactory;
import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.VMCodeBlock;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMField;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMVisibilityModifier;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMBinaryMinusOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMBinaryOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMBinaryPlusOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMDivisionOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMMultiplicationOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMOperator;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMPostfixDecrementOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMPostfixIncrementOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMPrefixDecrementOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMPrefixIncrementOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMUnaryMinusOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMUnaryNegationOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMUnaryOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMUnaryPlusOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.control.NotEqualsOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.control.VMEqualsOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.control.VMGreaterEqualsOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.control.VMGreaterThanOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.control.VMLessEqualsOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.control.VMLessThanOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.control.VMLogicalAndOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.control.VMLogicalOrOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.control.VMRelationalOperatorFactory;
import cz.cvut.fit.mirun.lemavm.utils.VMUtils;

public abstract class VMBuilder {

	// Operator factories
	protected static VMBinaryOperatorFactory minusFactory;
	protected static VMBinaryOperatorFactory plusFactory;
	protected static VMBinaryOperatorFactory divisionFactory;
	protected static VMBinaryOperatorFactory multiplicationFactory;
	protected static VMUnaryOperatorFactory postfixDecrementFactory;
	protected static VMUnaryOperatorFactory postfixIncrementFactory;
	protected static VMUnaryOperatorFactory prefixDecrementFactory;
	protected static VMUnaryOperatorFactory prefixIncrementFactory;
	protected static VMUnaryOperatorFactory unaryMinusFactory;
	protected static VMUnaryOperatorFactory unaryPlusFactory;
	protected static VMUnaryOperatorFactory unaryNegationFactory;

	protected static VMRelationalOperatorFactory notEqualsFactory;
	protected static VMRelationalOperatorFactory equalsFactory;
	protected static VMRelationalOperatorFactory lessThanFactory;
	protected static VMRelationalOperatorFactory lessOrEqualFactory;
	protected static VMRelationalOperatorFactory greaterThanFactory;
	protected static VMRelationalOperatorFactory greaterOrEqualFactory;
	protected static VMRelationalOperatorFactory logicalAndFactory;
	protected static VMRelationalOperatorFactory logicalOrFactory;
	
	protected static AssignOperatorFactory assignFactory;

	/**
	 * Constructor
	 */
	public VMBuilder() {
		initOperatorFactories();
	}

	private void initOperatorFactories() {
		minusFactory = new VMBinaryMinusOperatorFactory();
		plusFactory = new VMBinaryPlusOperatorFactory();
		divisionFactory = new VMDivisionOperatorFactory();
		multiplicationFactory = new VMMultiplicationOperatorFactory();
		postfixDecrementFactory = new VMPostfixDecrementOperatorFactory();
		postfixIncrementFactory = new VMPostfixIncrementOperatorFactory();
		prefixDecrementFactory = new VMPrefixDecrementOperatorFactory();
		prefixIncrementFactory = new VMPrefixIncrementOperatorFactory();
		unaryMinusFactory = new VMUnaryMinusOperatorFactory();
		unaryPlusFactory = new VMUnaryPlusOperatorFactory();
		unaryNegationFactory = new VMUnaryNegationOperatorFactory();
		notEqualsFactory = new NotEqualsOperatorFactory();
		equalsFactory = new VMEqualsOperatorFactory();
		lessThanFactory = new VMLessThanOperatorFactory();
		lessOrEqualFactory = new VMLessEqualsOperatorFactory();
		greaterThanFactory = new VMGreaterThanOperatorFactory();
		greaterOrEqualFactory = new VMGreaterEqualsOperatorFactory();
		logicalAndFactory = new VMLogicalAndOperatorFactory();
		logicalOrFactory = new VMLogicalOrOperatorFactory();
		assignFactory = new AssignOperatorFactory();
	}

	public abstract void build() throws RecognitionException;

	public abstract VMCodeBlock getCodeBlock();

	/**
	 * Get type (int, string ...) from tree;
	 * Nodes [TYPE] -> [[QUALIFIED_TYPE_IDENT] ->] [VALUE]
	 * @param node
	 * @return Type in string representation
	 */
	protected String buildTypeFromTree(CommonTree node) {
		if (node.getChild(0).getChildCount() == 0) {
			return node.getChild(0).toString();
		} else {
			return node.getChild(0).getChild(0).toString();
		}
	}
	
	/**
	 * Build argument list from tree;
	 * AST node [ARGUMENT_LIST] -> [EXPR]
	 * @param node
	 * @return List of arguments (VMOperator or String as Object)
	 */
	protected List<Object> buildArgumentListFromTree(CommonTree node){
		CommonTree child = null;
		List<Object> args = new ArrayList<>();
		
		for(Object o : node.getChildren()){
			child = (CommonTree) o;
			
			switch(child.toString()){
			case "EXPR":
				args.add(buildExpressionFromTree(child));
				break;
			default:
				throw new VMParsingException("Unsupported operation '"
						+ node.toString() + "'");
			}
		}
		return args;
	}

	/**
	 * Build expression from given tree for future evaluation;
	 * i.e. a = (a + 5) * c, cls.methodCall(a, b);
	 * AST Tree node [EXPR]
	 * 
	 * @param node
	 * @return VMOperator or String as Object
	 */
	protected Object buildExpressionFromTree(CommonTree node) {
		Object op1 = null, op2 = null, operation = null;
		String name = null;

		if (node.getChildCount() <= 0) {
			return node.toString();
		}

		switch (node.toString()) {
		case "+":
			op1 = buildExpressionFromTree((CommonTree) node.getChild(0));
			op2 = buildExpressionFromTree((CommonTree) node.getChild(1));
			return plusFactory.createOperator(op1, op2);
		case "POST_INC": // one operand (child)
			op1 = buildExpressionFromTree((CommonTree) node.getChild(0));
			return postfixIncrementFactory.createOperator(op1);
		case "PRE_INC": // one operand (child)
			op1 = buildExpressionFromTree((CommonTree) node.getChild(0));
			return prefixIncrementFactory.createOperator(op1);
		case "UNARY_PLUS": // one operand (child)
			op1 = buildExpressionFromTree((CommonTree) node.getChild(0));
			return unaryPlusFactory.createOperator(op1);
		case "-":
			op1 = buildExpressionFromTree((CommonTree) node.getChild(0));
			op2 = buildExpressionFromTree((CommonTree) node.getChild(1));
			return minusFactory.createOperator(op1, op2);
		case "POST_DEC": // one operand (child)
			op1 = buildExpressionFromTree((CommonTree) node.getChild(0));
			return postfixDecrementFactory.createOperator(op1);
		case "PRE_DEC": // one operand (child)
			op1 = buildExpressionFromTree((CommonTree) node.getChild(0));
			return prefixDecrementFactory.createOperator(op1);
		case "UNARY_MINUS": // one operand (child)
			op1 = buildExpressionFromTree((CommonTree) node.getChild(0));
			return unaryMinusFactory.createOperator(op1);
		case "*":
			op1 = buildExpressionFromTree((CommonTree) node.getChild(0));
			op2 = buildExpressionFromTree((CommonTree) node.getChild(1));
			return multiplicationFactory.createOperator(op1, op2);
		case "/":
			op1 = buildExpressionFromTree((CommonTree) node.getChild(0));
			op2 = buildExpressionFromTree((CommonTree) node.getChild(1));
			return divisionFactory.createOperator(op1, op2);
		case "=":
			name = node.getChild(0).toString();
			op2 = buildExpressionFromTree((CommonTree) node.getChild(1));
			return assignFactory.createOperator(name, null, false, op2);
		case "-=":
			name = node.getChild(0).toString();
			op2 = buildExpressionFromTree((CommonTree) node.getChild(1));
			operation = minusFactory.createOperator(name, op2);
			return assignFactory.createOperator(name, null, false, operation);
		case "+=":
			name = node.getChild(0).toString();
			op2 = buildExpressionFromTree((CommonTree) node.getChild(1));
			operation = plusFactory.createOperator(name, op2);
			return assignFactory.createOperator(name, null, false, operation);
		case "&&":
			op1 = buildExpressionFromTree((CommonTree) node.getChild(0));
			op2 = buildExpressionFromTree((CommonTree) node.getChild(1));
			return logicalAndFactory.createOperator(op1, op2);
		case "||":
			op1 = buildExpressionFromTree((CommonTree) node.getChild(0));
			op2 = buildExpressionFromTree((CommonTree) node.getChild(1));
			return logicalOrFactory.createOperator(op1, op2);
		case "!": // one operand (child)
			op1 = buildExpressionFromTree((CommonTree) node.getChild(0));
			return unaryNegationFactory.createOperator(op1);
		case "==":
			op1 = buildExpressionFromTree((CommonTree) node.getChild(0));
			op2 = buildExpressionFromTree((CommonTree) node.getChild(1));
			return equalsFactory.createOperator(op1, op2);
		case "!=":
			op1 = buildExpressionFromTree((CommonTree) node.getChild(0));
			op2 = buildExpressionFromTree((CommonTree) node.getChild(1));
			return notEqualsFactory.createOperator(op1, op2);
		case "<":
			op1 = buildExpressionFromTree((CommonTree) node.getChild(0));
			op2 = buildExpressionFromTree((CommonTree) node.getChild(1));
			return lessThanFactory.createOperator(op1, op2);
		case "<=":
			op1 = buildExpressionFromTree((CommonTree) node.getChild(0));
			op2 = buildExpressionFromTree((CommonTree) node.getChild(1));
			return lessOrEqualFactory.createOperator(op1, op2);
		case ">":
			op1 = buildExpressionFromTree((CommonTree) node.getChild(0));
			op2 = buildExpressionFromTree((CommonTree) node.getChild(1));
			return greaterThanFactory.createOperator(op1, op2);
		case ">=":
			op1 = buildExpressionFromTree((CommonTree) node.getChild(0));
			op2 = buildExpressionFromTree((CommonTree) node.getChild(1));
			return greaterOrEqualFactory.createOperator(op1, op2);
		case "EXPR":
		case "PARENTESIZED_EXPR":
			return buildExpressionFromTree((CommonTree) node.getChild(0));
		case "METHOD_CALL":
			// TODO method call
			if(node.getChild(0).toString().equals(".")){
				node.getChild(0).getChild(0).toString(); // class instance
				node.getChild(0).getChild(1).toString(); // method to call
			}else{
				// class instance = this
				node.getChild(0).toString(); // method to call
			}
			break;
		case "STATIC_ARRAY_CREATOR":
			// TODO operator new
			buildTypeFromTree(node);
			if(node.getChild(0).equals("ARGUMENT_LIST")){
				buildArgumentListFromTree((CommonTree) node.getChild(1));
			}else{
				buildExpressionFromTree((CommonTree) node.getChild(1));
			}
			break;
		default:
			throw new VMParsingException("Unsupported operation '"
					+ node.toString() + "'");
		}

		return null;
	}

	/**
	 * Read variable declaration structure from given node and return list of VMField;
	 * AST Tree node [VAR_DECLARATION]
	 * 
	 * @param node
	 * @return List of VMField
	 */
	protected List<VMField> buildVarFromTree(CommonTree node) {
		List<VMField> fields = new ArrayList<>();
		CommonTree child = null;
		VMVisibilityModifier visibility = VMVisibilityModifier.getDefault();
		boolean isStatic = false;
		String type = null, name = null, strVal = null;
		Object val = null, expr = null;

		for (Object o : node.getChildren()) {
			child = (CommonTree) o;

			switch (child.toString()) {
			case "LOCAL_MODIFIER_LIST":
			case "MODIFIER_LIST":
				if (child.getChildCount() > 0) {
					visibility = VMVisibilityModifier.fromString(child
							.getChild(0).toString());
					isStatic = (child.getChildren().indexOf("static") != -1);
				}
				break;
			case "TYPE":
				type = buildTypeFromTree(child);
				break;
			case "VAR_DECLARATOR_LIST":
				for (Object o1 : child.getChildren()) {
					child = (CommonTree) o1;
					if (child.toString().equals("VAR_DECLARATOR")
							&& child.getChildCount() == 2) {
						name = child.getChild(0).toString();
						try {
							expr = buildExpressionFromTree((CommonTree) child.getChild(1).getChild(0));
							if(expr instanceof String){
								// TODO should class instance check value type when initialized?
								// YES (rebuild VMField Object val -> String val) or
								val = (String) expr;
								// NO
								val = VMUtils.getTypeProperValue(type, (String) expr);
							}else if(expr instanceof VMOperator){
								// TODO how to evaluate without env?
								val = ((VMOperator) expr).evaluate(null);
							}
						} catch (NumberFormatException e) {
							throw new VMParsingException(
									"Can not assign value '" + strVal
											+ "' to the type '" + type+"'");
						} catch (ParseException e1) {
							throw new VMParsingException(
									"Can not assign value '" + strVal
											+ "' to the type '" + type+"'");
						}
					} else if (child.toString().equals("VAR_DECLARATOR")
							&& child.getChildCount() == 1) {
						name = child.getChild(0).toString();
						val = VMUtils.getTypeDefaultValue(type);
					} else {
						throw new VMParsingException(
								"Unexpected program syntax '"
										+ child.toString());
					}
					fields.add(new VMField(name, isStatic, visibility, type,
							val));
				}
				break;
			default:
				throw new VMParsingException("Unexpected program syntax '"
						+ child.toString());
			}
		}

		return fields;
	}
}

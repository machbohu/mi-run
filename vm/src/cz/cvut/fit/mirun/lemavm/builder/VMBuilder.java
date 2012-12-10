package cz.cvut.fit.mirun.lemavm.builder;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.tree.CommonTree;

import cz.cvut.fit.mirun.lemavm.assignment.AssignOperatorFactory;
import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.VMCodeBlock;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMField;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMVisibilityModifier;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMArrayAccessOperator;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMMethodCallOperator;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMNewOperator;
import cz.cvut.fit.mirun.lemavm.structures.operators.control.NotEqualsOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.control.VMEqualsOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.control.VMGreaterEqualsOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.control.VMGreaterThanOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.control.VMLessEqualsOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.control.VMLessThanOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.control.VMLogicalAndOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.control.VMLogicalOrOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.control.VMRelationalOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMBinaryMinusOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMBinaryOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMBinaryPlusOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMDivisionOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMMultiplicationOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMPostfixDecrementOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMPostfixIncrementOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMPrefixDecrementOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMPrefixIncrementOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMUnaryMinusOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMUnaryNegationOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMUnaryOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.factories.VMUnaryPlusOperatorFactory;
import cz.cvut.fit.mirun.lemavm.utils.VMUtils;

public abstract class VMBuilder {

	private static boolean factoriesInitialized = false;
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
		if (!factoriesInitialized) {
			initOperatorFactories();
		}
	}

	private static void initOperatorFactories() {
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
		factoriesInitialized = true;
	}

	public abstract void build();

	public abstract VMCodeBlock getCodeBlock();

	/**
	 * Get type (int (int[]), string ...) from tree; Nodes [TYPE] ->
	 * [[QUALIFIED_TYPE_IDENT] ->] [VALUE]
	 * 
	 * @param node
	 * @return Type in string representation
	 */
	protected String buildTypeFromTree(CommonTree node) {
		String type = null;
		
		if (node.getChild(0).getChildCount() == 0) {
			type = node.getChild(0).toString();
		} else {
			type = node.getChild(0).getChild(0).toString();
		}
		
		if(node.getChildCount() > 1 && 
				node.getChild(1).toString().equals("ARRAY_DECLARATOR_LIST")){
			type += "[]";
		}
		
		return type;
	}

	/**
	 * Build argument list from tree; AST node [ARGUMENT_LIST]
	 * 
	 * @param node
	 * @return List of arguments (VMOperator or String as Object)
	 */
	protected List<Object> buildArgumentListFromTree(CommonTree node) {
		CommonTree child = null;
		List<Object> args = new ArrayList<>();
		
		if(node.getChildCount() > 0){
			for (Object o : node.getChildren()) {
				child = (CommonTree) o;
	
				switch (child.toString()) {
				case "EXPR":
					args.add(buildExpressionFromTree(child));
					break;
				default:
					throw new VMParsingException("Unsupported operation '"
							+ node.toString() + "'");
				}
			}
		}
		return args;
	}
	
	protected boolean buildIsStatic(CommonTree node){
		return node.toStringTree().contains("static");
	}
	
	protected boolean buildIsFinal(CommonTree node){
		return node.toStringTree().contains("final");
	}

	/**
	 * Build expression from given tree for future evaluation; i.e. a = (a + 5)
	 * * c, cls.methodCall(a, b); AST Tree node [EXPR]
	 * 
	 * @param node
	 * @return VMOperator or String as Object
	 */
	protected Object buildExpressionFromTree(CommonTree node) {
		Object op1 = null, op2 = null, operation = null, index = null;
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
			op2 = buildExpressionFromTree((CommonTree) node.getChild(1));
			
			if(node.getChild(0).toString().equals("ARRAY_ELEMENT_ACCESS")){
				name = node.getChild(0).getChild(0).toString();
				index = buildExpressionFromTree((CommonTree) node.getChild(0).getChild(1));
				return assignFactory.createOperator(name, null, index, op2);
			}else{
				name = node.getChild(0).toString();
				return assignFactory.createOperator(name, null, false, op2);
			}
		case "-=":
			// TODO array access
			name = node.getChild(0).toString();
			op2 = buildExpressionFromTree((CommonTree) node.getChild(1));
			operation = minusFactory.createOperator(name, op2);
			return assignFactory.createOperator(name, null, false, operation);
		case "+=":
			// TODO array access
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
			Object receiver = "this";

			if (node.getChild(0).toString().equals(".")) {
				// class instance
				receiver = buildExpressionFromTree((CommonTree) node.getChild(0).getChild(0));
				// method to call
				name = node.getChild(0).getChild(1).toString();
			} else {
				// receiver = "this"
				// method to call
				name = node.getChild(0).toString();
			}
			return new VMMethodCallOperator(receiver, name,
					buildArgumentListFromTree((CommonTree) node.getChild(1)));
		case "STATIC_ARRAY_CREATOR":
			String type = buildTypeFromTree(node);
			
			if (node.getChild(1).toString().equals("ARGUMENT_LIST")) {
				List<Object> args = buildArgumentListFromTree((CommonTree) node.getChild(1));
				return new VMNewOperator(type, args); // new Constructor()
			} else {
				Object len = buildExpressionFromTree((CommonTree) node.getChild(1));
				return new VMNewOperator(type, len); // new double[5]
			}
		case "ARRAY_ELEMENT_ACCESS":
			name = node.getChild(0).toString();
			index = buildExpressionFromTree((CommonTree) node.getChild(1));
			return new VMArrayAccessOperator(name, index);
		default:
			throw new VMParsingException("Unsupported operation '"
					+ node.toString() + "'");
		}
	}

	/**
	 * Read variable declaration structure from given node and return list of
	 * VMField; AST Tree node [VAR_DECLARATION]
	 * 
	 * @param node
	 * @return List of VMField (VMField.val contains String(var_name, number,
	 *         "string"), VMOperator or if not initialized
	 *         VMUtils.getTypeDefaultValue)
	 */
	protected List<VMField> buildVarFromTree(CommonTree node) {
		List<VMField> fields = new ArrayList<>();
		CommonTree child = null;
		VMVisibilityModifier visibility = VMVisibilityModifier.getDefault();
		boolean isStatic = false, isFinal = false;
		String type = null, name = null;
		Object val = null;

		if(node.getChildCount() > 0){
			for (Object o : node.getChildren()) {
				child = (CommonTree) o;
	
				switch (child.toString()) {
				case "LOCAL_MODIFIER_LIST":
				case "MODIFIER_LIST":
					// TODO check for final
					if (child.getChildCount() > 0) {
						visibility = VMVisibilityModifier.fromString(child
								.getChild(0).toString());
						isStatic = buildIsStatic(child);
						isFinal = buildIsFinal(child);
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
							val = buildExpressionFromTree((CommonTree) child
									.getChild(1));
						} else if (child.toString().equals("VAR_DECLARATOR")
								&& child.getChildCount() == 1) {
							name = child.getChild(0).toString();
							val = VMUtils.getTypeDefaultValue(type);
						} else {
							throw new VMParsingException(
									"Unexpected program syntax '"
											+ child.toString());
						}
						fields.add(new VMField(name, isStatic, isFinal, visibility, type,
								val));
					}
					break;
				default:
					throw new VMParsingException("Unexpected program syntax '"
							+ child.toString());
				}
			}
		}

		return fields;
	}
}

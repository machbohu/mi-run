package cz.cvut.fit.mirun.lemavm.builder;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

import cz.cvut.fit.mirun.lemavm.core.VMUtils;
import cz.cvut.fit.mirun.lemavm.exceptions.VMParsingException;
import cz.cvut.fit.mirun.lemavm.structures.VMCodeBlock;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMField;
import cz.cvut.fit.mirun.lemavm.structures.classes.VMVisibilityModifier;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMBinaryMinusOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMBinaryOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMBinaryPlusOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMDivisionOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMMultiplicationOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMPostfixDecrementOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMPostfixIncrementOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMPrefixDecrementOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMPrefixIncrementOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMUnaryMinusOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMUnaryNegationOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMUnaryOperatorFactory;
import cz.cvut.fit.mirun.lemavm.structures.operators.VMUnaryPlusOperatorFactory;

public abstract class VMBuilder {

	// Operator factories
	protected VMBinaryOperatorFactory minusFactory;
	protected VMBinaryOperatorFactory plusFactory;
	protected VMBinaryOperatorFactory divisionFactory;
	protected VMBinaryOperatorFactory multiplicationFactory;
	protected VMUnaryOperatorFactory postfixDecrementFactory;
	protected VMUnaryOperatorFactory postfixIncrementFactory;
	protected VMUnaryOperatorFactory prefixDecrementFactory;
	protected VMUnaryOperatorFactory prefixIncrementFactory;
	protected VMUnaryOperatorFactory unaryMinusFactory;
	protected VMUnaryOperatorFactory unaryPlusFactory;
	protected VMUnaryOperatorFactory unaryNegationFactory;

	// TODO Relational operator factories should have the same API as binary and
	// unary operator factories

	public VMBuilder() {
		this.minusFactory = new VMBinaryMinusOperatorFactory();
		this.plusFactory = new VMBinaryPlusOperatorFactory();
		this.divisionFactory = new VMDivisionOperatorFactory();
		this.multiplicationFactory = new VMMultiplicationOperatorFactory();
		this.postfixDecrementFactory = new VMPostfixDecrementOperatorFactory();
		this.postfixIncrementFactory = new VMPostfixIncrementOperatorFactory();
		this.prefixDecrementFactory = new VMPrefixDecrementOperatorFactory();
		this.prefixIncrementFactory = new VMPrefixIncrementOperatorFactory();
		this.unaryMinusFactory = new VMUnaryMinusOperatorFactory();
		this.unaryPlusFactory = new VMUnaryPlusOperatorFactory();
		this.unaryNegationFactory = new VMUnaryNegationOperatorFactory();

	}

	public abstract void build() throws RecognitionException;

	public abstract VMCodeBlock getCodeBlock();

	protected String buildTypeFromTree(CommonTree node) {
		if (node.getChild(0).getChildCount() == 0) {
			return node.getChild(0).toString();
		} else {
			return node.getChild(0).getChild(0).toString();
		}
	}

	/**
	 * Build expression from given tree for future evaluation, i.e. a = (a + 5)
	 * * c; AST Tree node [EXPR]
	 * 
	 * @param node
	 * @return
	 */
	protected Object buildExpressionFromTree(CommonTree node) {
		Object op1 = null, op2 = null;

		if (node.getChildCount() <= 0) {
			return node.toString();
		}

		switch (node.toString()) {
		case "+":
			// VMBinaryOperatorFactory bin = new VMBinaryPlusOperatorFactory();
			// op1 = getExpressionFromTree((CommonTree) node.getChild(0));
			// op2 = getExpressionFromTree((CommonTree) node.getChild(1));
			// return bin.createOperator(op1, op2);
			break;
		case "POST_INC": // one operand (child)

			break;
		case "PRE_INC": // one operand (child)

			break;
		case "UNARY_PLUS": // one operand (child)

			break;
		case "-":

			break;
		case "POST_DEC": // one operand (child)

			break;
		case "PRE_DEC": // one operand (child)

			break;
		case "UNARY_MINUS": // one operand (child)

			break;
		case "*":

			break;
		case "/":

			break;
		case "=":

			break;
		case "-=":

			break;
		case "+=":

			break;
		case "&&":

			break;
		case "||":

			break;
		case "!": // one operand (child)

			break;
		case "==":

			break;
		case "!=":

			break;
		case "<=":

			break;
		case ">=":

			break;
		case "EXPR":
		case "PARENTESIZED_EXPR":
			return buildExpressionFromTree((CommonTree) node.getChild(0));
		case "METHOD_CALL":
			break;
		default:
			throw new VMParsingException("Unsupported operation '"
					+ node.toString() + "'");
		}

		return null;
	}

	/**
	 * Read variable structure from given node and return list of VMField AST
	 * Tree node [VAR_DECLARATION]
	 * 
	 * @param node
	 * @param caller
	 *            - Object, that calls this method
	 * @return List of VMField
	 */
	protected List<VMField> buildVarFromTree(CommonTree node) {
		List<VMField> fields = new ArrayList<>();
		CommonTree child = null;
		VMVisibilityModifier visibility = VMVisibilityModifier.getDefault();
		boolean isStatic = false;
		String type = null, name = null, strVal = null;
		Object val = null;

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
							// TODO build expression (buildExpressionFromTree)
							// and evaluate it
							strVal = child.getChild(1).getChild(0).toString();
							val = VMUtils.getTypeProperValue(type, strVal);
						} catch (NumberFormatException e) {
							throw new VMParsingException(
									"Can not assign value '" + strVal
											+ "' to the type '" + type);
						} catch (ParseException e1) {
							throw new VMParsingException(
									"Can not assign value '" + strVal
											+ "' to the type '" + type);
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

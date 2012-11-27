package cz.cvut.fit.mirun.lemavm.tests.core;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenRewriteStream;
import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;

import cz.cvut.fit.mirun.lemavm.antlr.LeMaVMLexer;
import cz.cvut.fit.mirun.lemavm.antlr.LeMaVMParser;

public class ASTTreeTest {

	public void printTree(CommonTree t, int indent) {
		if (t != null) {
			StringBuffer sb = new StringBuffer(indent);

			if (t.getParent() == null) {
				System.out.println(sb.toString() + t.getText());
			}
			for (int i = 0; i < indent; i++)
				sb = sb.append("   ");
			for (int i = 0; i < t.getChildCount(); i++) {
				System.out.println(sb.toString() + t.getChild(i).toString());
				printTree((CommonTree) t.getChild(i), indent + 1);
			}
		}
	}

	@Test
	public void test() {
		CharStream chs = new ANTLRStringStream("class Test {\n"
				+ "    int b = 5 + 6 + 6; \n" + "    class Inside {\n"
				+ "    }\n" + "}");
		LeMaVMLexer lexer = new LeMaVMLexer(chs);
		TokenRewriteStream tokens = new TokenRewriteStream(lexer);
		LeMaVMParser parser = new LeMaVMParser(tokens);
		try {
			CommonTree tree = (CommonTree) parser.javaSource().getTree();
			printTree(tree, 0);
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
	}

}

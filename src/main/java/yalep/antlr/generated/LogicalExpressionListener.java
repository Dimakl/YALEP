// Generated from /home/dimakl/IdeaProjects/inflate-my-mind/src/main/java/com/inflatemymind/antlr/LogicalExpression.g4 by ANTLR 4.7.2
package yalep.antlr.generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LogicalExpressionParser}.
 */
public interface LogicalExpressionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LogicalExpressionParser#eval}.
	 * @param ctx the parse tree
	 */
	void enterEval(LogicalExpressionParser.EvalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogicalExpressionParser#eval}.
	 * @param ctx the parse tree
	 */
	void exitEval(LogicalExpressionParser.EvalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OR}
	 * labeled alternative in {@link LogicalExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOR(LogicalExpressionParser.ORContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OR}
	 * labeled alternative in {@link LogicalExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOR(LogicalExpressionParser.ORContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PARENS}
	 * labeled alternative in {@link LogicalExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPARENS(LogicalExpressionParser.PARENSContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PARENS}
	 * labeled alternative in {@link LogicalExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPARENS(LogicalExpressionParser.PARENSContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VARIABLE}
	 * labeled alternative in {@link LogicalExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVARIABLE(LogicalExpressionParser.VARIABLEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VARIABLE}
	 * labeled alternative in {@link LogicalExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVARIABLE(LogicalExpressionParser.VARIABLEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AND}
	 * labeled alternative in {@link LogicalExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAND(LogicalExpressionParser.ANDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AND}
	 * labeled alternative in {@link LogicalExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAND(LogicalExpressionParser.ANDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code XOR}
	 * labeled alternative in {@link LogicalExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterXOR(LogicalExpressionParser.XORContext ctx);
	/**
	 * Exit a parse tree produced by the {@code XOR}
	 * labeled alternative in {@link LogicalExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitXOR(LogicalExpressionParser.XORContext ctx);
}
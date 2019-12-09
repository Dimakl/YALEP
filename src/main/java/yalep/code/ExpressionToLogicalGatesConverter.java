package yalep.code;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import yalep.antlr.generated.LogicalExpressionLexer;
import yalep.antlr.generated.LogicalExpressionParser;
import yalep.exceptions.WrongExpressionFormatException;

public class ExpressionToLogicalGatesConverter {

    private String expression;
    private Integer answer;

    public ExpressionToLogicalGatesConverter(String expression) throws WrongExpressionFormatException {
        LogicalExpressionValidityChecker.expressionIsValid(expression);
        this.expression = expression.substring(0, expression.indexOf("="));
        answer = Integer.parseInt(expression.substring(expression.indexOf("=") + 1));
    }
}

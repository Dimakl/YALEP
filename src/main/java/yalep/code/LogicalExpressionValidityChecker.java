package yalep.code;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import yalep.antlr.LogicalExpressionErrorListener;
import yalep.antlr.generated.LogicalExpressionLexer;
import yalep.antlr.generated.LogicalExpressionParser;
import yalep.exceptions.WrongExpressionFormatException;

import java.util.HashSet;
import java.util.Set;

public class LogicalExpressionValidityChecker {

    // on change of grammar should change it too
    private static final String ALLOWED_TOKENS = "()!&|^ABCDEFGHIJKLMNOPQRSTUVWXYZ";


    public static void main(String[] args) {
        try {
            expressionIsValid("A&B&C&D=0");
            System.out.println();
        } catch (WrongExpressionFormatException e) {
            System.out.println("12321321321");
        }
    }


    protected static void expressionIsValid(String rawExpression) throws WrongExpressionFormatException {
        String expression = getLogicalExpressionAndValidateBasics(rawExpression);
        checkSyntaxErrors(expression);
        checkInvalidTokens(expression);

    }

    private static void checkSyntaxErrors(String expression) throws WrongExpressionFormatException {
        LogicalExpressionLexer lexer = new LogicalExpressionLexer(CharStreams.fromString(expression));
        lexer.removeErrorListeners();
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LogicalExpressionParser parser = new LogicalExpressionParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new LogicalExpressionErrorListener());
        try {
            parser.eval();
        } catch (RuntimeException e) {
            throw new WrongExpressionFormatException(e.getMessage());
        }
        if (parser.getNumberOfSyntaxErrors() != 0) {
            throw new WrongExpressionFormatException("Expression has syntax errors");
        }
    }

    private static void checkInvalidTokens(String expression) throws WrongExpressionFormatException {
        Set<Character> tokenSet = new HashSet<>();
        for (Character c : ALLOWED_TOKENS.toCharArray()) {
            tokenSet.add(c);
        }
        for (Character c : expression.toCharArray()) {
            if (!tokenSet.contains(c)) {
                throw new WrongExpressionFormatException("Expression contains wrong tokens");
            }
        }
    }

    private static String getLogicalExpressionAndValidateBasics(String rawExpression) throws WrongExpressionFormatException {
        int equalSignPos = rawExpression.indexOf("=");
        if (equalSignPos == -1) {
            throw new WrongExpressionFormatException("Expression doesn't contain '='");
        }
        String answerString = rawExpression.substring(equalSignPos + 1);

        if (!(answerString.equals("1") || answerString.equals("0"))) {
            throw new WrongExpressionFormatException("Wrong answer format");
        }

        return  rawExpression.substring(0, equalSignPos);
    }

}

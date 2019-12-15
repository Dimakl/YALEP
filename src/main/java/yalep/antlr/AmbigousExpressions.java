package yalep.antlr;

import java.util.HashSet;

public class AmbigousExpressions {

    private static HashSet<String> ambiguousExpressions;

    protected static void addAmbiguousExpression(String expression) {
        ambiguousExpressions.add(expression);
    }

    public static Boolean isExpressionAmbiguous(String expression) {
        return ambiguousExpressions.contains(expression);
    }

}

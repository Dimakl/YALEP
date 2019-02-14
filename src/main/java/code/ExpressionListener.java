package code;

import antlr.LogExpBaseListener;
import antlr.LogExpLexer;
import antlr.LogExpParser;
import org.antlr.v4.runtime.Vocabulary;

import java.util.Map;

import java.util.*;


public class ExpressionListener extends LogExpBaseListener {

    // type of vars is String, because Strings could be used as vars in future
    private HashSet<String> vars = new HashSet<>();
    private HashMap<String, ArrayList<Integer> > entries = new HashMap<>();
    private LogExpLexer lexer;
    // string array in future should be changed to reference array
    private HashMap<String, ArrayList<String> > nodeMap;

    // such a redundancy is made for future development
    public static final String PASS_NODE = "pass";
    public static final String CREATE_NODE = "create";
    public static final String DEAD_NODE = "dead";

    public ExpressionListener(LogExpLexer lexer) {
        this.lexer = lexer;
        nodeMap = new HashMap<String, ArrayList<String>>();
    }

    public List<String> getVars() {
        return new ArrayList<String>(vars);
    }

    public HashMap<String, ArrayList<String>> getNodeMap() {
        return nodeMap;
    }


    /*
        One of important features from antlr is .getStartIndex()
        because it could be used as identificator of function
        so, example:
        (A&B)|(A&B)&C=1
        here we see 2 A&B, and they identify as 2 and 8
        ...&C identifies as 11
        so when we see ...&C we should:
        1. delete all () from ... [it may be changed later]
        2. find the closest from left index of ... in array of ...
           in this case: we should have a dictionary with A&B
           in here we contain all indices of this expression entries
           like A&B: 1,3,21,34
        3. we change array in another dict with entry keys, like
           A&B[21], and we change this key value.
        So that feature must be made
     */

    @Override
    public void exitBinaryExpression(LogExpParser.BinaryExpressionContext ctx) {
        Vocabulary vocabulary = lexer.getVocabulary();
        String leftOp = ctx.left.getText(),
                rightOp = ctx.right.getText(),
                op = ctx.op.getText(),
                fullOpName = leftOp + op + rightOp;
        leftOp = UtilityMethods.deleteBrackets(leftOp);
        rightOp = UtilityMethods.deleteBrackets(rightOp);
        Integer idIndex = ctx.op.getStart().getStartIndex();
        entries.putIfAbsent(fullOpName, new ArrayList<>());
        entries.get(fullOpName).add(idIndex);
        String opWithIndex = fullOpName + idIndex;
        nodeMap.put(opWithIndex, new ArrayList<>());

        int rightOpIndex = UtilityMethods.searchRight(entries.get(rightOp), idIndex, rightOp),
            leftOpIndex = UtilityMethods.searchLeft(entries.get(leftOp), idIndex, leftOp);
        String leftOpWithIndex = leftOp + leftOpIndex;
        String rightOpWithIndex = rightOp + rightOpIndex;

        int leftLen = nodeMap.get(leftOpWithIndex).size(),
            rightLen = nodeMap.get(rightOpWithIndex).size();
        int maxLen = (leftLen > rightLen) ? leftLen : rightLen;
        nodeMap.get(leftOpWithIndex).addAll(Collections.nCopies(maxLen - leftLen, PASS_NODE));
        nodeMap.get(rightOpWithIndex).addAll(Collections.nCopies(maxLen - rightLen, PASS_NODE));
        nodeMap.get(opWithIndex).addAll(Collections.nCopies(maxLen, PASS_NODE));
        nodeMap.get(leftOpWithIndex).add(opWithIndex);
        nodeMap.get(rightOpWithIndex).add(opWithIndex);
        nodeMap.get(opWithIndex).add(CREATE_NODE);
    }

    @Override
    public void exitIdentifierExpression(LogExpParser.IdentifierExpressionContext ctx) {
        nodeMap.putIfAbsent(ctx.id.getText()+"0",
                new ArrayList<String>() {{
                    add(CREATE_NODE);
                }}
        );
    }

    @Override
    public void exitNotExpression(LogExpParser.NotExpressionContext ctx) {
    }


    @Override
    public void enterIdentifierExpression(LogExpParser.IdentifierExpressionContext ctx) {
        vars.add(ctx.id.getText()+"0");
        entries.putIfAbsent(ctx.id.getText(),
                new ArrayList<Integer>() {{
                    add(0);
                }}
                );
    }

}

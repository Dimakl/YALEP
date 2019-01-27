package code;

import antlr.LogExpBaseListener;
import antlr.LogExpLexer;
import antlr.LogExpParser;
import org.antlr.v4.runtime.Vocabulary;

import java.util.Map;

import java.util.*;


public class ExpressionListener extends LogExpBaseListener {

    // type of vars is String, because Strings could be used as vars in future
    private HashSet<String> vars = new HashSet<String>();
    private LogExpLexer lexer;
    // string array in future should be changed to reference array
    private HashMap<String, ArrayList<String>> nodeMap;

    // such a redundancy is made for future development
    public final String PASS_NODE = "pass";
    public final String CREATE_NODE = "create";
    public final String DEAD_NODE = "dead";

    public ExpressionListener(LogExpLexer lexer) {
        this.lexer = lexer;
        nodeMap = new HashMap<String, ArrayList<String>>();
    }

    public List<String> getVars() {
        return new ArrayList<String>(vars);
    }

    // method for testing TODO: delete this method
    private void printNodeMap() {
        for (String item : nodeMap.keySet()) {
            System.out.print(item + ": ");
            for (String nodePos : nodeMap.get(item))
                System.out.print(nodePos + " ");
            System.out.println();
        }
        System.out.println();
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
        System.out.println(ctx.getText()+": "+ctx.op.getStart().getStartIndex());
        String leftOp = ctx.left.getText(),
                rightOp = ctx.right.getText(),
                op = ctx.op.getText(),
                fullOpName = leftOp + op + rightOp;
        if (!nodeMap.containsKey(fullOpName))
            nodeMap.put(fullOpName, new ArrayList<String>());
        else {
            int i;
            for (i = 2; i < 20; i++)
                if (!nodeMap.containsKey(fullOpName + "[" + i + "]")) {
                    fullOpName = fullOpName + "[" + i + "]";
                    nodeMap.put(fullOpName, new ArrayList<>());
                    break;
                }
        }

        //TODO: main problem now is to detect collisions and give unique IDs to each expression, like A&B created on 3rd iteration and A&B created on 5th iteration

        System.out.println(ctx.right.getText());
        int leftLen = nodeMap.get(leftOp).size(),
                rightLen = nodeMap.get(rightOp).size();
        int maxLen = (leftLen > rightLen) ? leftLen : rightLen;
        nodeMap.get(leftOp).addAll(Collections.nCopies(maxLen - leftLen, PASS_NODE));
        nodeMap.get(rightOp).addAll(Collections.nCopies(maxLen - rightLen, PASS_NODE));
        nodeMap.get(fullOpName).addAll(Collections.nCopies(maxLen, PASS_NODE));

        nodeMap.get(leftOp).add(fullOpName);
        nodeMap.get(rightOp).add(fullOpName);
        nodeMap.get(fullOpName).add(CREATE_NODE);

        printNodeMap();
    }


    //TODO: make realization of these 2 methods:
    @Override
    public void exitIdentifierExpression(LogExpParser.IdentifierExpressionContext ctx) {
        nodeMap.putIfAbsent(ctx.id.getText(),
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
        vars.add(ctx.id.getText());
    }

}

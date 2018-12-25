package code;

import antlr.LogExpBaseListener;
import antlr.LogExpParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class ExpressionListener extends LogExpBaseListener{

    @Override
    public void enterBinaryExpression(LogExpParser.BinaryExpressionContext ctx) {
        // TODO: understand what must be happening here
        System.out.println(ctx.toString());
    }
}

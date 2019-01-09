package code;

import antlr.LogExpBaseListener;
import antlr.LogExpLexer;
import antlr.LogExpParser;
import org.antlr.v4.runtime.Vocabulary;

import java.util.*;

public class ExpressionListener extends LogExpBaseListener{

    // type of vars is String, because Strings could be used as vars in future
    private HashSet<String> vars = new HashSet<String>();
    private LogExpLexer lexer;

    public ExpressionListener(LogExpLexer lexer){
        this.lexer = lexer;
    }

    public List<String> getVars(){
        return new ArrayList<String>(vars);
    }


    @Override
    public void exitBinaryExpression(LogExpParser.BinaryExpressionContext ctx) {
        //TODO: understand what must be happening here
        Vocabulary vocabulary =  lexer.getVocabulary();
        System.out.println(ctx.toString()+":");
        for (LogExpParser.ExpressionContext expCtx : ctx.expression()){
            System.out.println(expCtx.depth());
        }
        System.out.println();
    }


    //TODO: make realization of these 2 methods:
    @Override
    public void exitIdentifierExpression(LogExpParser.IdentifierExpressionContext ctx) { }

    @Override
    public void exitNotExpression(LogExpParser.NotExpressionContext ctx) { }


    @Override
    public void enterIdentifierExpression(LogExpParser.IdentifierExpressionContext ctx) {
        vars.add(ctx.id.getText());
    }

}

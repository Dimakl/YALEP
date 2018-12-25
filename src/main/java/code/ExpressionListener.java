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

    ExpressionListener(LogExpLexer lexer){
        this.lexer = lexer;
    }

    public List<String> getVars(){
        List<String> varsList = new ArrayList<String>();
        Iterator<String> iterator = vars.iterator();
        while (iterator.hasNext()){
            varsList.add(iterator.next());
        }
        return varsList;
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

    @Override
    public void enterIdentifierExpression(LogExpParser.IdentifierExpressionContext ctx) {
        vars.add(ctx.id.getText());
    }

}

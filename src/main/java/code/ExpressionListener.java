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
    // string array in future should be changed to reference array
    private HashMap<String,ArrayList<String>> nodeMap = new HashMap<String, ArrayList<String>>();

    // such a redundancy is made for future development
    public final String PASS_NODE = "pass";

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
    public void exitIdentifierExpression(LogExpParser.IdentifierExpressionContext ctx) {
        nodeMap.put(ctx.id.getText(), new ArrayList<String>());
    }

    @Override
    public void exitNotExpression(LogExpParser.NotExpressionContext ctx) { }


    @Override
    public void enterIdentifierExpression(LogExpParser.IdentifierExpressionContext ctx) {
        vars.add(ctx.id.getText());
    }

}

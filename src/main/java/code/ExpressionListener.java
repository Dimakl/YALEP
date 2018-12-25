package code;

import antlr.LogExpBaseListener;
import antlr.LogExpLexer;
import antlr.LogExpParser;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class ExpressionListener extends LogExpBaseListener{

    private LogExpLexer lexer;

    ExpressionListener(LogExpLexer lexer){
        this.lexer = lexer;
    }

    @Override
    public void enterBinaryExpression(LogExpParser.BinaryExpressionContext ctx) {
        //TODO: understand what must be happening here
        Vocabulary vocabulary =  lexer.getVocabulary();

        System.out.println();
    }
}

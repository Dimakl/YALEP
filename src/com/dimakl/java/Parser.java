package com.dimakl.java;

import org.antlr.v4.runtime.*;
import com.dimakl.antlr.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;


public class Parser {

    public static void main(String[] args) {
        String input = "A and B = 1";
        CharStream stream = CharStreams.fromString(input);
        // To re-use the parser+lexer instances, call their 'reset()' methods after setting their input streams.
        LogExpLexer lexer = new LogExpLexer(stream);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        LogExpParser logExpParser = new LogExpParser(tokenStream);
        LogExpParser.ParseContext parseContext = logExpParser.parse();
        System.out.println(parseContext.expression());
    }
}

class ExpressionListener extends LogExpBaseListener {

    @Override
    public void enterIdentifierExpression(LogExpParser.IdentifierExpressionContext ctx) {
        super.enterIdentifierExpression(ctx);
    }

    @Override
    public void exitBinary(LogExpParser.BinaryContext ctx) {
        super.exitBinary(ctx);
    }

    @Override
    public void exitBinaryExpression(LogExpParser.BinaryExpressionContext ctx) {
        super.exitBinaryExpression(ctx);
    }
}

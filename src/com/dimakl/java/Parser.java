package com.dimakl.java;

import org.antlr.v4.runtime.*;
import com.dimakl.antlr.*;
import org.antlr.v4.runtime.atn.ATN;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;


public class Parser {

    public static void main(String[] args) {
        String input = "A and B = 1";
        CharStream stream = CharStreams.fromString(input);
        // To re-use the parser+lexer instances, call their 'reset()' methods after setting their input streams.
        LogExpLexer lexer = new LogExpLexer(stream);
        TokenStream tokenStream =  new CommonTokenStream(lexer) ;
        LogExpParser logExpParser = new LogExpParser(tokenStream);
        LogExpParser.ParseContext parseContext =  logExpParser.parse();
        System.out.println(parseContext.expression());
    }
}

class Lexer extends LogExpLexer{

    @Override
    public String[] getTokenNames() {
        return super.getTokenNames();
    }

    @Override
    public Vocabulary getVocabulary() {
        return super.getVocabulary();
    }

    public Lexer(CharStream input) {
        super(input);
    }

    @Override
    public String getGrammarFileName() {
        return super.getGrammarFileName();
    }

    @Override
    public String[] getRuleNames() {
        return super.getRuleNames();
    }

    @Override
    public String getSerializedATN() {
        return super.getSerializedATN();
    }

    @Override
    public String[] getChannelNames() {
        return super.getChannelNames();
    }

    @Override
    public String[] getModeNames() {
        return super.getModeNames();
    }

    @Override
    public ATN getATN() {
        return super.getATN();
    }
}

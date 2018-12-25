package code;

import antlr.LogExpLexer;
import antlr.LogExpParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Parser {
    public static void main(String args[]){

        // TODO: this part of code must be @Test
        String testInp = "A&B&C|A=1";
        LogExpLexer lexer = new LogExpLexer(CharStreams.fromString(testInp));

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LogExpParser parser = new LogExpParser(tokens);
        ParseTree tree = parser.eval();
        ParseTreeWalker walker = new ParseTreeWalker();
        ExpressionListener listener = new ExpressionListener();
        walker.walk(listener, tree);
    }
}

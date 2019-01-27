package code;

import antlr.LogExpLexer;
import antlr.LogExpParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.List;

public class Parser {
    public static void main(String args[]) {
        //TODO: fault in parsing input is caught in ExpressionListener and fails the build, example: "A&B|(A&B|C=1)"
        //TODO: fix problems with brackets: in parsing and in operation order

        // TODO: this part of code must be @Test
        String testInp = "A&B&(A&B)=1"; //"A&B&C|A=0";
        LogExpLexer lexer = new LogExpLexer(CharStreams.fromString(testInp));

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LogExpParser parser = new LogExpParser(tokens);
        ParseTree tree = parser.eval();
        ParseTreeWalker walker = new ParseTreeWalker();
        ExpressionListener listener = new ExpressionListener(lexer);
        walker.walk(listener, tree);
        List<String> vars = listener.getVars();
        for (String variable : vars) {
            System.out.println(variable);
        }
        //System.out.println(((((LogExpParser.EvalContext) tree).BOOL())));
    }
}

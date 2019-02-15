package code;

import antlr.LogExpLexer;
import antlr.LogExpParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.*;

public class Parser {

    final static public class ParsedData {
        public final HashMap<String, ArrayList<String>> nodeMap;
        public final List<String> vars;

        public ParsedData(HashMap<String, ArrayList<String>> nodeMap, List<String> vars) {
            this.nodeMap = nodeMap;
            this.vars = vars;
        }
    }

    private static HashMap<String, ArrayList<String>> nodeMap;
    // for debug purposes only!!!
    public static void printNodeMap() {
        for (String key : nodeMap.keySet()) {
            System.out.print(key+": ");
            for (String el : nodeMap.get(key))
                System.out.print(el+" ");
            System.out.println();
        }
    }

    public static ParsedData createNodeMap(String expression) {
        LogExpLexer lexer = new LogExpLexer(CharStreams.fromString(expression));
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
        nodeMap = listener.getNodeMap();
        UtilityMethods.cropNodeMap(nodeMap);
        printNodeMap();
        return new ParsedData(nodeMap, vars);
    }

    public static void main(String args[]) {
        //TODO: fix problems with brackets: in parsing and in operation order
        ArrayList<String> tokens = PostfixNotation.tokenizeExpression("((A&B)|C&D)&A");
        Queue<String> postfixNotation = PostfixNotation.generatePostfixNotation(tokens);
        while (!postfixNotation.isEmpty()) {
            System.out.print(postfixNotation.poll());
        }
        //createNodeMap("A&B=1");
    }
}

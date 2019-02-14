package code;

import antlr.LogExpLexer;
import antlr.LogExpParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class Parser {


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

    public static void main(String args[]) {
        //TODO: fault in parsing input is caught in ExpressionListener and fails the build, example: "A&B|(A&B|C=1)"
        //TODO: fix problems with brackets: in parsing and in operation order

        String testInp = "A&B|C=0"; //"A&B&C|A=0";
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
        nodeMap = listener.getNodeMap();
        UtilityMethods.cropNodeMap(nodeMap);
        printNodeMap();
    }
}

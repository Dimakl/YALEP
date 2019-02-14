package code;


import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class UtilityMethods {

    public static String deleteBrackets(String s) {
        int iter = 0;
        while (iter < s.length()) {
            if (s.charAt(iter) == '(' && s.charAt(s.length() - iter - 1) == ')') {
                iter++;
            }
            else {
                break;
            }
        }
        return s.substring(iter, s.length() - iter );
    }
    // the asymptotic of these 2 functions should be improved to O(n*log(n))
    public static int searchLeft(ArrayList<Integer> array, int element, String operation) {
        if (operation.length() == 1)
            return 0;
        Collections.sort(array);
        for (int i = array.size() - 1; i >= 0; i--) {
            if (array.get(i) < element) {
                return array.get(i);
            }
        }
        return -1; // can not be called actually
    }

    public static int searchRight(ArrayList<Integer> array, int element, String operation) {
        if (operation.length() == 1)
            return 0;
        Collections.sort(array);
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > element) {
                return array.get(i);
            }
        }
        return -1; // can not be called actually
    }

    private static ArrayList<Boolean> nextSolution(ArrayList<Boolean> solution, Integer pos) {
        if (pos == solution.size()) {
            return null;
        }
        else if (!solution.get(pos)) {
            solution.set(pos, true);
            return solution;
        }
        else {
            solution.set(pos, false);
            nextSolution(solution, pos + 1);
        }
    }

    public static checkSolution(Parser.ParsedData parsedData, ArrayList<Boolean> solution) {

    }

    public static ArrayList<Boolean> findNodeMapSolution(Parser.ParsedData parsedData) {
        HashMap<String, ArrayList<String>> nodeMap = parsedData.nodeMap;
        List<String> vars = parsedData.vars;
        ArrayList<Boolean> solution = new ArrayList<>(Collections.nCopies(vars.size(), false));
        while (solution != null) {

            solution = nextSolution(solution, 0);
        }
    }

    protected static void cropNodeMap(HashMap<String,ArrayList <String>> nodeMap) {
        for (String key : nodeMap.keySet()) {
            int i = nodeMap.get(key).size() - 1;
            for (;i >= 0; i--) {
                if (!nodeMap.get(key).get(i).equals(ExpressionListener.PASS_NODE))
                    break;
            }
            nodeMap.put(key, new ArrayList<String>(nodeMap.get(key).subList(0,i)));
            nodeMap.get(key).add(ExpressionListener.DEAD_NODE);
        }
    }

}

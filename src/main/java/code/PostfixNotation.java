package code;

import java.util.*;

public class PostfixNotation {

    private static HashMap<String, Integer> precedence = new HashMap<String, Integer>() {{
        put("^", 3);
        put("&", 2);
        put("|", 1);
        put("(", 0);
    }};

    public static ArrayList<String> tokenizeExpression(String expression) {
        expression = UtilityMethods.formatExpression(expression);
        ArrayList<String> tokens = new ArrayList<String>();
        for (Character c : expression.toCharArray())
            tokens.add(c.toString());
        return tokens;
    }

    // TODO: make private (public for testing)
    public static Queue<String> generatePostfixNotation(ArrayList<String> tokenizedExpression) {
        Queue<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();

        for (String token : tokenizedExpression) {
            if ("(".equals(token)) {
                stack.push(token);
                continue;
            }

            if (")".equals(token)) {
                while (!"(".equals(stack.peek())) {
                    queue.add(stack.pop());
                }
                stack.pop();
                continue;
            }
            if (precedence.containsKey(token)) {
                while (!stack.empty() && precedence.get(token) <= precedence.get(stack.peek())) {
                    queue.add(stack.pop());
                }
                stack.push(token);
                continue;
            }

            queue.add(token);
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        return queue;
    }

}

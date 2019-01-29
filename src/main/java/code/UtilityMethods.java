package code;

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
        return s.substring(iter, s.length() - iter - 1);
    }
}

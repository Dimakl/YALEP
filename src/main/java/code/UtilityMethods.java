package code;

import java.util.ArrayList;
import java.util.Collections;

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
    public static int searchLeft(ArrayList<Integer> array, int element) {
        Collections.sort(array);
        for (int i = array.size() - 1; i >= 0; i--) {
            if (array.get(i) < element) {
                return i;
            }
        }
        return -1; // can not be called actually
    }

    public static int searchRight(ArrayList<Integer> array, int element) {
        Collections.sort(array);
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > element) {
                return i;
            }
        }
        return -1; // can not be called actually
    }
}

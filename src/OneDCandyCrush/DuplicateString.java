package OneDCandyCrush;

import java.util.Stack;

public class DuplicateString {

    public static String removeDups(String s) {
        StringBuilder sbr = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < sbr.length(); i++) {
            if (i == 0) {
                stack.push(1);
            } else if (i != 0 && sbr.charAt(i) == sbr.charAt(i - 1)) {
                int topElem = stack.pop() + 1;
                stack.push(topElem);
            } else if (i != 0 && sbr.charAt(i) != sbr.charAt(i - 1)) {
                if (stack.peek() >= 3) {
                    int k = stack.pop();
                    sbr.delete(i - 1 - k + 1, i);
                    i = i - k - 1;

                } else {
                    stack.push(1);
                }
            }
        }

        if (!stack.isEmpty() && stack.peek() >= 3) {
            int n = sbr.length();
            int k = stack.pop();
            sbr.delete(n - k, n);
        }

        return sbr.toString();
    }

    public static void main(String[] args) {

        System.out.println(removeDups("aaabbbacd"));

    }
}

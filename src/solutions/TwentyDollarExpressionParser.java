package solutions;

import java.util.Stack;

public class TwentyDollarExpressionParser {
    public static String[] expressions = {
            "()()",
            "({(}",
            "(2+5)*{3+(5-3)}",
            "(())",
            "(()))"
    };

    public static void main(String[] args) {
        for(String expression : expressions) {
            Stack<Character> s = new Stack<>();
            char[] expr = expression.toCharArray();
            boolean valid = false;
            for(char i : expr) {
                switch(i) {
                    case '(':
                    case '{':
                        s.push(i);
                        break;
                    case ')':
                        if (s.isEmpty()) {
                            valid = false;
                            break;
                        };
                        if (s.peek() == '(') {
                            valid = true;
                            s.pop();
                        } else {
                            valid = false;
                            break;
                        }
                        break;
                    case '}':
                        if (s.isEmpty()) {
                            valid = false;
                            break;
                        };

                        if (s.peek() == '{') {
                            valid = true;
                            s.pop();
                        } else {
                            valid = false;
                            break;
                        }
                        break;
                }
            }
            System.out.println(expression + ": " + (valid ? "Valid" : "Invalid"));
        }
    }
}

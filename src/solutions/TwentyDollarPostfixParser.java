package solutions;

import java.util.ArrayList;
import java.util.Stack;

public class TwentyDollarPostfixParser {
    public static String[] expressions = {
            "456*-",
            "45-34-+",
            "45/12++",
            "234+-45*234++**"
    };

    public static void main(String[] args) {
        ArrayList<Character> operations = new ArrayList<>();
        operations.add('+');
        operations.add('-');
        operations.add('/');
        operations.add('*');
        for(String expression : expressions) {
            Stack<Integer> s = new Stack<>();
            char[] expr = expression.toCharArray();
            int output = 0;
            System.out.println("Expression: " + expression);
            for(char i : expr) {
                if(operations.contains(i)) {
                    int c1 = s.pop();
                    int c2 = s.pop();
                    int arithOut = 0;
                    switch(i) {
                        case '+':
                            arithOut = c1 + c2;
                            break;
                        case '-':
                            arithOut = c1  - c2;
                            break;
                        case '*':
                            arithOut = c1 * c2;
                            break;
                        case '/':
                            if (c1 > c2)
                                arithOut = c1 / c2;
                            else
                                arithOut = c2 / c1;
                            break;
                    }
                    System.out.println(c1 + String.valueOf(i) + c2 +"=" + arithOut);
                    s.push(arithOut);
                } else {
                    s.add(Integer.parseInt(String.valueOf(i)));
                }
            }
            output = s.pop();
            System.out.println("Output of " + expression + ": " + output+"\n");
        }
    }
}

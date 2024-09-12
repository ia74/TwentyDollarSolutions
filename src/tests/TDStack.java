package tests;

import solutions.TwentyDollarStack;

import java.util.Stack;

public class TDStack {
    public static void main(String[] args) {
        TwentyDollarStack ml = new TwentyDollarStack();

        Stack<Integer> rs = new Stack<>();

        rs.add(100);
        rs.add(250);
        rs.add(25);
        rs.add(50);

        ml.add(100);
        ml.add(250);
        ml.add(25);
        ml.add(50);

        System.out.println("ml: " + ml.peek());
        System.out.println("ml: " + ml.pop());
        System.out.println("ml: " + ml.peek());
        System.out.println("ml: " + ml.pop());
        System.out.println("rs: " + rs.peek());
        System.out.println("rs: " + rs.pop());
        System.out.println("rs: " + rs.peek());
        System.out.println("rs: " + rs.pop());

        while(!ml.isEmpty()) {
            System.out.println("Emptying ML: " + ml.pop());
        }
        while(!rs.isEmpty()) {
            System.out.println("Emptying RS: " + rs.pop());
        }
    }
}
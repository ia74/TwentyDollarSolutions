package solutions;

import java.io.*;
import java.util.*;

public class TwentyDollarCalculator {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("calculator.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        int operatorState = 4;
        while(sets-- > 0) {
            String line = scan.nextLine();
            Stack<Double> result = new Stack<>();
            while(operatorState != 0 || !result.isEmpty()) {
                String[] a = line.split(" ");
                for(String b : a) {
                    if(isNumber(b)) {
                        result.push(Double.parseDouble(b));
                        switch(operatorState) {
                            case 4:
                                System.out.println("Multiply " + result.pop() +" " + result.pop());
                                break;
                            case 3:
                                System.out.println("Dvice " + result.pop() +" " + result.pop());
                                break;
                            case 2:
                                System.out.println("Subrtract " + result.pop() +" " + result.pop());
                                break;
                            case 1:
                                System.out.println("Add " + result.pop() +" " + result.pop());
                                break;
                        }
                    } else {
                        String oper =
                                operatorState == 4 ? "*" :
                                        operatorState == 3 ? "/" :
                                                operatorState == 2 ? "-" : "+";
                        int count = line.length() - line.replace(oper, "").length();
                        if(count < 0) operatorState--;
                    }
                }
            }
        }
    }
    public static boolean isNumber(String b) {
        try {
            Double.parseDouble(b);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
package solutions;

import java.io.*;
import java.util.*;

public class TwentyDollarCalculator {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("calculator.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        ArrayList<String> ops = new ArrayList<>();
        ops.add("*");
        int operatorState = -1;
        while(sets-- > 0) {
            String line = scan.nextLine();

        }
    }
}
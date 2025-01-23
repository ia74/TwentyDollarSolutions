package solutions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class TwentyDollarRoundingNumbers {
    public static String pad(String s) {
        return s.length() == 1 ? " " + s : s;
    }
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr18.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while (sets-- > 0) {
            int b = scan.nextInt();
            System.out.println("ROUNDING IS FUN");
            for(int a = 1; a <= b; a++) {
                System.out.println(" " + pad(String.valueOf(a)) + "   " + String.format("%.1f",Math.sqrt(a)) + "    " + String.format("%.2f", Math.cbrt(a)));
            }
            System.out.println();
        }
    }
}
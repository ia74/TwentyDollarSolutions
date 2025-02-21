package solutions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TwentyDollarAmy {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("amy.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-->0) {
            String ln = scan.next();
            int maxGuessesPerSecond = scan.nextInt();
            double combinationsOfPass = fac(ln.length());

            System.out.println(combinationsOfPass );
        }
    }
    static double fac(int n) {
        if(n==0) return n+1;
        return n*fac(n-1);
    }
}
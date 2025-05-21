package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarRaymond {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("raymond.dat"));
        int nSets = scan.nextInt();
        scan.nextLine();
        while(nSets-->0) {
            int listSize = scan.nextInt();
            ArrayList<Integer> ints = new ArrayList<>();
            while(listSize-->0) {
                ints.add(scan.nextInt());
            }
            int lastLcm = ints.getFirst();
            for(int i = 1; i < ints.size(); i++) {
                lastLcm = lcm(lastLcm, ints.get(i));
            }
            String output = "Lowest Common Multiple is ";
            if(lastLcm == 1) output = "LCM NUMBER ";
            System.out.println(output + lastLcm + (lastLcm == 1 ? "!": ""));
        }
    }
    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}
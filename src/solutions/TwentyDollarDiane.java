package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarDiane {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("diane.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            String full = scan.nextLine();
            String[] sideA = full.split(" and ");
            double expr = 0;
            for(int i = 0; i < 2; i++) {
                if(sideA[i].contains("/")) {
                    double fullD = 0;
                    if(sideA[i].contains(" ")) {
                        fullD = Double.parseDouble(sideA[i].split(" ")[0]);
                        int l = Integer.parseInt(sideA[i].split(" ")[1].split("/")[0]);
                        int r = Integer.parseInt(sideA[i].split(" ")[1].split("/")[1]);
                        fullD += ((double) l / r);
                    } else {
                        int l = Integer.parseInt(sideA[i].split("/")[0]);
                        int r = Integer.parseInt(sideA[i].split("/")[1]);
                        fullD += ((double) l / r);
                    }
                    expr += fullD;
                }
                else {
                    expr += Double.parseDouble(sideA[i]);
                }
            }
            if(String.valueOf(expr).split("\\.")[1].length() > 1) {
                System.out.println(convertDecimalToFraction(expr));
            } else {
                System.out.println((int) expr);
            }
        }
    }
    static private String convertDecimalToFraction(double x){
        String decimalStr = String.valueOf(x);
        int decimalPlaces = decimalStr.length() - decimalStr.indexOf('.') - 1;
        long den = (long) Math.pow(10, decimalPlaces);
        long num = (long) (x * den);
        long tgcd = gcd(num, den);
        num /= tgcd;
        den /= tgcd;
        return num +"/" + den;
    }

    public static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}

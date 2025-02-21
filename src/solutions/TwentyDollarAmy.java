package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class TwentyDollarAmy {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("amy.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            String str = scan.next();
            BigInteger time = new BigInteger(scan.next());
            long len = str.length();
            System.out.println(new BigInteger("36").pow(Math.toIntExact(len)).divide(time));
        }
    }
}

package solutions;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class TwentyDollarJulia {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("julia.dat"));
        int nSets = scan.nextInt();
        boolean[] isPrime = new boolean[100000];
        isPrime[0] = true;
        isPrime[1] = true;
        for(int i = 2; i < 100000; i++) {
            if (i % 2 != 0 && BigInteger.valueOf(i).isProbablePrime(100)) {
                isPrime[i] = true;
            }
        }
        scan.nextLine();
        while(nSets-->0) {
            int to = scan.nextInt();
            int c = -1;
            for(int i = 0; i < to; i++) {
                if(isPrime[i]) c++;
            }
            System.out.println(c);
        }
    }
}
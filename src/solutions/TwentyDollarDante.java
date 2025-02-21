package solutions;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TwentyDollarDante {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("dante.dat"));
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
            int from = scan.nextInt();
            int to = scan.nextInt();
            int c = 0;
            for(int i = from; i < to; i++) {
                if(isPrime[i]) c++;
            }
            System.out.println(c);
        }
    }
}
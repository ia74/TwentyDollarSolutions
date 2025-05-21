package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.function.ToIntFunction;

public class TwentyDollarMelina {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("melina.dat"));
        int nSets = scan.nextInt();
        scan.nextLine();
        while(nSets-->0) {
            double paid = scan.nextDouble();
            double due = scan.nextDouble();
            scan.nextLine();
            int[] changeDenominations = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt((e) -> (int) (Double.parseDouble(e)* 100))
                    .toArray();
            int change = (int) ((paid - due) * 100);

            long[] dp = new long[change+1];
            dp[0] = 1;
            for(int coin : changeDenominations) {
                for(int i = coin; i <= change; i++) {
                    dp[i] += dp[i - coin];
                }
            }
            System.out.println(dp[change]);
        }
    }
}
package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TwentyDollarDictatorshipFactoryCIAGlowieStealer {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("theciaglowiesareoutforme.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            int carryingCapacity = scan.nextInt();
            scan.nextLine();
            int[] weights = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] values = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] carries = new int[carryingCapacity+1];

            for(int i = 0; i < weights.length; i++) {
                for(int j = carryingCapacity; j >= weights[i]; j--) {
                    carries[j] = Math.max(carries[j], carries[j - weights[i]] + values[i]);
                }
            }
            System.out.println(carries[carryingCapacity]);
        }
    }
}

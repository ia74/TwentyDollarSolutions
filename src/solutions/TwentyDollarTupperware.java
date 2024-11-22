package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarTupperware {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("tupp.dat"));
        int height = scan.nextInt();
        scan.nextLine();
        while(scan.hasNextLine()) {
            int[] values = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] sums = new int[values.length];
            for(int j = 0; j < values.length; j++) {
                for(int k = 0; k < values.length; k++) {
                    sums[j] += values[k];
                }
            }

            Arrays.stream(sums).average().ifPresent((e) -> {
                if(e >= height) System.out.println("Escapable");
                else System.out.println("Stuck Forever");
            });
        }
    }
}

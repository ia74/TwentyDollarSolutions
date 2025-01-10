package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarMaximumProduct {

    static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
    static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static int does(int[] array) {
        int n = array.length;

        int currentMax = array[0];
        int currentMin = array[0];
        int output = array[0];

        for(int i = 1; i < n; i++) {
            int tmp = max(array[i], array[i] * currentMax, array[i] * currentMin);
            currentMin = min(array[i], array[i] * currentMax, array[i] * currentMin);
            currentMax = tmp;
            output = Math.max(output, currentMax);
        }
        return output;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("maxProd.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            int[] nums = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(does(nums));
        }
    }
}

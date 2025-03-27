package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TwentyDollarCyclops {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("cyclops.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            int r = scan.nextInt();
            int c = scan.nextInt();
            int POWER = scan.nextInt();
            scan.nextLine();
            int[][] matrix = new int[r][c];
            int minimum = Integer.MIN_VALUE;
            for(int i = 0; i < r; i++) {
                matrix[i] = Arrays.stream(scan.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
                minimum = searchMinimum(matrix[i]);
            }
            while(POWER > 0) {
                for(int i = 0; i < matrix.length; i++) {
                    for(int j = 0; j < matrix[0].length; j++) {
                        if(matrix[i][j] == minimum) {
                            POWER -= minimum;
                        } else {
                            if(matrix[i][j] > minimum) minimum = searchMinimum(matrix[i]);
                        }
                    }
                }
            }
            System.out.println(POWER);
            System.out.println(Arrays.deepToString(matrix));
        }
    }
    static int searchMinimum(int[] array) {
        int minimum = Integer.MAX_VALUE;
        for (int i : array) {
            if (i < minimum) minimum = i;
        }
        return minimum;
    }
    static boolean bruh(int[][] matrix) {
        return Math.random() > 0.5;
    }
}

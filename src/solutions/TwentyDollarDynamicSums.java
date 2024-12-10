package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TwentyDollarDynamicSums {
    public static boolean does(int[] array, int sum) {
        int len = array.length;
        boolean[][] sumTo = new boolean[len+1][sum+1];

        for(int i = 0; i <= len; i ++) {
            sumTo[i][0] = true;
        }

        for(int i = 1; i <= len; i++) {
            for(int j = 1; j <= sum; j++) {
                if(array[i-1] > j) {
                    sumTo[i][j] = sumTo[i-1][j];
                } else {
                    sumTo[i][j] = sumTo[i-1][j] ||
                                  sumTo[i-1][j - array[i-1]];
                }
            }
        }

        return sumTo[len][sum];
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("pr154.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            int sum = scan.nextInt();
            scan.nextLine();
            int[] nums = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(does(nums, sum) ? "YES" : "NO");
        }
    }
}

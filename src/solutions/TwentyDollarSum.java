package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarSum {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("sum.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            int[] nums = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            long sum = 0;
            for(int i = 0; i < nums.length-1; i+=2) {
                long thisSum = 0;
                long num = nums[i];
                long hi = nums[i+1];
                for(long j = num; j <= hi; j++) {
                    thisSum+=j;
                }
                sum += thisSum;
            }
            System.out.println(sum)
;        }
    }
}

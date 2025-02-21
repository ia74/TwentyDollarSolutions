package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TwentyDollarPears {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("pears.dat"));
        int nSets = scan.nextInt();
        scan.nextLine();
        while(nSets-->0) {
            int target = scan.nextInt();
            scan.nextLine();
            int[] array = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] res = new int[2];
            int minDiff = Integer.MAX_VALUE;
            for(int low = 0, high = array.length - 1; low < high;) {
                int sum = array[low] + array[high];
                int difference = Math.abs(target - sum);
                if(difference < minDiff) {
                    minDiff = difference;
                    res[0] = low;
                    res[1] = high;
                }
                if(sum < target) {
                    low++;
                } else {
                    high--;
                }
            }
            System.out.println(res[0] + " " + res[1]);
        }
    }
}
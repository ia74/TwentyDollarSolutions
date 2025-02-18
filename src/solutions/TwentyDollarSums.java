package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarSums {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("pr154.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            int wantedSum = scan.nextInt();
            scan.nextLine();
            int[] nums = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            String a = "NO";
            for(int i = 0; i < nums.length; i++) {
                int l = nums[i];
                for(int j = 0; j < nums.length; j++) {
                    if(l + nums[j] == wantedSum) {
                        a = "YES";
                        break;
                    }
                    l += nums[j];
                }
            }
            System.out.println(a);
        }
    }
}

package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarRainwater {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("rainwater.dat"));
        int n = scan.nextInt();
        scan.nextLine();
        while(n-->0) {
            int[] ln = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int lo = ln[0];
            int hi = ln[ln.length-1];
            ln = Arrays.stream(ln).skip(1).limit(ln.length - 2).toArray();
            int med = ln.length / 2;
            int[] left = Arrays.stream(ln).limit(med).toArray();
            int[] right = Arrays.stream(ln).skip(med).toArray();
            System.out.println(Arrays.toString(left) + Arrays.toString(right));
            int leftCount = county(left, lo);
            int rightCount = county(right, hi);
            System.out.println(Arrays.toString(left) + Arrays.toString(right));
            System.out.println(leftCount + rightCount);
        }
    }

    private static int county(int[] arr, int hi) {
        int count = 0;
        ArrayList<Integer> maximumIndexes = new ArrayList<>();
        int loopc = 0;
        while(maximumIndexes.size() < arr.length) {
            for(int i = 0; i < arr.length; i ++) {
                if(arr[i] < hi && !maximumIndexes.contains(i)) {
                    count++;
                    arr[i]++;
                } else {
                    maximumIndexes.add(i);
                }
            }
            loopc++;
        }
        System.out.println(loopc);
        return count;
    }
}

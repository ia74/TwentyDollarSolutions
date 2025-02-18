package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarMealPlan {
    public static int does(Integer[] array, int sum, int min) {
        int len = array.length;
        int[][] sumTo = new int[len+1][sum+1];

        for(int i = 0; i <= len; i ++) {
            sumTo[i][0] = i;
        }

        int count = 0;
        for(int i = 1; i <= len; i ++) {
            for(int j = 1; j <= sum; j ++) {
                if(sumTo[i-1][j] > sumTo[i][j-1]) {
                    sumTo[i][j] = sumTo[i-1][j];

                } else {
                    sumTo[i][j] = sumTo[i-1][j];
                }
            }
        }


        System.out.println(Arrays.deepToString(sumTo));
        System.out.println(count);
        return sumTo[len][sum];
    }
    public static class Range {
        int min;
        int max;
        public Range(int min, int max) {
            this.min = min;
            this.max = max;
        }
        static Range fromStr(String str) {
            String[] e = str.split("-");
            return new Range(Integer.parseInt(e[0]), Integer.parseInt(e[1]));
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("pr153.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            String[] ranges = scan.nextLine().split(" ");
            Range fat = Range.fromStr(ranges[0]);
            Range protein = Range.fromStr(ranges[1]);
            Range carbs = Range.fromStr(ranges[2]);
            ArrayList<Integer> fats = new ArrayList<>();
            ArrayList<Integer> proteins = new ArrayList<>();
            ArrayList<Integer> carbss = new ArrayList<>();

            int nextFoods = scan.nextInt();
            scan.nextLine();
            for(int i = 0; i < nextFoods; i++) {
                String[] ln = scan.nextLine().split(" ");
                fats.add(Integer.parseInt(ln[1]));
                proteins.add(Integer.parseInt(ln[2]));
                carbss.add(Integer.parseInt(ln[3]));
            }
            System.out.println(does(fats.toArray(new Integer[0]), fat.max, fat.min));
            System.out.println(does(proteins.toArray(new Integer[0]), protein.max, protein.min));
            System.out.println(does(carbss.toArray(new Integer[0]), carbs.max, carbs.min));
        }
    }
}

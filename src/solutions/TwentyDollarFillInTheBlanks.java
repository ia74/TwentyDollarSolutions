package solutions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class TwentyDollarFillInTheBlanks {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("blanks.dat"));
        int n = scan.nextInt();
        scan.nextLine();
        while(n-->0) {
            int[] array = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(array);
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i : array) arr.add(i);
            TreeSet<Integer> preceding = new TreeSet<>();
            for(int i = 0; i < array.length - 1; i++) {
                int cur = array[i];
                int next = array[i+1];
                for(int j = cur; j < next; j++) {
                    if(arr.contains(j)) continue;
                    preceding.add(j);
                }
            }
            preceding.forEach((e) -> System.out.print(e +" "));
            System.out.println();
        }
    }
}
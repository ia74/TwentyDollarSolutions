package solutions;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarCharSum {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("charSum.dat"));
        int nSets = scan.nextInt();
        scan.nextLine();
        while(nSets-->0) {
            String ln = scan.nextLine().replaceAll("\\s+", "").replaceAll("\\W+", "").toLowerCase();
            int[] c = new int[]{0};
            Arrays.stream(ln.split("")).forEach((i)->{
                c[0] += i.compareTo("a") + 1 % 26;
            });
            System.out.println(c[0]);
        }
    }
}
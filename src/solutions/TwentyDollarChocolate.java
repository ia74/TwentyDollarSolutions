package solutions;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarChocolate {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("chocolates.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            String ln = scan.nextLine();
            int nStudents = Integer.parseInt(ln.split(" ")[0]);
            int[] chocolates = Arrays.stream(ln.split(" ")).skip(1).mapToInt(Integer::parseInt).sorted().toArray();
            int minDiff = Integer.MAX_VALUE;
            for(int i = 0; i + nStudents - 1 < chocolates.length; i++) {
                int diff = chocolates[i+nStudents-1] - chocolates[i];
                if(diff < minDiff) minDiff = diff;
            }
            System.out.println(minDiff);
        }
    }
}
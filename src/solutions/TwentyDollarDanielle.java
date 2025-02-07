package solutions;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TwentyDollarDanielle {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("danielle.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets--> 0) {
            String count = scan.nextLine();
            String[] list = count.split(",");
            int[] counting = Arrays.stream(list).mapToInt(Integer::parseInt).toArray();
            for(int i = 1; i < counting.length; i++) {
                counting[i] -= (i%4) +1;
            }

            for(int i = counting.length-1; i > 0; i-=2) {
                counting[i-1] += counting[i] * 9;
                System.out.println(i-1+" = " + counting[i-1]);

            }

            System.out.println(Arrays.toString(counting));
            System.out.println(counting[0]);
        }
    }
    /**
     * 1
     * 2
     * 3
     * 4
     * 9
     * 10
     * 11
     * 72
     * 73
     * 504
     * 505
     */
}
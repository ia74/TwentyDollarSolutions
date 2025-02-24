package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class TwentyDollar5Counter {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("5counter.dat"));
        while(scan.hasNextInt()) {
            int ln = scan.nextInt();

            int c = 0;
            for(int i = 0; i <= ln; i++) {
                char[] lnA = Integer.toString(i).toCharArray();
                for (char cln : lnA) {
                    if (cln == '5') c++;
                }
            }
            System.out.println(c);
        }
    }
}

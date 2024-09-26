package solutions;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwentyDollarGasMoney {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr11.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            double gallons = scan.nextDouble();
            double todayPrice = scan.nextDouble();
            double yesterdayPrice = scan.nextDouble();
            if(todayPrice == yesterdayPrice) {
                System.out.println("PAID THE SAME");
                continue;
            }

            double adjustedToday = gallons * todayPrice;
            double adjustedYesterday = gallons * yesterdayPrice;
            if(adjustedToday > adjustedYesterday) {
                System.out.printf("PAID MORE: $%.2f%n", adjustedToday - adjustedYesterday);
            } else {
                System.out.printf("SAVED: $%.2f%n", adjustedYesterday - adjustedToday);
            }
        }
    }
}
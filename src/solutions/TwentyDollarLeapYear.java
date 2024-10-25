package solutions;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TwentyDollarLeapYear {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr26.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            int year = scan.nextInt();

            System.out.println(year + ((((year % 4 ==0) && (year %100 != 0))|| year % 400 == 0)
                            ? " IS A LEAP YEAR" : " IS NOT A LEAP YEAR" ) +"!");
        }
    }
}
package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TwentyDollarCarwash {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("wash.dat"));
        while(scan.hasNextLine()) {
            String ln = scan.nextLine();
            System.out.println(
                    LocalDate.parse(
                            ln.split("/")[2] + "-" +
                            pad(ln.split("/")[0]) + "-" +
                            pad(ln.split("/")[1])
                    ).getDayOfWeek() == DayOfWeek.SUNDAY ?
                            "Good to GO" :
                            "Not a great idea you foolish insect");
        }
    }
    public static String pad(String s) {
        return s.length() == 1 ? "0" + s : s;
    }
}

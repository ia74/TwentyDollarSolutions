package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarWolverine {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("wolverine.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            DateTimeFormatter fmt = new DateTimeFormatterBuilder()
                    .append(DateTimeFormatter.ofPattern("MM/dd/yyyy"))
                    .toFormatter();
            LocalDate ln1 = LocalDate.from(fmt.parse(scan.nextLine()));
            String ln2 = scan.nextLine();
            String[] parts = ln2.split(" ");
            Integer partTwo = Integer.valueOf(parts[2]);
            switch(parts[0]) {
                case "D": {
                    ln1 = ln1.plusDays(partTwo);
                    break;
                }
                case "M": {
                    ln1 = ln1.plusMonths(partTwo);
                    break;
                }
                case "Y": {
                    ln1 = ln1.plusYears(partTwo);
                    break;
                }
            }
            System.out.println(ln1.toString());
        }
    }
}

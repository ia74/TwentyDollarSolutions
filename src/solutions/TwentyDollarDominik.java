package solutions;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class TwentyDollarDominik {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("dominik.dat"));
        int ndates = scan.nextInt();
        int sets = scan.nextInt();
        scan.nextLine();
        HashMap<String, LocalDate> times = new HashMap<>();
        while(ndates-- > 0) {
            String ln = scan.nextLine();
            String date = ln.split(" ")[0];
            String id = ln.substring(ln.indexOf(" ") + 1);
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate dt = LocalDate.parse(date, fmt);
            times.put(id, dt);
        }
        while(sets--> 0) {
            String ln = scan.nextLine();
            String d1 = ln.split(":")[0];
            String d2 = ln.split(":")[1];
            LocalDate dt1 = times.get(d1);
            LocalDate dt2 = times.get(d2);
            long daysBetween = dt1.until(dt2, ChronoUnit.DAYS);
            System.out.printf("%,3d%n", daysBetween);
        }
    }
}
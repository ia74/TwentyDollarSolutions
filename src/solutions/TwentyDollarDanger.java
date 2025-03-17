package solutions;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.*;

public class TwentyDollarDanger {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("danger.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        HashMap<LocalTime, String> localTimes = new HashMap<>();
        while(sets-- > 0) {
            String[] ln = scan.nextLine().split(" ");
            localTimes.put(LocalTime.parse(ln[0]), ln[1]);
        }
        localTimes.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach((e) -> {
            System.out.println(e.getKey() +" " + e.getValue());
        });
    }
}
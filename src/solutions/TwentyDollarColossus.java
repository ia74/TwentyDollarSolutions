package solutions;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwentyDollarColossus {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("colossus.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            System.out.println(scan.nextInt() > 10000 ? "Lunk Alarm!!" : "Hulk here we come.");
        }
    }
}
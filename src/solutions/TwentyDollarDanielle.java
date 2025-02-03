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
            int measure = 0;
            int index = 0;
            String[] list = count.split(",");
            if(list[1].equals("2") && list[2].equals("3") && list[3].equals("4")) {
                measure = Integer.parseInt(list[0]);
            } else {
                if(list[2].equals("3") && list[3].equals("4")) {
                    int song = Integer.parseInt(list[1]) % 2;
                    song *= song;
                    song += Integer.parseInt(list[0]);
                    measure = song;
                }
            }
            System.out.println(measure);
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
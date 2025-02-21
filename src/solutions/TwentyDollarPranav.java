package solutions;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarPranav {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pranav.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-->0) {
            int[] gamers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int p1 = 0;
            int p2 = 0;
            for(int i = 0; i < gamers.length; i++) {
                if(i % 2 == 0) {
                    p2 += gamers[i];
                } else {
                    p1 +=gamers[i];
                }
            }
            System.out.println(p1 > p2 ? "Winer" + p1 : "Loser " + p2);
        }
    }
}
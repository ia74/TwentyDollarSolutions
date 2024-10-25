package solutions;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TwentyDollarVowelMarker {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr26.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            String[] line = scan.nextLine().split("");
            int count = 1;
            for(int i = 0; i < line.length; i++) {
                switch (line[i].toLowerCase()) {
                    case "a":
                    case "e":
                    case "i":
                    case "o":
                    case "u":
                        line[i] = String.valueOf(count);
                        count++;
                        break;
                }
            }
            for(String l : line) System.out.print(l);
            System.out.println();
        }
    }
}
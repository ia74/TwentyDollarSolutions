package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarReverseCase {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("reverse.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            String line = scan.nextLine();
            Arrays.stream(line.split("")).forEach((a) -> {
                System.out.print(a.equals(a.toUpperCase()) ? a.toLowerCase() : a.toUpperCase());
            });
            System.out.println();
;        }
    }
}

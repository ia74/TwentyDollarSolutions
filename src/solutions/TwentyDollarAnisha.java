package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TwentyDollarAnisha {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("anisha.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            int c = scan.nextInt();
            scan.nextInt();
            System.out.println(c >= 15 ? "Way to go, H2O." : "On my way to Dehydration Station.");
        }
    }
}

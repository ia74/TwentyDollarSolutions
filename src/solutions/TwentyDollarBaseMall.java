package solutions;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TwentyDollarBaseMall {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr51.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            String line = scan.nextLine();
        }
    }
}
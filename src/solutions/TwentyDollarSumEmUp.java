package solutions;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TwentyDollarSumEmUp {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("file.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            String[] line = scan.nextLine().split(" ");
            int a = 0;
            for(String b : line) a += Integer.parseInt(b);
            System.out.println("SUM = " + a);
        }
    }
}
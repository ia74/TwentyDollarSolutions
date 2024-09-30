package solutions;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TwentyDollarTriangle {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr31.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            int i = scan.nextInt();
            for(int a = i; a > 0; a--) {
                System.out.println("*".repeat(a));
            }
            System.out.println();
        }
    }
}
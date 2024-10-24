package solutions;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TwentyDollarAND {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr160.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            String line = scan.nextLine();
            int a = Integer.parseInt(line.split(" ")[0]);
            int b = Integer.parseInt(line.split(" ")[1]);
            int c = a&b;
            System.out.println(Integer.toString(a, 2));
            System.out.println(Integer.toString(b, 2));
            System.out.println(Integer.toString(c, 2));
            System.out.println(c);
            System.out.println();
        }
    }
}
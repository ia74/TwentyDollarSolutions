package solutions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TwentyDollarBoxPrinter {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("box.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            String box = scan.nextLine();
            String[] splice = box.split(" ");
            int height = Integer.parseInt(splice[0]);
            int width = Integer.parseInt(splice[1]);

            String laBox = "-".repeat(width) + "\n";
            for(int i = 0; i < height - 2; i ++)
                laBox += "|" + " ".repeat(width - (width >= 3 ? 3 : 1)) +" |\n";
            laBox += "-".repeat(width);
            System.out.println(laBox);
        }
    }
}
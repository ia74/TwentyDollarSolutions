package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TwentyDollarLetterTri {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("pr35.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            int count = scan.nextInt();
            String letter = scan.nextLine().trim();

            for(int i = 1; i < count+1; i++) System.out.println(letter.repeat(i));
            System.out.println();
        }
    }
}

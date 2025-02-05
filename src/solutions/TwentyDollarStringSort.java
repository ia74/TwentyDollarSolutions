package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarStringSort {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("sort.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            String[] letter = scan.nextLine().split(" ");
            for (int i = 0; i < letter.length; i++) {
                char[] l = letter[i].toCharArray();
                Arrays.sort(l);
                letter[i] = String.valueOf(l);
                System.out.print(letter[i] + " ");
            }
            System.out.println();
        }
    }
}

package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarJuana {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("juana.dat"));
        int maxSets = scan.nextInt();
        int noSets = maxSets;
        scan.nextLine();
        while(noSets-- > 0) {
            int rows = scan.nextInt();
            int cols = scan.nextInt();
            scan.nextLine();
            System.out.print("Test case #" + (maxSets - noSets)+": ");
            int[][] table = new int[rows][cols];
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++) {
                    table[i][j] = scan.nextInt();
                }
            }
            int colStart = scan.nextInt() - 1;
            int rowStart = scan.nextInt();
            int colAmt = scan.nextInt() - 1;
            int rowAmt = scan.nextInt();

            if(colStart >= cols || rowStart >= rows-1) {
                System.out.println("Unable to extract requested size!");
            } else {
                System.out.print("\n");
                for (int i = rowStart; i < rowStart + rowAmt; i++) {
                    for (int j = colStart - 1; j < colStart + colAmt; j++) {
                        System.out.print(" " + table[i][j] + " ");
                    }
                    System.out.println();
                }
            }
            System.out.print("--------------------\n");
        }
    }
}

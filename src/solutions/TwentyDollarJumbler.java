package solutions;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarJumbler {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr35-2.dat")); // TODO: replace with pr35.dat
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            int r = scan.nextInt(),
                c = scan.nextInt();
            scan.nextLine();
            String[][] matrix = new String[r][c];

            for(int i = 0; i < r; i ++) {
                String ln = scan.nextLine();
                String[] sp = ln.split("");
                for(int j = 0; j < sp.length; j++) {
                    matrix[i][j] = sp[j];
                }
            }

            for(int i = 0; i < matrix.length; i ++) {
                if(i%2==1) continue;
                for(int j = 0; j < matrix[i].length; j +=2) {
                    System.out.print(matrix[i][j]);
                }
                for(int j = 1; j < matrix[i].length; j +=2) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
            for(int i = 0; i < matrix.length; i ++) {
                if(i%2==0) continue;
                for(int j = 0; j < matrix[i].length; j +=2) {
                    System.out.print(matrix[i][j]);
                }
                for(int j = 1; j < matrix[i].length; j +=2) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
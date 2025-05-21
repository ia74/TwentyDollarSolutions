package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TwentyDollarElijah {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("elijah.dat"));
        int nSets = scan.nextInt();
        scan.nextLine();
        while (nSets-- > 0) {
            int r = scan.nextInt();
            int c = scan.nextInt();
            scan.nextLine();
            char[][] matrix = new char[r][c];
            while (r-- > 0) {
                matrix[r] = scan.nextLine().toCharArray();
            }
            int rotation = scan.nextInt();
            int times90 = rotation / 90;
            for(int i = 0; i < times90; i++) {
                matrix = rotateArray(matrix);
            }
            for(char[] e : matrix) {
                System.out.println(e);
            }
        }
    }
    public static char[][] rotateArray(char[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        char[][] newArray = new char[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                newArray[i][j] = arr[rows - 1 - j][i];
            }
        }
        return newArray;
    }
}
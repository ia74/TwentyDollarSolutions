package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarFilip {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("filip.dat"));
        int nSets = scan.nextInt();
        scan.nextLine();
        while(nSets-- > 0) {
            int r = scan.nextInt();
            int c = scan.nextInt();
            String outer = scan.next();
            boolean bool = scan.nextBoolean();
            String[][] matrix = new String[r][c];

            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[0].length; j++) {
                    if(i == 0 || j == 0 || i == r-1 || j == c-1) matrix[i][j] = outer;
                    else {
                        if(bool) matrix[i][j] = outer;
                        else matrix[i][j] = " ";
                    }
                }
            }

            Arrays.stream(matrix).forEach((e) -> {
                Arrays.stream(e).forEach(System.out::print);
                System.out.println();
            });
        }
    }
}

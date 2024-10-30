package solutions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarKenneth {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("kenneth.dat"));
        int sets = scan.nextInt();
        int is = sets;
        scan.nextLine();
        int bs = 9;
        while(sets-- > 0) {
            int[][] brd = new int[9][9];
            boolean solution = false;
            for(int i = 0; i < bs; i++) {
                String ln = scan.nextLine();
                String[] spc = ln.split(" ");
                for(int j = 0; j < spc.length; j++) {
                    brd[i][j] = Integer.parseInt(spc[j]);
                }
            }
            ArrayList<Integer> seen = new ArrayList<>();
            for(int i = 0; i < bs; i++) {
                seen.clear();
                for(int j = 0; j < bs; j++) {
                    int cu = brd[i][j];
                    if (!seen.contains(cu)) {
                        solution = true;
                        seen.add(cu);
                    } else {
                        solution = false;
                        break;
                    }
                }
            }
            System.out.println(is - sets);
            System.out.println(solution);
        }
    }
}
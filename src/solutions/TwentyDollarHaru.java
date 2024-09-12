package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarHaru {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("haru.dat"));
        int nSets = scan.nextInt();
        scan.nextLine();
        while(nSets-- > 0) {
            int len = scan.nextInt();
            int p1X = scan.nextInt();
            int p1Y = scan.nextInt();
            char[] p1inst = scan.next().toCharArray();
            int p2X = scan.nextInt();
            int p2Y = scan.nextInt();
            char[] p2inst = scan.next().toCharArray();
//            System.out.println(p1X +"x" + p1Y+"y" + Arrays.toString(p1inst));
//            System.out.println(p2X +"x" + p2Y+"y" + Arrays.toString(p2inst));
            int[] p1inst2 = instructionList(p1inst, p1X, p1Y);
            p1X = p1inst2[0];
            p1Y = p1inst2[1];
            int cgs = gamestate(p1X, p1Y, p2X, p2Y);
            System.out.println(cgs);
            int[] p2inst2 = instructionList(p2inst, p2X, p2Y);
            p2X = p2inst2[0];
            p2Y = p2inst2[1];
            System.out.println("P1:" + p1X +"x" + p1Y+"y");
            System.out.println("P2:" +p2X +"x" + p2Y+"y\n");
        }
    }
    static int gamestate(int p1x, int p1y, int p2x, int p2y) {
        if(0 > p1x || p1y >= 100) {
            return 1;
        } else if(0> p2x || p2y >= 100) {
            return 2;
        }

        return -2;
    }
    static int[] instructionList(char[] instList, int x, int y) {
        for (char inst : instList) {
            switch (inst) {
                case 'U':
                    y++;
                    break;

                case 'D':
                    y--;
                    break;

                case 'L':
                    x--;
                    break;

                default:
                case 'R':
                    x++;
                    break;
            }
        }
        return new int[]{x, y};
    }
}

package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class TwentyDollarWojtek {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("wojtek.dat"));
        int n = scan.nextInt();
        int is = n;
        scan.nextLine();
        while(n-->0) {
            int[] a = {
                    scan.nextInt(),
                    scan.nextInt(),
                    scan.nextInt(),
                    scan.nextInt(),
            };
            int stepCount = 0;
            boolean flag = false;
            while(!flag) {
                a = new int[]{
                        subtractLarges(a[0], a[1]),
                        subtractLarges(a[1], a[2]),
                        subtractLarges(a[2], a[3]),
                        subtractLarges(a[3], a[0])
                };
                stepCount++;
                if(a[0] == 0 && a[1] == 0 && a[2] == 0 && a[3] == 0) flag = true;
            }
            System.out.println("CASE #" + (is - n) +": " + stepCount);
        }
    }
    public static int subtractLarges(int a, int b) {
        return b > a ? b - a : a - b;
    }
}
package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TwentyDollarSnowflakes {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("pr37.dat"));
        while(scan.hasNextInt()) {
            int n = scan.nextInt();
            // I would make this part of the math but its also faster this way
            if(n == 1) {
                System.out.println("111\n111\n111\n");
                continue;
            } else if(n == 2) {
                System.out.println("2 2 2\n 222\n22222\n 222\n2 2 2\n");
                continue;
            }
            String N = String.valueOf(n);
            int spacesBetweenLines = n-1;
            boolean direction = true;
            bruh:
            for(int i = 0; i < n-1; i++) {
                for(int j = 0; j < n-1; j++) {
                    if(n - spacesBetweenLines-1 == -1) break bruh;
                    String doThat = j == 0 ? "": " ".repeat(n - spacesBetweenLines-1);
                    String str = doThat + N + " ".repeat(spacesBetweenLines) + N + " ".repeat(spacesBetweenLines) + N;
                    if(spacesBetweenLines == 0) {
                        System.out.println(" ".repeat(n-1) + str);
                        System.out.println(N.repeat((n * 2)+1));
                        System.out.println(" ".repeat(n-1) + str);
                    } else System.out.println(str);
                    if(direction && spacesBetweenLines > 0) {
                        spacesBetweenLines--;
                    }
                    else {
                        direction = false;
                        spacesBetweenLines++;
                    }
                }
            }
            System.out.println();
        }
    }
}

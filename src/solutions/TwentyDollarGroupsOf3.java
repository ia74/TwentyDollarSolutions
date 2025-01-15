package solutions;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TwentyDollarGroupsOf3 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr30.dat"));
        int nSets = scan.nextInt();
        scan.nextLine();
        while(nSets-->0) {
            String ln = scan.nextLine();
            String l = "";
            for(int i = 0; i <ln.length(); i++) {
                if(i > 0 && i % 3 == 0) {
                    System.out.print(l +" ");
                    l = "" + ln.charAt(i);
                } else {
                    l += ln.charAt(i);
                }
            }
            System.out.print(l);
            System.out.println();
        }
    }
}
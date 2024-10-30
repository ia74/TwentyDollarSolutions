package solutions;

import java.io.*;
import java.util.*;

public class TwentyDollarRamiro {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("ramiro.dat"));
        int n = scan.nextInt();
        scan.nextLine();
        while(n-->0) {
            String line = scan.nextLine();
            String[] spc = line.split(" ");
            int numer = Integer.parseInt(spc[0], 16);
            int numerdos = Integer.parseInt(spc[1], 16);
            String numers = Integer.toBinaryString(numer);
            String numerdoss = Integer.toBinaryString(numerdos);
            int distance = 0;
            for(int i = 0; i < numers.length(); i++) {
                String a = numers.substring(i, i+1);
                String b = numerdoss.substring(i, i+1);
                if(a.equals(b)) distance++;
            }
            System.out.println(distance);
        }
    }
}

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
            long numer = Long.parseLong(spc[0], 16);
            long numerdos = Long.parseLong(spc[1], 16);
            String numers = Long.toBinaryString(numer);
            String numerdoss = Long.toBinaryString(numerdos);
            int distance = 0;
            numers = pad(numers);
            numerdoss = pad(numerdoss);
            for(int i = 0; i < numers.length(); i++) {
                String a = String.valueOf(numers.charAt(i));
                String b = String.valueOf(numerdoss.charAt(i));
                if(!a.equals(b)) distance++;
            }
            System.out.println(distance);
        }
    }
    public static String pad(String a) {
        String b = a;
        if(b.length() < 32) b = "0".repeat(32 - a.length()) + b;
        return b;
    }
}

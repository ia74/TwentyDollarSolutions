package solutions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TwentyDollarEvenSort {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("even.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            String ln = scan.nextLine();
            String[] spc = ln.split(" ");
            ArrayList<String> strs = new ArrayList<>();
            for (String s : spc) {
                if (s.length() % 2 == 0 && !s.isEmpty()) strs.add(s);
            }
            Comparator<String> cmp = String::compareToIgnoreCase;
            strs.sort(cmp);
            int a = 0;
            for(int i = 0; i < spc.length; i++) {
                if(spc[i].length() % 2 == 0) {
                    spc[i] = strs.get(a);
                    a++;
                }
            }
            for (String s : spc) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
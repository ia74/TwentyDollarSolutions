package solutions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TwentyDollarWordSort {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr03.dat"));
        int n = scan.nextInt();
        scan.nextLine();
        while(n-->0) {
            String line = scan.nextLine();
            line = line.replaceAll("\\W+", " ").trim();
            String[] spaces = line.split(" ");
            ArrayList<String> fixed = new ArrayList<>();
            for (String space : spaces) {
                if(space.isEmpty() || space.trim().isEmpty()) continue;
                fixed.add(space);
            }
            Comparator<String> comp = ((a, b) -> {
                if(a.equalsIgnoreCase(b))
                    return a.compareTo(b);

                return a.toUpperCase().compareTo(b.toUpperCase());
            });
            fixed.sort(comp);
            for(String a : fixed) System.out.print(a + " ");
            System.out.println();
        }
    }
}
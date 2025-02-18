package solutions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class TwentyDollarSiteSort {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr01.dat")); // TODO: replace with pr35.dat
        ArrayList<String> sites = new ArrayList<>();
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) sites.add(scan.nextLine());
        Comparator<String> cmpExt = (a, b) -> a.split("\\.")[1].compareToIgnoreCase(b.split("\\.")[1]);
        Comparator<String> cmpSite = (a, b) ->  a.split("\\.")[0].compareToIgnoreCase(b.split("\\.")[0]);

        sites.sort(cmpExt.thenComparing(cmpSite));
        sites.forEach(System.out::println);
    }
}
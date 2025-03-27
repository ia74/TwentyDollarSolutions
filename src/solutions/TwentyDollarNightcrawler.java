package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwentyDollarNightcrawler {
    // Travis Scott
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("nightcrawler.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        Pattern ptn = Pattern.compile("(-?\\d+.\\d+)");
        while(noSets-- > 0) {
            String l = scan.nextLine();
            Matcher mat = ptn.matcher(l);
            double[] i = {0,1}; // 0th index: average, index 1: length
            // i need to use a primitive array because forEach/streams are not atomic
            mat.results().forEach((e) -> {
                String text = l.substring(e.start(), e.end());
                double num = Double.parseDouble(text);
                i[0] += (int) num;
                i[1] += 0.5;
            });
            int numberOfGroups = (int) i[1];
            i[0] = Math.sqrt(Math.abs(i[0]) / numberOfGroups);
            System.out.println(i[0]);
            // sorry for the slop
        }
    }
}

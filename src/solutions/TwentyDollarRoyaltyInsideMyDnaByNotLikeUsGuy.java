package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TwentyDollarRoyaltyInsideMyDnaByNotLikeUsGuy {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("dna.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            String line = scan.nextLine();
            Set<String> seen = new HashSet<>();
            Set<String> repeated = new TreeSet<>();
            for(int i = 0; i < line.length() - 10; i++) {
                String repeatedLine = line.substring(i, i+10);
                if(seen.contains(repeatedLine)) {
                    repeated.add(repeatedLine);
                } else {
                    seen.add(repeatedLine);
                }
            }
            System.out.println(repeated);
        }
    }
}

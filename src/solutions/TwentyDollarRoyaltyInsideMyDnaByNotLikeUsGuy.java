package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class TwentyDollarRoyaltyInsideMyDnaByNotLikeUsGuy {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("dna.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            String line = scan.nextLine();
            TreeSet<String> repeated = new TreeSet<>();
            for(int i = 0; i < line.length() - 10; i++) {
                String repeatedLine = line.substring(i, i+10);
                int counter = 0;
                for(int j = 0; j < line.length() - 10; j++) {
                    String repeated2 = line.substring(j, j+10);
                    if(repeatedLine.equals(repeated2)) {
                        for (int k = j; k < line.length() - 10; k++) {
                            String repeated3 = line.substring(k, k + 10);
                            if(repeated3.equals(repeated2)) {
                                counter++;
                            }
                        }
                    }
//                    System.out.println(repeatedLine + counter);
                    if(counter > 1) repeated.add(repeatedLine);
                }
            }
            System.out.println(repeated);
        }
    }
}

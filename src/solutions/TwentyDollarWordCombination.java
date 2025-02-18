package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class TwentyDollarWordCombination {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("pr151.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            String word = scan.nextLine();
            TreeSet<String> combo = new TreeSet<>();
            for(int i = 0; i < word.length(); i++) {
                for(int j = i+1; j <= word.length(); j++) {
                    combo.add(word.substring(i, j));
                    if(j < word.length()) {
                            combo.add(word.charAt(i) + "" + word.charAt(j));
                        for(int k = j+1; k <= word.length(); k++) {
                            combo.add(word.charAt(i) + "" + word.substring(j,k));
                            combo.add(word.substring(i, j) + "" + word.substring(j,k));
                            combo.add(word.substring(j,k));
                            combo.add(word.substring(i, j) + "" + word.substring(j));
                            combo.add(word.substring(i, j) + "" + word.substring(k));
                        }
                    }
                }
            }
            Comparator<String> a = String::compareTo;
            combo.stream().sorted(a).forEach(System.out::println);
            System.out.println();
        }
    }
}

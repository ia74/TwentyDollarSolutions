package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TwentyDollarAnagrams {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("anagrams.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            String[] words = scan.nextLine().split(" ");
            ArrayList<String> compilation = new ArrayList<>();
            for(String word : words) {
                ArrayList<String> nana = new ArrayList<>();
                for(int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    for(String w :words) {
                        for(int j = 0; j < w.length(); j++) {
                            if(w.charAt(i) == ch) continue;
                            else break;
                        }
                    }
                }
            }
        }
    }
}

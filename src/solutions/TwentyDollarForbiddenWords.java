package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarForbiddenWords {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("forbidden.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            String toCheck = scan.nextLine().toLowerCase().replaceAll("[\\s\\W]", "");
            String[] wordes = scan.nextLine().split(" ");
            for(int i = 0; i < wordes.length; i++) wordes[i] = wordes[i].toLowerCase();
            ArrayList<String> words = new ArrayList<>(Arrays.asList(wordes));
            String wordy;
            int highestSubstring = 0;
            for(int i = 0; i < toCheck.length(); i++) {
                wordy = toCheck.substring(i, i+ 1);
                olo:
                for(int j = i+1; j < toCheck.length(); j++) {
                    String a = wordy;
                    wordy += toCheck.substring(j, j + 1);
                    for(String word : words) {
                        if(wordy.contains(word)) {
                            wordy = a;
                            break olo;
                        };
                    }
                }
                if(highestSubstring < wordy.length()) highestSubstring = wordy.length();
            }
            System.out.println(highestSubstring);
        }
    }
}

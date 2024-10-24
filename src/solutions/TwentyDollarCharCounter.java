package solutions;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class TwentyDollarCharCounter {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr19.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            String line = scan.nextLine();
            int countLetters = line.replaceAll("[^A-Za-z]+", "").length();
            int countDigits = line.replaceAll("\\D+", "").length();
            int countOther = line.replaceAll("[A-Za-z\\d]+", "").length();
            String lt = "LETTERS: " + (countLetters < 10 ? " ": "") + countLetters;
            String dg = "DIGITS: " + (countDigits < 10 ? " ": "") + countDigits;
            String ot = "OTHER: " + (countOther < 10 ? " ": "") + countOther;
            System.out.println(lt +" " + dg +" " + ot);
        }
    }
}
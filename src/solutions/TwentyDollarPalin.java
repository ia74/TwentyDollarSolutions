package solutions;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TwentyDollarPalin {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr71.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            String line = scan.nextLine();
            // Check if palindrome
            if(isPalindrome(line)) {
                System.out.println("PALINDROME");
            } else {
                System.out.println("NOT PALINDROME");
            }
        }
    }
    static boolean isPalindrome(String line) {
        int pco = 0;
        line = line.replaceAll("\\W+", "");
        for(int i = 0; i < line.length(); i++) {
            if(line.charAt(i) != line.charAt(line.length()-1 - i)) continue;
            pco++;
        }
        return pco == line.length();
    }
}
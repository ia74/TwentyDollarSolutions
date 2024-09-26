package solutions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TwentyDollarPalindrome {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr72.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            String line = scan.nextLine();
            // Check if palindrome
            if(isPalindrome(line)) {
                System.out.println(line);
                continue;
            }

            String reversed = line.substring(0,line.length()-1);
            String reversed2 = new StringBuilder(line.substring(0,line.length()-1)).reverse().toString();
            String tmp1;
            tmp1 = isFlag(reversed2, line);
            if(!isPalindrome(tmp1)) tmp1 = isFlag(reversed, line);

            System.out.println(tmp1);
        }
    }
    private static String isFlag(String reversed, String tmp1) {
        int c = 0;
        for(int i = 0; i < reversed.length(); i++) {
            tmp1 += reversed.charAt(i);
            if (isPalindrome(tmp1)) {
                c++;
            } else if(c > 0) {
                return tmp1;
            }
        }
        return tmp1;
    }

    static boolean isPalindrome(String line) {
        int pco = 0;
        for(int i = 0; i < line.length(); i++) {
            if(line.charAt(i) != line.charAt(line.length()-1 - i)) continue;
            pco++;
        }
        return pco == line.length();
    }
}
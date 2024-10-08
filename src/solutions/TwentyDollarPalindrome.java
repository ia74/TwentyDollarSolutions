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

            String reversed2 = new StringBuilder(line).reverse().toString();
            String tmp1 = isFlag(reversed2, line);

            System.out.println(tmp1);
        }
    }
    private static String isFlag(String reversed, String str) {
        String ret = str;
        String tmp;
        for(int i = 0; i < str.length(); i++) {
            tmp = str.substring(0, i) + reversed;
            if (isPalindrome(tmp)) {
                ret = tmp;
                break;
            }
        }
        return ret;
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
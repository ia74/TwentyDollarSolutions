package solutions;

import java.io.File;
import java.io.IOException;
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
            String tmp1 = line;
            boolean flag = false;
            for(int i = 0; i < reversed.length(); i++) {
                tmp1 += reversed.charAt(i);
                if(isPalindrome(tmp1)) {
                    System.out.println(tmp1);
                    flag = true;
                    break;
                }
            }
            if(flag) continue;
            tmp1 = line;
            for(int i = 0; i < reversed2.length(); i++) {
                tmp1 += reversed2.charAt(i);
                if(isPalindrome(tmp1)) {
                    System.out.println(tmp1);
                    break;
                }
            }
        }
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
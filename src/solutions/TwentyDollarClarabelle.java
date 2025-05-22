package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class TwentyDollarClarabelle {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("clarabelle.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            String ln = scan.nextLine();
            TreeSet<String> palindromes = new TreeSet<>();
            for(int i = 0; i < ln.length()-2; i++){
                String a = ln.substring(i,i+3);
                if(!isPalindrome(a)) continue;
                palindromes.add(a);
            }
            if(palindromes.isEmpty()) {
                System.out.println("NONE");continue;
            }
            for(String palindrome : palindromes) {
                System.out.print(palindrome+" ");
            }
            System.out.println();
        }
    }
    public static boolean isPalindrome(String palin) {
        for(int i = 0; i < palin.length(); i++) {
            if(palin.charAt(i) != palin.charAt(palin.length()-i-1)) {
                return false;
            }
        }
        return true;
    }
}

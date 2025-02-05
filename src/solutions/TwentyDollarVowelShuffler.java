package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TwentyDollarVowelShuffler {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("pr87.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            String ln = scan.nextLine();
            for(int i = 0; i < ln.length(); i++) {
                String ch = ln.substring(i,i+1);
                boolean isUppy = ch.toUpperCase().equals(ch);
                ch = switch (ch.charAt(0)) {
                    case 'A', 'a' -> isUppy ? "E" : "e";
                    case 'E', 'e' -> isUppy ? "I" : "i";
                    case 'I', 'i' -> isUppy ? "O" : "o";
                    case 'O', 'o' -> isUppy ? "U" : "u";
                    case 'U', 'u' -> isUppy ? "A" : "a";
                    default -> ch;
                };
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}

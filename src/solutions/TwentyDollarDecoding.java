package solutions;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwentyDollarDecoding {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("decoding.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            String line = scan.nextLine();
            String[] spaces = line.split(" ");
            for(String s : spaces) {
            String rebuilt = "";
                for(int i = 0; i < 26; i++) {
                    rebuilt += (caesar(s, i)) + " ";
                }
            System.out.println(rebuilt);
            }
        }
    }

    static String caesar(String input, int decipher) {
        String out = "";
        for(int i = 0; i < input.length(); i++) {
            out += String.valueOf((char) (input.charAt(i) + decipher) % 26);
        }
        return out;
    }
}
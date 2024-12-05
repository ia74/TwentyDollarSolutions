package solutions;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class TwentyDollarParenthesisIdentificationMachine {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr86.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            String line = scan.nextLine();
            for(int i = 0; i < line.length(); i++) {
                String pattern = line.substring(0, i);
                String otherSide = line.substring(i);
                int openParen = 0;
                int closeParen = 0;
                for(int j = 0; j < pattern.length(); j++) {
                    char ch = pattern.charAt(j);
                    if(ch == '(') openParen++;
                }
                for(int j = 0; j < otherSide.length(); j++) {
                    char ch = otherSide.charAt(j);
                    if(ch == ')') closeParen++;
                }
                if(openParen == closeParen) System.out.println(i);
            }
        }
    }
}
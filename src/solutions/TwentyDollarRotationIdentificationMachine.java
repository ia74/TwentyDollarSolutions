package solutions;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwentyDollarRotationIdentificationMachine {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr83.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            String[] line = scan.nextLine().split(" ");
            String a = line[0];
            String b = line[1];

            String end = "";
            for(int i = 0; i < a.length()/2; i++) {
                end += a.substring(i, i+1);
            }
            System.out.println(end);
        }
    }
}
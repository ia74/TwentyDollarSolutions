package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarArusha {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("arusha.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            String cR = scan.nextLine();
            char[] string = cR.split(" ")[0].toCharArray();
            char[] rotations = cR.split(" ")[1].toCharArray();
            for(char rot : rotations) {
                switch(rot) {
                    case 'L':
                        char tempL = string[0];
                        char tempR = string[string.length - 1];
                        String begin = cR.substring(1, string.length-1);
                        begin += tempL;
                        begin += tempR;
                        string = begin.toCharArray();
                        break;
                    case 'R':
                        char temp = string[string.length - 1];
                        for(int i = string.length - 1; i > 0; i--) {
                            string[i] = string[i - 1];
                        }
                        string[0] = temp;
                        break;
                }
            }
            System.out.println(string);
        }
    }
}

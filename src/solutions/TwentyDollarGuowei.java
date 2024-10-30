package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TwentyDollarGuowei {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("guowei.dat"));
        int nSets = scan.nextInt();
        scan.nextLine();
        while(nSets-->0) {
            int charCount = scan.nextInt();
            scan.nextLine();
            String line = scan.nextLine();
            if(charCount < line.length()) {
                System.out.println(line.substring(charCount).substring(0, 40));
            } else {
                int newCharCount = charCount - (line.length()) - 1;
                String lene = line.substring(newCharCount);

                if(lene.length() <= 40) {
                    System.out.println((lene + " " + line).substring(0, 40));
                }
                else System.out.println(lene.substring(0, 40));
            }
        }
    }
}

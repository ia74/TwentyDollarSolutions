package solutions;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TwentyDollarPermuting {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr150.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            String[] a = scan.nextLine().split(" ");
            String phrase = a[0];
            int len = Integer.parseInt(a[1]);
            int last = -1;
            for(int i = 0; i < phrase.length(); i++) {
                String perm = phrase.substring(i, i + 1);
                if(perm.length() > len) {
                    last = 0;
                    System.out.println(perm);
                    continue;
                }
                for(int j = 0; j < phrase.length(); j++) {
                    if(perm.length() >= len) break;
                    if(last == -1) last = 1;
                    perm += phrase.charAt(last + j);
                    last = j;
                }
                System.out.println(perm);
            }
        }
    }
}
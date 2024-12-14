package solutions;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TwentyDollarRotationIdentificationMachine {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr83.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            String[] line = scan.nextLine().split(" ");
            String a = line[0];
            String b = line[1];
            boolean pass = false;
            for(int i = 0; i < a.length(); i++) {
                String suba = a.substring(0, i);
                String subb = a.substring(i);
                if((subb + suba).equals(b)) {
                    pass = true;
                    break;
                }
            }
            System.out.println(pass ? "YES" : "NO");
        }
    }
}
package solutions;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TwentyDollarJosefa {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("josefa.dat"));
        int sets = scan.nextInt();
        while(sets-- > 0) {
            int slpoingy = scan.nextInt();
            String scrunch = Integer.toBinaryString(slpoingy);
            int lango = scrunch.length();
            if (lango > 8){
                String firster = scrunch.substring(0,1);
                String ermblern = scrunch.substring(scrunch.length() - 7);
                scrunch = firster + ermblern;
            }
            else if (lango < 8){
                int AH = 8 - lango - 1;
                String filler = "";
                while (AH --> 0 ){
                    filler += "0";
                }
                if (slpoingy >= 0) {
                    filler = "0" + filler;
                }
                else {
                    filler = "1" + filler;
                }
                scrunch = filler + scrunch;
            }
            System.out.println(slpoingy + " = " + scrunch);
        }
    }
}
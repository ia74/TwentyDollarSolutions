package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarFacundo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("facundo.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            String line = scan.nextLine();
            String deck = line.split(" ")[0];
            int shuffleAmount = Integer.parseInt(line.split(" ")[1]);
            for(int j = 0; j < shuffleAmount; j++) {
                char[] leftHalf = deck.substring(0, deck.length() / 2).toCharArray();
                char[] rightHalf = deck.substring(deck.length() / 2, deck.length() - 1).toCharArray();
                String lacedWithFent = "";
                for(int i = 0; i < leftHalf.length; i++) {
                    System.out.println(Arrays.toString(leftHalf));
                    System.out.println(Arrays.toString(rightHalf));
                    lacedWithFent += String.valueOf(leftHalf[i]) + String.valueOf(rightHalf[i]);
                }
            System.out.println(lacedWithFent);
            }
        }
    }
}

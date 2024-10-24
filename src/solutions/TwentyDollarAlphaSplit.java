package solutions;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TwentyDollarAlphaSplit {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr77.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            String line = scan.nextLine();
            String AtoM = line.replaceAll("[^A-M]", " ");
            String NtoZ = line.replaceAll("[^N-Z]", " ");

            System.out.println(AtoM);
            System.out.println(NtoZ);

            System.out.println();
        }
    }
}
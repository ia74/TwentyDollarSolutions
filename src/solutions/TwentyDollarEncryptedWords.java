package solutions;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TwentyDollarEncryptedWords {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr74.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            String line = scan.nextLine();
            String[] spaces = line.split(" ");
            StringBuilder rebuilt = new StringBuilder();
            for(int i = 1; i < spaces.length + 1; i++) {
                if(i % 2 == 0) {
                    rebuilt.append(transform(spaces[i - 1], i)).append(" ");
                } else {
                    rebuilt.append(new StringBuilder(spaces[i - 1]).reverse()).append(" ");
                }
            }
            System.out.println(rebuilt);
        }
    }
    static String transform(String inp, int cycles) {
        if(cycles > inp.length()) return inp;
        cycles %= inp.length();
        String transformed = "";
        // last n cycles go to end
        // SCIENCE 2 = CESCIEN
        transformed += inp.substring(inp.length() - cycles);
        transformed += inp.substring(0, inp.length() - cycles);
        return transformed;
    }
}
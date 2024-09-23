package solutions;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class TwentyDollarDecode {
    int ASd[];
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("decode.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            Queue<String> stack = new LinkedList<>();
            String line = scan.nextLine();
            int curc = 0;

            System.out.println(stack);
            while(!stack.isEmpty()) {
                System.out.print(stack.remove());
            }
            System.out.println();
        }
    }
}
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
            validate(line, curc, stack);
            System.out.println(stack);
            while(!stack.isEmpty()) {
                System.out.print(stack.remove());
            }
            System.out.println();
        }
    }
    static void validate(String line, int curc, Queue<String> stack) {
        for(String l : line.split("")) {
            if(l.equals("[")) {
                int repeat = Integer.parseInt(String.valueOf(line.charAt(curc - 1)));
                String toRepeat = line.substring(curc + 1).split("]")[0];
                for(String c : toRepeat.split("")) {
                    if(c.equals("[")) {
                        toRepeat = toRepeat.split("\\[")[0];
                        toRepeat = toRepeat.substring(0, toRepeat.length()-1);
                    }
                }
                System.out.println(toRepeat);
//                a = toRepeat;
                for(int i = 0; i < repeat; i++) {
                    stack.add(toRepeat);
                }
            }
            curc++;
        }
    }
}
package solutions;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwentyDollarDecode {
    int ASd[];
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("decode.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            Stack<String> stack = new Stack<>();
            Stack<String> finalStack = new Stack<>();
            String line = scan.nextLine();

            Pattern pattern = Pattern.compile("(\\d)\\[(.*)]", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(line);
            boolean matchFound = matcher.find();
            if(matchFound) {
                System.out.println("Match found");
                
            } else {
                System.out.println("Match not found");
            }
        }
    }
}
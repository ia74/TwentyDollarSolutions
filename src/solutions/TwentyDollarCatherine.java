package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarCatherine {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("catherine.dat"));
        int nSets = scan.nextInt();
        scan.nextLine();
        while(nSets-- > 0) {
            String sc = scan.nextLine();
            String[] ans = sc.split(" ")[0].split("");
            String[] wan = sc.split(" ")[1].split("");
            ArrayList<String> wanted = new ArrayList<>(Arrays.asList(wan));
            ArrayList<String> answer = new ArrayList<>(Arrays.asList(ans));

            String rebuilt = "";
            int ic = 0;
            for(String w : wanted) {
                if(answer.get(ic).equals(w)) {
                    rebuilt += w.toUpperCase();
                } else if(answer.contains(w)) {
                    rebuilt += w.toLowerCase();
                } else {
                    rebuilt += "*";
                }
                ic++;
            }
            System.out.println(rebuilt);
        }
    }
}

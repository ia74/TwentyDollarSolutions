package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TwentyDollarIvan {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("ivan.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        char[] key = scan.nextLine().toCharArray();
        int c = 0;
        while(noSets-- > 0) {
            char[] test = scan.nextLine().toCharArray();
            int correct = 0;
            int incorrect = 0;
            int attempted = 0;
            int tot = test.length;
            for(int i = 0; i < tot; i ++) {
                if(test[i] != '_') {
                    attempted++;
                    if(test[i] == key[i]) correct++;
                    else incorrect++;
                }
            }
            int score = (correct * 6) - (incorrect * 2);
            double attempt = attempted == 0 ? 0.0 : (double) correct / attempted * 100;
            System.out.println("Exam #" + c + ": " + score + " " + String.format("%.1f", attempt));
            c++;
        }
    }
}

package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class TwentyDollarRomanNumerals {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("pr82.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        HashMap<String, Integer> roman = new HashMap<>();
        roman.put("I", 1);
        roman.put("V", 5);
        roman.put("X", 10);
        roman.put("L", 50);
        roman.put("C", 100);
        roman.put("D", 500);
        roman.put("M", 1000);

        while(noSets-- > 0) {
            String ln = scan.nextLine();
            int num = 0;
            int lastValue = 0;
            for(int i = ln.length() - 1; i >= 0; i--) {
                int currentValue = roman.get(ln.substring(i,i+1));
                if(currentValue < lastValue)
                    num -= currentValue;
                else
                    num += currentValue;
                lastValue = currentValue;
            }
            System.out.println(num);
        }
    }
}

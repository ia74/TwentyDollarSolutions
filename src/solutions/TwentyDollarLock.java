package solutions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TwentyDollarLock {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr158.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            String[] spaces = scan.nextLine().split(" ");
            ArrayList<Integer> nums = new ArrayList<>();
            HashMap<Integer, Integer> freqs = new HashMap<>();
            for(String s : spaces) {
                if (!s.isEmpty()) {
                    nums.add(Integer.parseInt(s));
                }
            }
            for(int i : nums) {
                if(!freqs.containsKey(i)) freqs.put(i, 0);
                freqs.put(i, freqs.get(i) + 1);
            }
            int highestFoundFrequency = highestFrequencyOf(freqs);
            int c = 0;
            boolean firstFind = false;
            for(int frequency : freqs.values()) {
                if(highestFoundFrequency <= frequency) {
                    if(!firstFind || highestFoundFrequency == frequency) c++;
                    highestFoundFrequency= frequency;
                    firstFind = true;
                }
            }
            String yn = c > 1 ? "S": "";
            System.out.println(c +" MODE" + yn);
        }
    }
    static int highestFrequencyOf(HashMap<Integer, Integer> numbers) {
        int a = 0;
        for(int i : numbers.values()) {
            if(i > a) a = i;
        }
        return a;
    }
}
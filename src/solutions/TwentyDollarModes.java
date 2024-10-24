package solutions;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class TwentyDollarModes {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr50.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            int[] highestModeCount = {-1, -1};
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
                int nc = freqs.get(i);
                if(highestModeCount[0] < nc) {
                    highestModeCount[0] = nc;
                    highestModeCount[1] = i;
                }
             }
            int cc=0;
            for(int j : nums) {
                if(freqs.get(j) == highestModeCount[0]) cc++;
            }
            System.out.println(cc);
        }
    }
}
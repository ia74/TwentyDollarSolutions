package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class TwentyDollarEmmanuel {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("emmanuel.dat"));
        int nSets = scan.nextInt();
        scan.nextLine();
        while(nSets-->0) {
            String line = scan.nextLine();
            String fixy = line.split("\\{")[1].split("}")[0];
            String[] nums = fixy.split(",");

            ArrayList<Integer> realNums = new ArrayList<>();
            for(String a : nums) realNums.add(Integer.parseInt(a));

            HashMap<Integer, Integer> FREAKrency = new HashMap<>();

            for(Integer numy : realNums) {
                if(!FREAKrency.containsKey(numy)) FREAKrency.put(numy, 0);
                int b = FREAKrency.get(numy);
                FREAKrency.put(numy, b+1);
            }

            AtomicInteger lastKey = new AtomicInteger(-1);
            AtomicInteger lastValue = new AtomicInteger(-1);
            FREAKrency.forEach((a, b) -> {
                if(lastValue.get() < b) {
                    lastKey.set(a);
                    lastValue.set(b);
                }
            });
            System.out.println(lastKey +" appeared " + lastValue + " times(s)");
        }
    }
}

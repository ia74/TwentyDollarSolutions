package solutions;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class TwentyDollarGirish {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("girish.dat"));
        HashMap<Integer, ArrayList<Integer>> list = new HashMap<>();
        int listIndex = 0;
        Set<Double> uniqueSet = new TreeSet<>();
        List<Double> uniqueList = new ArrayList<>();
        while(scan.hasNextLine()) {
            String ln = scan.nextLine();
            if(ln.equals("-".repeat(10))) {
                double[] statistics = {0,0,0}; // median mean, mean sum, mode kinda
                HashMap<Integer, Integer> frequencyMap = new HashMap<>();
                for(ArrayList<Integer> i : list.values()) {
                    DoubleStream stream = i.stream().mapToDouble(e -> e);
                    stream.average().ifPresent((e) -> {
                        statistics[0] += e;
                        statistics[1] += e;
                    });
                    i.forEach((e) -> {
                        uniqueSet.add(Double.valueOf(e));
                    });
                }

                for(Double i : uniqueSet) {
                    if(!uniqueList.contains(i)) uniqueList.add(i);
                }

                for(Double i : uniqueList) {

                }

                statistics[0] /= list.size();
                statistics[2] = mode(frequencyMap);
                System.out.println(frequencyMap);

                System.out.printf("Median Mean: %.2f%n", statistics[0]);
                System.out.printf("Mean Sum: %.2f%n", statistics[1]);
                System.out.printf("Mode Kinda: %.2f%n", statistics[2]);

                list = new HashMap<>();
                listIndex = 0;
                continue;
            }

            if(!list.containsKey(listIndex)) list.put(listIndex, new ArrayList<>());

            Arrays.stream(ln.split(" ")).mapToInt(Integer::parseInt).forEach(list.get(listIndex)::add);

            listIndex++;
        }
    }

    static int mode(HashMap<Integer, Integer> IntegerMap) {
        int[] mode = new int[] {0, 0}; // num, freq
        Object[] keys = IntegerMap.keySet().toArray();
        Object[] values = IntegerMap.values().toArray();
        for(int i = 0; i < keys.length; i++) {
            System.out.println(i +" " + IntegerMap);
            if(mode[1] < (int) values[i]) {
                mode[0] = (int) keys[i];
                mode[1] = (int) values[i];
            }
        }
        return mode[0];
    }
}
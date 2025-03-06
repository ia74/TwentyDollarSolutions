package solutions;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class TwentyDollarHappyNumbers {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLong()) {
            long input = scan.nextLong();
            HashSet<Integer> values = new HashSet<>();
            long[] numers = numberToArray(input);
            boolean isHappy;
            while(true) {
                int out = squareAndAdd(numers);
                numers = numberToArray(out);
                if(!values.add(out)) {
                    isHappy = false;
                    break;
                }
                if(out == 1) {
                    isHappy = true;
                    break;
                }
            }

            System.out.println(input+" is a" + (isHappy ? " happy" :"n unhappy") +" number");
        }
    }

    static long[] numberToArray(long num) {
        return Arrays.stream(Long.toString(num).split("")).mapToLong(Long::parseLong).toArray();
    }
    static int squareAndAdd(long[] nums) {
        int out = 0;
        for(long i : nums) {
            out += (int) Math.pow(i, 2);
        }
        return out;
    }
}

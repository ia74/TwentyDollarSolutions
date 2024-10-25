package solutions;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarStats {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("stats.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        while(sets-- > 0) {
            String line = scan.nextLine();
            String[] spaces = line.split(" ");
            int empc = 0;
            for(String s : spaces) {
                if(s.isEmpty()) {
                    int holyterrydavis = 0;
                    String[] tmp = new String[spaces.length - 1];
                    for(int i = 0; i < spaces.length; i++) {
                        if(i != empc) tmp[i - holyterrydavis] = spaces[i];
                        else holyterrydavis++;
                    }
                    spaces = tmp;
                }
                empc++;
            }
            int[] list = new int[spaces.length];
            int count = 0;
            for(String a : spaces) {
                int b = getB(a);
                list[count] = b;
                count++;
            }
            double median = gmedian(list);
            double average = addAll(list) / list.length;
            System.out.printf("%.2f%n", Math.abs(median - average));
///19147.77a
        }
    }
    private static int getB(String a) {
        try {
            int b = Integer.parseInt(a);
            return b;
        } catch(Exception e) {
            return 0;
        }
    }

    public static double addAll(int[] list) {
        double ret = 0;
        for(int i : list) ret += i;
        return ret;
    }

    public static double gmedian(int[] list) {
        double ret = 0;
        Arrays.sort(list);
        if(list.length % 2 == 0) {
            int middle = list.length / 2;
            int lowIndex = middle - 1;
            int highIndex = middle;
            ret += list[lowIndex];
            ret += list[highIndex];
            ret /= 2;
        } else {
            ret = list[list.length / 2];
        }
        return ret;
    }
}
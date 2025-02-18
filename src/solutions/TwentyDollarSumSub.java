package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarSumSub {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("sumSub.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            int wanted = scan.nextInt();
            scan.nextLine();
            int[] unknown = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int csa;
            out:
            for(int i = 0; i < unknown.length; i++) {
                csa = wanted - unknown[i];
                if(unknown[i] == wanted) {
                    System.out.println(i);
                    break;
                }
                for(int j = i+1; j < unknown.length; j++) {
                    if(unknown[j] == wanted) {
                        System.out.println(j);
                        break out;
                    }
                    if(i == j) continue;
                    csa -= unknown[j];
                    if(csa == 0) {
                        System.out.println(i +" " + j);
                        break out;
                    }
                }
            }
        }
    }
}

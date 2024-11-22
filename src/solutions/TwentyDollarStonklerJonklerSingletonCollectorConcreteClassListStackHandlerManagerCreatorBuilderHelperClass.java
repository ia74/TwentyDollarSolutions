package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarStonklerJonklerSingletonCollectorConcreteClassListStackHandlerManagerCreatorBuilderHelperClass {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("stocks.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            ArrayList<String> stonks = new ArrayList<>();
            String line = scan.nextLine();
            int[] stonkers = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int buy = 0;
            int sell = 0;
            for(int i = 0; i < stonkers.length; i++) {

            }
        }
    }
}

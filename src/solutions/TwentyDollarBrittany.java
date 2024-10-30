package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TwentyDollarBrittany {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("brittany.dat"));
        int count = 0;
        double num = 0;
        while (scan.hasNextDouble()) {
            num += scan.nextDouble();
            count++;
        }
        System.out.printf("%.2f %.2f", num, (num / count));
    }
}

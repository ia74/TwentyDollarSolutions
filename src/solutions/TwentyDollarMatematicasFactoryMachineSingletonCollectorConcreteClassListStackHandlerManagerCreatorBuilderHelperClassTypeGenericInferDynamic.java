package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TwentyDollarMatematicasFactoryMachineSingletonCollectorConcreteClassListStackHandlerManagerCreatorBuilderHelperClassTypeGenericInferDynamic {
    static long factorial(long n) {
        if(n==0) return n+1;
        return n*factorial(n-1);
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("factorials.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            for(int i = a; i < b+1; i++) {
                long fct = factorial(i);
                System.out.print(fct +" ");
            }
            System.out.println();
        }
    }
}

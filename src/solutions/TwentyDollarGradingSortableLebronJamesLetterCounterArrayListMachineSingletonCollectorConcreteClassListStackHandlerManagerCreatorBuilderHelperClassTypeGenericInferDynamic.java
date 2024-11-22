package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarGradingSortableLebronJamesLetterCounterArrayListMachineSingletonCollectorConcreteClassListStackHandlerManagerCreatorBuilderHelperClassTypeGenericInferDynamic {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("pr170.dat"));
        int noSets = scan.nextInt();
        scan.nextLine();
        while(noSets-- > 0) {
            int grade = scan.nextInt();
            if(grade > 60) {
                for(int i = 0; i <= 5; i++) {
                    if((grade + i) % 5 == 0) {grade += i;break;}
                }
            }
            System.out.println(grade);
        }
    }
}

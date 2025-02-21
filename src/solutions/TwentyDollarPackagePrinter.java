package solutions;

import java.io.FileNotFoundException;

public class TwentyDollarPackagePrinter {
    public static void main(String[] args) throws FileNotFoundException {
        Class<TwentyDollarKsenyia> theClass = TwentyDollarKsenyia.class;
        Package pkg = theClass.getPackage();
        System.out.println(pkg.getName());
        System.out.println(theClass.getSimpleName());
    }
}

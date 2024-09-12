package solutions;

import java.math.BigInteger;

public class TwentyDollarGCD {
    public static BigInteger gcdOfBigInteger(int a, int b) {
        BigInteger TDGCDThing = new BigInteger(String.valueOf(a));
        BigInteger TDGCDThing2 = new BigInteger(String.valueOf(b));
        return TDGCDThing.gcd(TDGCDThing2);
    }
    public static int gcdOfRecursive(int a, int b) {
        if (a == b) return a;
        if (a < b) return gcdOfRecursive(b, a);
        int r = a - b * (int) (double) (a / b);
        if (r == 0) return b;
        else return gcdOfRecursive(b, r);
    }
    public static int gcdOfNoRecursive(int a, int b) {
        if (a == b) return a;
        if (a < b) return gcdOfNoRecursive(b, a);
        boolean flag = false;
        while(!flag) {
            int r = a - b * (int) (double) (a / b);
            if (r == 0) flag = true;
        }
        return b;
    }
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}

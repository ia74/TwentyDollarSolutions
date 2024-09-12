package tests;

import static solutions.TwentyDollarGCD.*;

public class TDGCD {
    public static void main(String[] args) {
        System.out.println("BigInteger:");
        System.out.println(gcdOfBigInteger(30, 5));
        System.out.println(gcdOfBigInteger(5, 30));
        System.out.println("Recursion:");
        System.out.println(gcdOfRecursive(30, 5));
        System.out.println(gcdOfRecursive(5, 30));
        System.out.println("No Recursion:");
        System.out.println(gcdOfNoRecursive(30, 5));
        System.out.println(gcdOfNoRecursive(5, 30));
        System.out.println("Recursion 2:");
        System.out.println(gcd(30, 5));
        System.out.println(gcd(5, 30));
    }
}

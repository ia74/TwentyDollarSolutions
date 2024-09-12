package tests;

import java.util.ArrayList;
import solutions.TwentyDollarArrayList;

public class TDArrayList {
    public static void main(String[] args) {
        TwentyDollarArrayList ml = new TwentyDollarArrayList();
        ml.add(1);
        ml.add(2);
        ml.add(3);
        ml.add(4);
        ml.add(5);
        ml.add(6);
        ml.add(7);
        System.out.println("0 1 2 3 4 5 6 7\n");
        System.out.println(ml);
        ml.add(3, 3);
        System.out.println(ml + " | added idx3 v3");
        ml.remove(3);
        System.out.println(ml +" | removed idx3");
        int last = ml.set(2, 4);
        System.out.println(ml +" | replaced idx2, v" + last +" with 4");
        ml.removeObj(6);
        System.out.println(ml +" | removed v6");
        System.out.println(ml.get(1));

        ArrayList<Integer> al = new ArrayList<>();
        al.add(35);
        al.add(35);
        al.add(35);
        al.add(35);
        System.out.println(al);
    }
}
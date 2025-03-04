package solutions.cw25;

import java.util.*;
import java.lang.*;

public class prob02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String longLine = scan.nextLine();
        int threeCount = 0;
        String collection = "";
        for(int i = 0; i < longLine.length(); i++) {
            if(threeCount++ != 2) {
                System.out.print(longLine.charAt(i));
            } else {
//                collection += longLine.charAt(i).trim();
                threeCount = 0;
            }
        }
        System.out.println(collection);
    }
}

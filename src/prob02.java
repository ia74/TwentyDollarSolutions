import java.util.*;
import java.io.*;
import java.beans.*;
import java.lang.*;
import java.math.*;
import java.time.*;

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

package solutions;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class TwentyDollarSeema {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("seema.dat"));
        scan.useDelimiter(",");
        HashMap<String, Integer> hashMap = new HashMap<>();
        while(scan.hasNext()) {
            String a = scan.next();
            if(!hashMap.containsKey(a)) hashMap.put(a, 0);
            hashMap.put(a, hashMap.get(a) + 1);
        }
        hashMap.forEach((a, b) -> {
            System.out.println(a+" "+b);
        });
    }
}
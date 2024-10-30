import java.util.*;
import java.io.*;
public class TwentyDollarMagdalena {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<Integer, String> letters = new HashMap<>();
        for(int i = 0; i < 48; i++) {
            if(i <= 9) {
                letters.put(i, String.valueOf(i));
            }
            if(i >= 10 && i < 36) {
                letters.put(i, String.valueOf((char) (55+i)));
            }
            if(i > 35 && i < 60) {
                letters.put(i, String.valueOf((char) (61+i)));
            }
        }
        Scanner scan = new Scanner(new File("magdalena.dat"));
        int nSets = scan.nextInt();
        int rs = nSets;
        scan.nextLine();
        while(nSets-->0) {
            int n = scan.nextLine();
            System.out.println(letters);
            System.out.println("Case #" + (rs - nSets) + ": a");
        }
    }
}

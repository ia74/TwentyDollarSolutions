package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarPranav {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("pranav.dat"));
        int nSets = scan.nextInt();
        scan.nextLine();
        while(nSets-->0) {
            int[] moves = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] mvScores = new int[] {0, 0, 0, 0}; // 0 - I pick first, 1 - I pick second, 2 - THEY if you pick first, 3 - THEY if you pick second
            for(int i = 0; i < moves.length-1; i +=2) {
                int mv1 = moves[i];
                int mv2 = moves[i+1];
                mvScores[0] += mv1;
                mvScores[1] += mv2;
                mvScores[2] += mvScores[0] + mv2;
                mvScores[3] += mvScores[1] + mv1;
            }
            System.out.println(Arrays.toString(mvScores));

            int a = mvScores[0];
            boolean b = false;
            for(int i = 1; i < mvScores.length; i++) {
                if(a != mvScores[i]) {
                    b = true;
                    break;
                }
            }
            if(b) {
                int Ipf = mvScores[0];
                int Ips = mvScores[1];
                System.out.println(Ipf);
            } else {
                System.out.println("Tie " + mvScores[0]);
            }
        }
    }
}
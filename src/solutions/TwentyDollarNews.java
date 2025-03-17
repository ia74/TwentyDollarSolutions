package solutions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarNews {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("news.dat"));
        String vn = "Magneto Juggernaut Apocalypse Mystique Sentinels";
        String wt = "Thanos Galactus Kang Ultron Graviton";

        ArrayList<String> villains = new ArrayList<>(Arrays.asList(vn.split(" ")));
        ArrayList<String> threats = new ArrayList<>(Arrays.asList(wt.split(" ")));

        int nSets = scan.nextInt();
        scan.nextLine();
        while(nSets-->0) {
            String line = scan.nextLine();
            String[] words = line.split(" ");
            boolean hasVillain = false;
            boolean hasThreats = false;
            for(String word : words) {
                if(threats.contains(word)) hasThreats = true;
                if(villains.contains(word)) hasVillain = true;
            }
            System.out.println(hasThreats ? "Calling All Heroes." : hasVillain ? "Sharpen Your Claws Wolverine." : "Business as Usual.");
        }
    }
}
package solutions;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class TwentyDollarHoward {
    public static class HowardPlayer {
        int number;
        String name;
        String position;
        double pts;
        double apg;
        double fga;
        double fta;
        double tpg;
        double tsPMO;
        double att;
        public HowardPlayer(int number, String name, String position, double pts, double apg, double fga, double fta, double tpg) {
            this.number = number;
            this.name = name;
            this.position = position;
            this.pts = pts;
            this.apg = apg;
            this.fga = fga;
            this.fta = fta;
            this.tpg = tpg;
            this.tsPMO = (this.pts) / (2 * (this.fga + 0.44 * this.fta));
            this.att = apg / tpg;
        }
        public String toString() {
            return number +". " + name;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("howard.dat"));
        int nSets = scan.nextInt();
        scan.nextLine();
        HashMap<String, ArrayList<HowardPlayer>> positionsToPlayers = new HashMap<>();
        while(nSets-->0) {
            int no = scan.nextInt();
            String name = scan.next();
            String pos = scan.next();
            double pts = scan.nextDouble();
            double apg = scan.nextDouble();
            double fga = scan.nextDouble();
            double fta = scan.nextDouble();
            double tpg = scan.nextDouble();
            HowardPlayer player = new HowardPlayer(no, name, pos, pts, apg, fga, fta, tpg);
            if(!positionsToPlayers.containsKey(pos)) positionsToPlayers.put(pos, new ArrayList<>());
            positionsToPlayers.get(pos).add(player);
        }

        Comparator<HowardPlayer> tsPmo = (a, b) -> {
            if(a.tsPMO == b.tsPMO) {
                return Double.compare(b.att, a.att);
            } else {
                return Double.compare(b.tsPMO, a.tsPMO);
            }
        };

        for(ArrayList<HowardPlayer> player : positionsToPlayers.values()) {
            player.sort(tsPmo);
        }

        System.out.println(out(positionsToPlayers, "PG"));
        System.out.println(out(positionsToPlayers, "SG"));
        System.out.println(out(positionsToPlayers, "SF"));
        System.out.println(out(positionsToPlayers, "PF"));
        System.out.println(out(positionsToPlayers, "C"));
    }
    static String out(HashMap<String, ArrayList<HowardPlayer>> list, String lookingFor) {
        return lookingFor+": " + list.get(lookingFor).getFirst().toString();
    }
}
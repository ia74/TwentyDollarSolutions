package solutions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TwentyDollarWordStats {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr75.dat"));
        String line = scan.nextLine();
        String[] spaces = line.split(" ");
        ArrayList<Integer> wordLengths = new ArrayList<>();
        int vow = 0;
        int con = 0;
        int other = 0;
        int spacesC = 0;
        for(String a : spaces) {
            for(String b : a.split("")) {
                switch(b.toLowerCase()) {
                    case "a":
                    case "e":
                    case "i":
                    case "o":
                    case "u":
                        vow++;
                        break;
                    case "b":
                    case "c":
                    case "d":
                    case "f":
                    case "g":
                    case "h":
                    case "j":
                    case "k":
                    case "l":
                    case "m":
                    case "n":
                    case "p":
                    case "q":
                    case "r":
                    case "s":
                    case "t":
                    case "v":
                    case "w":
                    case "x":
                    case "y":
                    case "z":
                        con++;
                        break;
                    default:
                        other++;
                        break;
                }
            }
            wordLengths.add(a.length());
            spacesC++;
        }
        Object[] a = wordLengths.toArray();
        Arrays.sort(a);

        double avgwl = 0;
        for(Object i : a) {
            avgwl += Double.parseDouble(i.toString());
        }
        avgwl /= wordLengths.size();

        String[] evilLine = line.split(" ");

        System.out.println("VOWELS - " + vow);
        System.out.println("CONSONANTS - " + con);
        System.out.println("SPACE - " + (spacesC - 1));
        System.out.println("OTHER - " + other);
        System.out.println("WORDS - " + evilLine.length);
        System.out.println("LONGEST - " + a[a.length - 1]);
        System.out.println("SHORTEST - " + a[0]);
        System.out.println("AVERAGE - " + String.format("%.1f", avgwl));
    }
}
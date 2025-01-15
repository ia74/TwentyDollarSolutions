package solutions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TwentyDollarJustification {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("pr76.dat"));
        String text = scan.nextLine();
        String[] line = text.split(" ");
        System.out.println("1234567890123456789012345678901234567890");
        ArrayList<String> lns = new ArrayList<>();
        String ln = "";
        System.out.println(text);
    }
}
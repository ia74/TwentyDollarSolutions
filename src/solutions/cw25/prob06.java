package solutions.cw25;

import java.util.*;
import java.lang.*;

public class prob06 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int area = scan.nextInt();
		ArrayList<String> valid = new ArrayList<String>();
		ArrayList<Integer> used = new ArrayList<Integer>();
		for (int i = area - 1; i > 1; i--) {
			if (area % i == 0 && !used.contains(i)) {
				valid.add(i + " x " + (area/i));
				used.add(i);
				used.add(area/i);
			}
		}
		for (String s: valid) {
			System.out.println(s);
		}
		System.out.println();
	}
}

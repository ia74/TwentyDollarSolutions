package solutions.cw25;

import java.util.*;
import java.lang.*;

public class prob05 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int shorten = scan.nextInt();
		String num = "0";
		scan.nextLine();
		num = scan.nextLine();
		while (!num.equals("000")) {
			int decimal = num.indexOf(".");
			if (num.length() - decimal > shorten) {
				num = num.substring(0, decimal + shorten + 1);
			}
			System.out.println(num);
			num = scan.nextLine();
		}
	}
}

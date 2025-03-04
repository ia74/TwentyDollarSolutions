package solutions.cw25;

import java.util.*;
import java.lang.*;

public class prob09 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] parse = scan.nextLine().split(" ");
		String f = "";
		for(int i = 0; i<parse.length;i++) {
			f+=parse[i].charAt(0);
		}
		System.out.println(f);
	}
}

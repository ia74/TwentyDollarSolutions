package solutions.cw25;

import java.util.*;
import java.lang.*;

public class prob08 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String baseAAA = scan.nextLine();
		String base = baseAAA.toLowerCase();
		String chAAA = scan.nextLine();
		String ch = chAAA.toLowerCase();
		String AAAA = ch.toUpperCase();
		int count = 0;
		for(int i = 0; i<base.length();i++){
			if(base.charAt(i)==ch.charAt(0)){
				count++;
			}
		}
		System.out.print("There are "+count+" "+AAAA+"'s in "+baseAAA);
	}
}

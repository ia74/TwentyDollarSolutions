package solutions.cw25;

import java.util.*;
import java.lang.*;

public class prob10 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			String strung = scan.nextLine();
			if(strung.equals("000")) {
				break;
			}
			char[] chart = strung.toCharArray();
			for(int i = 0; i<chart.length;i++) {
				if(Integer.valueOf(chart[i])>=65 && Integer.valueOf(chart[i])<=90) {
					chart[i]+=32;
				} else if (Integer.valueOf(chart[i])>=97 && Integer.valueOf(chart[i])<=122) {
					chart[i]-=32;
				}
			}
			System.out.println(String.valueOf(chart));
		}
	}
}

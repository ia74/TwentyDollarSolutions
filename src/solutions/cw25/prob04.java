package solutions.cw25;

import java.util.*;
import java.lang.*;

public class prob04 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String name = scan.next();
		int vendorCount = scan.nextInt();
		int money = 0;
		int[] counts = {0,0,0};
		while(vendorCount-->0) {
			int shirt = scan.nextInt();
			int hat = scan.nextInt();
			int sticker = scan.nextInt();
			money += (shirt * 13);
			money += (hat * 9);
			money += (sticker * 2);
			counts[0] += shirt;
			counts[1] += hat;
			counts[2] += sticker;
		}
		System.out.print(name+" spent $" + money +" on ");
		System.out.print(counts[0]+" " + (counts[0] > 1 ? "shirts" : (counts[0] == 0?"shirts":"shirt"))+", ");
		System.out.print(counts[1]+" " + (counts[1] > 1 ? "hats" : (counts[1] == 0?"hats":"hat"))+", and ");
		System.out.print(counts[2]+" " + (counts[2] > 1 ? "stickers" : (counts[2] == 0?"stickers":"sticker"))+".");
		System.out.println();
	}
}

import java.util.*;
import java.io.*;
import java.beans.*;
import java.lang.*;
import java.math.*;
import java.time.*;

public class prob13 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		while (!line.equals("0 0")) {
			String[] nums = line.split(" ");
			int n = Integer.parseInt(nums[0]);
			int d = Integer.parseInt(nums[1]);
			if (n % d == 0) {
				System.out.println(n/d);
			}
			else if (n > d) {
				System.out.print(n/d + " ");
				n %= d;
			}
			if (n < d) {
				for (int i = n; i > 1; i--) {
					if (n % i == 0 && d % i == 0) {
						n /= i;
						d /= i;
						i++;
					}
				}
				System.out.println(n + "/" + d);
			}
			line = scan.nextLine();
		}
	}
}

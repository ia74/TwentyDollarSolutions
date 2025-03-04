package solutions.cw25;

import java.util.*;
import java.lang.*;

public class prob12 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int A = arr[0];
		int B = arr[1];
		int D = arr[2];
		int C = A & B;
		int E = C | D;
		System.out.println(C+" "+E);
	}
}

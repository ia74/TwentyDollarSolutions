package solutions.cw25;

import java.util.*;
import java.lang.*;

public class prob18 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = Arrays.stream(scan.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
		if(arr[1]-arr[0]==arr[2]-arr[1]&&arr[1]-arr[0]>0){ // add
			int cd = arr[1]-arr[0];
			int fincal = arr[arr.length-1];
			int next = fincal+cd;
			System.out.println("Sequence: +"+cd);
			System.out.println("Next: "+next);

		} else if (arr[1]/arr[0]==arr[2]/arr[1]&&arr[1]/arr[0]>0){ //mult
			int cr = arr[1]/arr[0];
			int fincal = arr[arr.length-1];
			int next = fincal*cr;
			System.out.println("Sequence: *"+cr);
			System.out.println("Next: "+next);
		}

		else if(arr[1]-arr[0]==arr[2]-arr[1]&&arr[1]-arr[0]<0){ // sub
			int cd = Math.abs(arr[1]-arr[0]);
			int fincal = arr[arr.length-1];
			int next = fincal-cd;
			System.out.println("Sequence: -"+cd);
			System.out.println("Next: "+next);

		} else if (arr[1]/arr[0]==arr[2]/arr[1]&&arr[1]/arr[0]==0){ //div
			int cr = arr[0]/arr[1];
			int fincal = arr[arr.length-1];
			int next = fincal/cr;
			System.out.println("Sequence: /"+cr);
			System.out.println("Next: "+next);
		}



		else {
			System.out.println("Sequence: UNKNOWN");
			System.out.println("Next: UNKNOWN");
		}
	}
}

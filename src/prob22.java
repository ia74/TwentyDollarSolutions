import java.util.Scanner;
import java.util.*;

public class prob22 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] look = new int[600];
		int count = 1;
		for(int i = 1000000;i<9000000;i++){
			char[] strung = String.valueOf(i).toCharArray();
			Arrays.sort(strung);
			String fixed = String.valueOf(strung);
			if(fixed.equals("1234567")&&(i%11==0)){
				look[count]=i;
				count++;
			}
		}
		while(scan.hasNext()){
			int n = scan.nextInt();
			if(n==0){
				break;
			}
			System.out.println(look[n]);
		}
	}
}

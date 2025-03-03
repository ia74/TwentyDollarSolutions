import java.util.*;
import java.io.*;
import java.beans.*;
import java.lang.*;
import java.math.*;
import java.time.*;

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

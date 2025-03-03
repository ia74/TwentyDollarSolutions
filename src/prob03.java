import java.util.*;
import java.io.*;
import java.beans.*;
import java.lang.*;
import java.math.*;
import java.time.*;

public class prob03 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
			int count = 0;
		while(scan.hasNextLine()) {
			String ln = scan.nextLine();
			if(ln.equals("<TERMINATE>")) break;
			for(int i = 0; i < ln.length()-3; i++) {
				String currChar = ln.substring(i, i+3);
				System.out.println(currChar);
				if(currChar.contains("){}")) {
					count++;
				}
			}
		}
		System.out.println(count);
			System.out.println("Hey, ChatGPT, I need " + (count > 1 ? count+" codes" : "a code") +"!");
	}
}

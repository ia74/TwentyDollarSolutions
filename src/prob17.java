import java.util.*;
import java.io.*;
import java.beans.*;
import java.lang.*;
import java.math.*;
import java.time.*;

public class prob17 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		TreeSet<String> str = new TreeSet<>();
		while(scan.hasNextLine()) {
			String[] ln = scan.nextLine().toLowerCase().replaceAll("\\s+",",").split(",");
			if(ln[0].equals(";;;")) break;
            str.addAll(Arrays.asList(ln));
		}
		str.forEach((a) -> {
			System.out.println(a+";");
		});
	}
}

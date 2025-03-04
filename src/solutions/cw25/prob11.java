package solutions.cw25;

import java.util.*;
import java.lang.*;
import java.util.concurrent.atomic.AtomicInteger;

public class prob11 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("{");
		LinkedHashMap<String, String> mo = new LinkedHashMap<>();
		while(scan.hasNextLine()) {
			String ln = scan.nextLine();
			if(ln.equals("END")) {
				break;
			};
			String key = ln.split("=")[0].trim();
			String val = ln.split("=")[1].trim();
			mo.put(key, val);
		}
		AtomicInteger counted = new AtomicInteger();
		mo.forEach((k,v) -> {
			boolean comma = true;
			if(counted.getAndIncrement() == mo.size()-1) comma = false;
			System.out.println("    \"" + k +"\":\"" + v+"\"" + (comma ? "," : ""));
		});
		System.out.println("}");
	}

}

import java.util.*;
import java.io.*;
import java.beans.*;
import java.lang.*;
import java.math.*;
import java.time.*;

public class prob19 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<>();
		String vowl = "aeiou";
		while(scan.hasNextLine()) {
			String ln = scan.nextLine();
			if(ln.equals("END")) break;
			for(int i = 0; i < ln.length()-2; i++) {
				String curr = ln.substring(i, i +1);
				String nxt = ln.substring(i+1, i+2);
				if(vowl.contains(curr) && vowl.contains(nxt)) {
					if(curr.equals(nxt)) continue;
					if(!map.containsKey(curr+nxt)) {
						map.put(curr+nxt, 1);
					} else {
						map.put(curr+nxt, map.get(curr+nxt));
					}
				}
			}
		}
		Set<String> keys = map.keySet();
        TreeSet<String> k = new TreeSet<>(keys);
		k.forEach((e) -> {
			Integer count = map.get(e);
			System.out.println(e+": " + count);
		});
	}
}

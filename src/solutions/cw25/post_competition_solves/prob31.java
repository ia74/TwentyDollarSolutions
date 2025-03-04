package solutions.cw25.post_competition_solves;

import java.util.LinkedList;
import java.util.Scanner;

public class prob31 {
	static class BaseConverter {
		int base = 3;
		BaseConverter(int base) {
			this.base = base;
		}
		private String _charToBase(char i) {
			return Integer.toString(i, base);
		}
		String encode(String in) {
			LinkedList<String> chars = new LinkedList<>();
			char[] e = in.toCharArray();
			for(char i : e) {
				if(i == ' ') {
					chars.add(" ");
				} else {
					chars.add(_charToBase(i));
				}
			}
			String out = "";
			for(int i = 0; i < chars.size()-1; i++) {
				String cc = chars.get(i);
				String nxt = chars.get(i+1);


				if(nxt.equals(" ") || cc.equals(" ")) {
					out += cc;
				} else {
					out += cc;
					if(i != chars.size()-2) out += ",";
				}

				if(i == chars.size()-2) out += ","+nxt;
			}
			return out;
		}
		String decode(String fromBase) {
			LinkedList<String> trueThing = new LinkedList<>();
			String[] spl = fromBase.split(",");
			for(String i : spl) {
				i = i.trim();
				if(i.contains(" ")) {
					String[] parts = i.split(" ");
					trueThing.add(parts[0]);
					trueThing.add(_charToBase(' '));
					trueThing.add(parts[1]);
				} else {
					trueThing.add(i);
				}
			}
			String out = "";
			for(String str : trueThing) {
				int num = Integer.parseInt(str, base);
				char realValue = (char) num;
				out += realValue;
			}
			return out;
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String lnToConvert = scan.nextLine();
		int baseToUse = scan.nextInt();
		BaseConverter bc = new BaseConverter(baseToUse);
		String out = bc.encode(lnToConvert);
		System.out.println(out);
	}
}

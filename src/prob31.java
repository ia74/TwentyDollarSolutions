import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class prob31 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String ln = scan.nextLine();
		LinkedList<String> trueThing = new LinkedList<>();
		String[] spl = ln.split(",");
		for(String i : spl) {
				i = i.trim();
			if(i.contains(" ")) {
				String[] parts = i.split(" ");
                trueThing.addAll(Arrays.asList(parts));
			} else {
				trueThing.add(i);
			}
		}
		for(String str : trueThing) {
			int num = Integer.parseInt(str, 3);
			char realValue = (char) num;
			System.out.println(realValue);
		}
	}
}

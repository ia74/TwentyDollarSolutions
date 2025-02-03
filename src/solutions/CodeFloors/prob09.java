package solutions.CodeFloors;
import java.util.*;
import java.io.*;
public class prob09 {
	public static class LebronDate {
		int year;
		int month;
		int day;
		public LebronDate(int year, int mo, int day) {
			this.year= year;
			this.month = mo;
			this.day = day;
		}
		public LebronDate(String d) {
			this(
					Integer.parseInt(d.split("-")[0]),
					Integer.parseInt(d.split("-")[1]),
					Integer.parseInt(d.split("-")[2])
			);
		}
		public void icDay() {
			this.day++;
		}
		public void icMo() {
			this.month++;
		}
		public void icYear() {
			this.year++;
		}
		public String toPad(String s) {
			return s.length() > 1 ? s : "0"+s;
		}
		public String toPad(int a) {
			return toPad(Integer.toString(a));
		}
		public String toString() {
			return year+"-"+toPad(month)+"-"+toPad(day);
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("input.txt"));
		String opcode = scan.nextLine();
		String start = scan.nextLine();
		String end = scan.nextLine();
		LebronDate dLower = new LebronDate(start);
		LebronDate dUpper = new LebronDate(end);
		
		a(dLower, dUpper);
	}
	
	public static void a(LebronDate dLower, LebronDate dUpper) {
		while(dLower.day++ < 31) {
			System.out.println(dLower);
			System.out.println(dUpper);
		}
		while(dLower.month++ < 12) {
			System.out.println(dLower);
			System.out.println(dUpper);
		}
	}
}

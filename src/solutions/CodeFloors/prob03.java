package solutions.CodeFloors;
import java.util.*;
import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public class prob03 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("judging/cw2025_openbeta/prob03-1-in.txt"));
		while(scan.hasNextLine()) {
			String ln = scan.nextLine();
			if(ln.equals("END")) break;
			
			Scanner leb = new Scanner(ln);
			double n1 = leb.nextInt();
			double n2 = leb.nextInt();
			String operand = leb.next();
			double whatThey = leb.nextDouble();
			double trueout = 0;
			
			switch(operand) {
				case "DIVIDE":
					operand = "/";
					trueout = n1 / n2;
					break;
				case "MULTIPLY":
					operand = "*";
					trueout = n1 * n2;
					break;
				case "SUBTRACT":
					operand = "-";
					trueout = n1 - n2;
					break;
				case "ADD":
					operand = "+";
					trueout = n1 + n2;
					break;
			}
			
			if(whatThey == trueout) {
				System.out.println(
						change(trueout) + " is correct for " + change(n1) + " " + operand +" " + change(n2)		
				);
			} else {
				System.out.println(
						change(n1) + " " + operand +" " + change(n2) + " = " + change(trueout) +", not " + change(whatThey)
				);
			}
		}
	}
	
	static String change(int value) {return change((double) value);} 
	static String change(double value) 
    { 
		DecimalFormat df = new DecimalFormat("#0.0");
		df.setRoundingMode(RoundingMode.DOWN);
        return df.format(value);
      } 
}

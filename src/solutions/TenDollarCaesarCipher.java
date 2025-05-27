import java.util.*;
public class TenDollarCaesarCipher {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(scan.hasNextLine()) {
			String str = scan.nextLine();
			for(int i = -27;i < 27; i++) {
				System.out.println(caesar(str, i)+" - " + ((i < 0) ? i : "+"+i));
			}
		}
	}

	 static String caesar(String input, int decipher) {
	        String out = "";
	        for(int i = 0; i < input.length(); i++) {
	            out += (char)( ((char) (input.charAt(i) + decipher) % 26) +'A');
	        }
	        return out;
	 }
}

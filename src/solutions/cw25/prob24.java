package solutions.cw25;

import java.util.*;

public class prob24 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] x = scan.nextLine().toCharArray();
		char[] y = scan.nextLine().toCharArray();
		char[] z = scan.nextLine().toCharArray();
		String[] px = new String[x.length];
		String[] py = new String[y.length];
		String[] pz = new String[z.length];
		String xx ="";
		String yy = "";
		String zz = "";
		for(int i = 0; i<x.length;i++){
			px[i]=Integer.toString((int)x[i],3);
			xx+=px[i]+".";
		}
		xx=xx.substring(0,xx.length()-1);
		for(int i = 0; i<y.length;i++){
			py[i]=Integer.toString((int)y[i],3);
			yy+=py[i]+".";
		}
		yy=yy.substring(0,yy.length()-1);

		for(int i = 0; i<z.length;i++){
			pz[i]=Integer.toString((int)z[i],3);
			zz+=pz[i]+".";
		}
		zz=zz.substring(0,zz.length()-1);
		System.out.println(xx);
		System.out.println(yy);
		System.out.println(zz);
		String[] fin = scan.nextLine().replaceAll("\\s+","."+Integer.toString(32, 3)+".").split("\\.");
		char[] m = new char[fin.length];
		for(int i = 0; i<fin.length;i++){
			m[i]=(char)(int)Integer.valueOf(fin[i],3);
		}
		for(char s: m){
			System.out.print(s);
		}
		System.out.println();
	}
}

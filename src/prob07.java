import java.util.*;
import java.io.*;
import java.beans.*;
import java.lang.*;
import java.math.*;
import java.time.*;

public class prob07 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<Integer, Integer> freqMap = new HashMap<>();
		int[] arr= Arrays.stream(scan.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
		for(int i : arr) {
			if(!freqMap.containsKey(i)) {
				freqMap.put(i, 0);
			} else {
				freqMap.put(i, freqMap.get(i) + 1);
			}
		}
		int[] leastRepasts = {freqMap.keySet().stream().mapToInt(Integer::valueOf).toArray()[0],
				freqMap.get(freqMap.keySet().stream().mapToInt(Integer::valueOf).toArray()[0])}; // 0 - key, 1 - value
		for(Integer key : freqMap.keySet()) {
			Integer repeatCount = freqMap.get(key);
			if(leastRepasts[1] > repeatCount) {
				leastRepasts[0] = key;
				leastRepasts[1] = repeatCount;
			}
		}
		System.out.println(leastRepasts[0] +": " + leastRepasts[1]);
	}
}

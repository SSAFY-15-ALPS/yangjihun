import java.io.*;
import java.util.*;

public class Main {
	static int[] LPS(String pattern) {
		int len = pattern.length();
		int[] lps = new int[len];
		for (int i=1,j=0; i<len; i++) {
			while (j>0 && pattern.charAt(i)!=pattern.charAt(j)) {
				j = lps[j-1];
			}
			if (pattern.charAt(i)==pattern.charAt(j)) {
				j++;
			}
			lps[i] = j;
		}
		return lps;
	}
	static void KMP(String line, String pattern, int[] lps) {
		int answer = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int lSize = line.length();
		int pSize = pattern.length();
		for (int i=0, j=0; i<lSize; i++) {
			while (j>0 && line.charAt(i)!=pattern.charAt(j)) {
				j = lps[j-1];
			}
			if (line.charAt(i)==pattern.charAt(j)) {
				j++;
			}
			if (j==pSize) {
				answer++;
				arr.add(i-pSize+2);
				j = lps[j-1];
			}
		}
		System.out.println(answer);
		for (int i=0;i<arr.size();i++) {
			System.out.println(arr.get(i));
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String pattern = br.readLine();
		int[] lps = LPS(pattern);
		KMP(line,pattern,lps);
	}
}
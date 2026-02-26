import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static boolean[][] visited;
	static int N;
	
	static int nextInt() throws Exception {
		while (st==null || !st.hasMoreTokens()) {
			String line = br.readLine();
			if (line==null) return Integer.MIN_VALUE;
			st = new StringTokenizer(line);
		}
		return Integer.parseInt(st.nextToken());
	}
	
	
	public static void main(String[] args) throws Exception {
		// 정의
		int N = nextInt();
		int[] arr = new int[N];
		// 할당
		for (int i=0; i<N; i++) {
			arr[i] = nextInt();
		}
		// Solution
		Arrays.sort(arr);
		if (arr[N-1]<=0) {
			System.out.println(arr[N-2] + " " + arr[N-1]);
		}
		else if (arr[0]>=0) {
			System.out.println(arr[0] + " " + arr[1]);
		}
		else {
			int start = 0;
			int end = N-1;
			int[] answer = new int[2];
			int count = Integer.MAX_VALUE;
			
			while (start < end) {
				if (Math.abs(arr[start] + arr[end]) < count) {
					answer[0] = start;
					answer[1] = end;
					count = Math.abs(arr[start] + Math.abs(arr[end]));
				}
				else if (arr[start] + arr[end] > 0) {
					end--;
				}
				else {
					start++;
				}
			}
			System.out.println(arr[answer[0]] + " " + arr[answer[1]]);
		}
	}
}
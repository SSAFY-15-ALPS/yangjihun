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
		int M = nextInt();
		int[] arr = new int[N];
		int start = 0;
		int sum = 0;
		int answer = 0;
		// 할당
		for (int i=0; i<N; i++) {
			arr[i] = nextInt();
		}
		// Solution
		for (int end=0; end<N; end++) {
			sum+=arr[end];
			while (sum>M) {
				sum -= arr[start++];
			}
			if (sum==M) answer++;
		}
		System.out.println(answer);
	}
}
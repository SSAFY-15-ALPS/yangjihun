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
		// Solution
		int[] arr = new int[31];
		arr[0] = 1;
		if (N>=2) arr[2] = 3;
		for (int i=4; i<=N; i+=2) {
			arr[i] = arr[i-2] * 3;
			for (int n=0;n<=i-4;n+=2) {
				arr[i] += arr[n] * 2;
			}

		}
		System.out.println(arr[N]);
	}
}
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
		int S = nextInt();
		int[] arr = new int[N+1];
		// 할당
		for (int i=1; i<=N; i++) {
			arr[i] = nextInt();
		}
		// Solution
		int start = 0;
		int end = 0;
		int sum = 0;
		int answer = Integer.MAX_VALUE;
		while (start <= end) {
			if (sum>=S) {
				answer = Math.min(answer, end - start);
				start++;
				sum-=arr[start];
			}
			else {
				if (end==N) break;
				end++;
				sum+=arr[end];
			}
		}
		System.out.println(answer==Integer.MAX_VALUE ? 0 : answer);
	}
}
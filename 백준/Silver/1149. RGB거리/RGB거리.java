import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int nextInt() throws Exception {
		while(st==null || !st.hasMoreTokens()) {
			String line = br.readLine();
			if (line==null) return Integer.MIN_VALUE;
			st = new StringTokenizer(line);
		}
		return Integer.parseInt(st.nextToken());
	}
	public static void main(String[] args) throws Exception {
		int N = nextInt();
		int[][] dp = new int[N+1][3];
		for (int i=1; i<=N; i++) {
			dp[i][0] = nextInt() + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = nextInt() + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = nextInt() + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
	}
}
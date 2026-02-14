import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int nextInt() throws Exception {
		while (st==null || !st.hasMoreTokens()) {
			String line = br.readLine();
			if (line==null) return Integer.MIN_VALUE;
			st = new StringTokenizer(line);
		}
		return Integer.parseInt(st.nextToken());
	}
	
	public static void main(String[] args) throws Exception {
		int N = nextInt();
		int[][] arr = new int[N+1][3];
		int[][] dp = new int[N+1][3];
		int answer = Integer.MAX_VALUE;
		
		// 할당
		for (int i=1; i<=N; i++) {
			for (int j=0; j<3; j++) {
				arr[i][j] = nextInt();
			}
		}
		for (int startPoint=0; startPoint<3; startPoint++) {
			dp[2][(startPoint+1)%3] = arr[2][(startPoint+1)%3] + arr[1][startPoint];
			dp[2][(startPoint+2)%3] = arr[2][(startPoint+2)%3] + arr[1][startPoint];
			dp[2][startPoint] = Integer.MAX_VALUE;
			for (int i=3 ; i<=N; i++) {
				dp[i][0] = arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
				dp[i][1] = arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
				dp[i][2] = arr[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
			}
			answer = Math.min(answer, Math.min(dp[N][(startPoint+1)%3], dp[N][(startPoint+2)%3]));
		}
		System.out.println(answer);
	}
}

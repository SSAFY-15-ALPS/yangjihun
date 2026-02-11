import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] arr;
	static int nextInt() throws Exception {
		while (st==null || !st.hasMoreTokens()) {
			String line = br.readLine();
			if (line==null) return Integer.MIN_VALUE;
			st = new StringTokenizer(line);
		}
		return Integer.parseInt(st.nextToken());
	}
	
	static int search(int y, int x, int state) {
		if (state==0 && x+1>N && arr[y][x+1]!=1) return 1;
		if (state==1 && x+1>N && y+1>N && arr[y][x+1]!=1 && arr[y+1][x+1]!=1 && arr[y+1][x]!=1) return 1;
		if (state==2 && x+1>N && y+1>N && arr[y+1][x]!=1) return 1;
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		// 선언
		N = nextInt();
		arr = new int[N+1][N+1];
		long[][][] dp = new long[N+1][N+1][3];
		for (int i=1; i<=N;i++) {
			for (int j=1; j<=N;j++) {
				arr[i][j] = nextInt();
			}
		}
		// solution
		dp[1][2][0] = 1;
		for (int y=0; y<=N; y++) {
			for (int x=0; x<=N; x++) {
				if (arr[y][x] == 1) continue;
				
                if (x - 1 >= 1) {
                    dp[y][x][0] += dp[y][x - 1][0] + dp[y][x - 1][1];
                }
                if (y - 1 >= 1) {
                    dp[y][x][2] += dp[y - 1][x][2] + dp[y - 1][x][1];
                }
                if (y - 1 >= 1 && x - 1 >= 1 && arr[y - 1][x] == 0 && arr[y][x - 1] == 0) {
                    dp[y][x][1] += dp[y - 1][x - 1][0] + dp[y - 1][x - 1][1] + dp[y - 1][x - 1][2];
                }
			}
		}
			System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
	}
}
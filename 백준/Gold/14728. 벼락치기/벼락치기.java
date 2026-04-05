import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 선언
		int N = sc.nextInt();
		int T = sc.nextInt();
		int[] time = new int[N+1];
		int[] score = new int[N+1];
		int[][] dp = new int[N+1][T+1];
		// 할당
		for (int i=1; i<=N; i++) {
			time[i] = sc.nextInt();
			score[i] = sc.nextInt();
		}
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=T; j++) {
				dp[i][j] = dp[i-1][j];
				if (time[i]<=j)
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - time[i]] + score[i]);
			}
		}
        System.out.println(dp[N][T]);
	}
}
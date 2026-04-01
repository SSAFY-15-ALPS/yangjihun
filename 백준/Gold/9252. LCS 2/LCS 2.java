import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text1 = sc.next();
		String text2 = sc.next();
		int size1 = text1.length();
		int size2 = text2.length();
		int[][] dp = new int[size1+1][size2+1];
		
		// solution
		for (int i=1; i<=size1; i++) {
			for (int j=1; j<=size2; j++) {
				if (text1.charAt(i-1)==text2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = dp[i-1][j] > dp[i][j-1] ? dp[i-1][j] : dp[i][j-1];
				}
			}
		}
		int answer = dp[size1][size2];
		
		StringBuilder sb = new StringBuilder();
		int i = size1;
		int j = size2;
		while (i > 0 && j > 0) {
			if (text1.charAt(i-1) == text2.charAt(j-1)) {
				sb.append(text1.charAt(i-1));
				i--;
				j--;
			}
			else if (dp[i-1][j] >= dp[i][j-1]) {
				i--;
			}
			else {
				j--;
			}
		}
		System.out.println(dp[size1][size2]);
		System.out.println(sb.reverse().toString());
	}
}

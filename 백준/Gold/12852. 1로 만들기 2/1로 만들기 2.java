import java.io.*;
import java.util.*;
 
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int nextInt() throws IOException {
		while (st==null || !st.hasMoreTokens()) {
			String line = br.readLine();
			if (line==null) return Integer.MIN_VALUE;
			st = new StringTokenizer(line);
		}
		return Integer.parseInt(st.nextToken());
	}
	
    public static void main(String[] args) throws IOException {
    	int N = nextInt();
    	int[] prev = new int[N+1];
    	int[] dp = new int[N+1];
    	
    	// solution
    	dp[N] = 0;
    	prev[N] = 0;
    	for (int i = 2; i <= N; i++) {
    	    dp[i] = dp[i-1] + 1;
    	    prev[i] = i-1;

    	    if (i % 2 == 0 && dp[i] > dp[i/2] + 1) {
    	        dp[i] = dp[i/2] + 1;
    	        prev[i] = i/2;
    	    }

    	    if (i % 3 == 0 && dp[i] > dp[i/3] + 1) {
    	        dp[i] = dp[i/3] + 1;
    	        prev[i] = i/3;
    	    }
    	}
    	System.out.println(dp[N]);
    	int num = N;
    	while (num!=0) {
    		System.out.print(num + " ");
    		num = prev[num];
    	}
    }
}
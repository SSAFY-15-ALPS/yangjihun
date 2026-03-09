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
    	int[] arr = new int[N];
    	int[] dp = new int[N];
    	int answer = 0;
    	
    	for (int i=0; i<N; i++) {
    		arr[i] = nextInt();
    	}
    	// solution
    	for (int i=0; i<N; i++) {
    		dp[i] = 1;
    		for (int j=0; j<i; j++) {
    			if (arr[i]>arr[j])
    				dp[i] = Math.max(dp[i], dp[j]+1);
    		}
    		answer = Math.max(dp[i], answer);
    	}
    	System.out.println(N-answer);
    }
}
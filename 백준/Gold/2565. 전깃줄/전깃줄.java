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
    	int[] dp = new int[N];
    	int[][] line = new int[N][2];
    	int answer = 0;
    	for (int i=0; i<N; i++) {
    		line[i][0] = nextInt();
    		line[i][1] = nextInt();
    	}
        Arrays.sort(line, (a, b) -> a[0] - b[0]);

        for (int i=0; i<N; i++) {
        	dp[i] = 1;
        	for (int j=0; j<i; j++) {
        		if (line[i][1]>line[j][1])
        			dp[i] = Math.max(dp[j]+1, dp[i]);
        	}
        	answer = Math.max(answer, dp[i]);
        }
        System.out.println(N-answer);
    }
}
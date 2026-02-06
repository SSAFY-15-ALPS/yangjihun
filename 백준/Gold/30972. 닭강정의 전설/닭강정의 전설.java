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
        int[][] arr = new int[N][N];
        int[][] sumArr = new int[N+1][N+1];
        int[] rc1 = new int[2];
        int[] rc2 = new int[2];
        int answer;
        // 할당
        for (int i=0; i<N; i++) {
        	for (int j=0; j<N; j++) {
        		arr[i][j] = nextInt();
        	}
        }
        for (int i=1;i<=N; i++) {
        	for (int j=1; j<=N; j++) {
        		sumArr[i][j] = sumArr[i-1][j] + sumArr[i][j-1] - sumArr[i-1][j-1] + arr[i-1][j-1];
        	}
        }
        // solution
        int Q = nextInt();
        int yMax, yMin, xMax, xMin;
        for (int i=0; i<Q; i++) {
            answer = 0;
	        rc1[0] = nextInt();
	        rc1[1] = nextInt();
	        rc2[0] = nextInt();
	        rc2[1] = nextInt();
	        answer -= sumArr[Math.max(rc1[0], rc2[0])][Math.max(rc1[1], rc2[1])] - sumArr[Math.min(rc1[0], rc2[0])-1][Math.max(rc1[1], rc2[1])] - sumArr[Math.max(rc1[0], rc2[0])][Math.min(rc1[1], rc2[1])-1] + sumArr[Math.min(rc1[0], rc2[0])-1][Math.min(rc1[1], rc2[1])-1];
	        answer += 2*(sumArr[Math.max(rc1[0], rc2[0])-1][Math.max(rc1[1], rc2[1])-1] - sumArr[Math.min(rc1[0], rc2[0])][Math.max(rc1[1], rc2[1])-1] - sumArr[Math.max(rc1[0], rc2[0])-1][Math.min(rc1[1], rc2[1])] + sumArr[Math.min(rc1[0], rc2[0])][Math.min(rc1[1], rc2[1])]);
	        
	        System.out.println(answer);
        }
    }
}
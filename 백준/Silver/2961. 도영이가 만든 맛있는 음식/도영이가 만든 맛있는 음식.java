import java.io.*;
import java.util.*;

public class Main{
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
	
	static int answer = Integer.MAX_VALUE;
	static int N;
	static boolean[] visited;
	static int[][] arr;
	static void BT(int sour, int hot, int depth) {
		if (depth>0)
			answer = Math.min(answer, Math.abs(sour-hot));
		for (int i=0; i<N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				BT(sour*arr[i][0],hot+arr[i][1], depth+1);
				visited[i] = false;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		N = nextInt();
		visited = new boolean[N];
		arr = new int[N][2];
		for (int i=0; i<N; i++) {
			arr[i][0] = nextInt();
			arr[i][1] = nextInt();
		}
		if (N==1)
			System.out.println(Math.abs(arr[0][0]-arr[0][1]));
		else {
			BT(1,0,0);
			System.out.println(answer);
		}
	}
}
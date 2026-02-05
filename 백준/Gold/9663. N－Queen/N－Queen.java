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
	
	static int answer = 0;
	static int N;
	static boolean[][] visited;
	static int[][] arr;
	static void BT(int depth) {
		if (depth==N) {
			answer++;
			return;
		}
		
		for (int i=0; i<N;i++) {
			if (search(depth,i)) {
				visited[depth][i] = true;
				BT(depth+1);
				visited[depth][i] = false;
			}
		}
	}
	static boolean search(int i, int j) {
		boolean check = false;
		for (int x=0; x<N; x++) {
			if (visited[i][x]) return check;
		}
		for (int y=0; y<N; y++) {
			if (visited[y][j]) return check;
		}
		for (int num=0; num<N;num++) {
			if (i-num>=0 && i-num<N && j-num>=0 && j-num<N)
				if(visited[i-num][j-num]) return check;
			if (i-num>=0 && i-num<N && j+num>=0 && j+num<N)
				if (visited[i-num][j+num]) return check;
			if (i+num>=0 && i+num<N && j-num>=0 && j-num<N)
				if (visited[i+num][j-num]) return check;
			if (i+num>=0 && i+num<N && j+num>=0 && j+num<N)
				if (visited[i+num][j+num]) return check;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		N = nextInt();
		visited = new boolean[N][N];
		BT(0);
		System.out.println(answer);
	}
}
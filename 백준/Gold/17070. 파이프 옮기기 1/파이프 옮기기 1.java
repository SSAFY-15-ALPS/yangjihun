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
	
	public static int DFS(int y, int x, int state) {
		if (y==N-1 && x==N-1) {
			return 1;
		}
		int answer = 0;
		if (state==0) {
			if (x+1<N && arr[y][x+1]!=1) {
				answer+=DFS(y,x+1,0);
			}
			if (x+1<N && y+1<N && arr[y][x+1]!=1 && arr[y+1][x+1]!=1 && arr[y+1][x]!=1) {
				answer+=DFS(y+1,x+1,1);
			}
		}
		if (state==1) {
			if (x+1<N && arr[y][x+1]!=1) {
				answer+=DFS(y,x+1,0);
			}
			if (x+1<N && y+1<N && arr[y][x+1]!=1 && arr[y+1][x+1]!=1 && arr[y+1][x]!=1) {
				answer+=DFS(y+1,x+1,1);
			}
			if (y+1<N && arr[y+1][x]!=1) {
				answer+=DFS(y+1,x,2);
			}
		}
		if (state==2) {
			if (x+1<N && y+1<N && arr[y][x+1]!=1 && arr[y+1][x+1]!=1 && arr[y+1][x]!=1) {
				answer+=DFS(y+1,x+1,1);
			}
			if (y+1<N && arr[y+1][x]!=1) {
				answer+=DFS(y+1,x,2);
			}
		}
		return answer;
	}
	public static void main(String[] args) throws Exception {
		// 선언
		int answer;
		N = nextInt();
		arr = new int[N][N];
		for (int i=0; i<N;i++) {
			for (int j=0; j<N;j++) {
				arr[i][j] = nextInt();
			}
		}
		
		answer = DFS(0,1,0);
		System.out.println(answer);
		
	}
}
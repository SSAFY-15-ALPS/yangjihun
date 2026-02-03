import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int nextInt() throws Exception {
		while(st==null || !st.hasMoreTokens()) {
			String line = br.readLine();
			if (line==null) return Integer.MAX_VALUE;
			st = new StringTokenizer(line);
		}
		return Integer.parseInt(st.nextToken());
	}
	public static void main(String[] args) throws Exception {
		// 선언
		int answer = 1;
		int N = nextInt();
		int M = nextInt();
		int L = nextInt();
		int R = nextInt();
		int[][] arr = new int[N][M];
		int[] dot = {};
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		int nx,ny;
		boolean[][] visited = new boolean[N][M];
//		Queue<int[]> que = new ArrayDeque<>();
		Queue<int[]> que = new PriorityQueue<>(
			(a,b) -> Integer.compare(b[2]+b[3], a[2]+a[3])
		);
		// 할당
		for (int i=0; i<N; i++) {
			String line = br.readLine();
			for (int j=0; j<M; j++) {
				arr[i][j] = line.charAt(j) - '0';
				if (arr[i][j]==2) {
					dot = new int[] {i,j};
				}
			}
		}
		// Solution
		que.offer(new int[] {dot[0],dot[1],L,R});
		visited[dot[0]][dot[1]] = true;
		while (!que.isEmpty()) {
			dot = que.poll();
			for (int i=0; i<4; i++) {
				nx = dot[1] + dx[i];
				ny = dot[0] + dy[i];
				if (nx>=0 && nx<M && ny>=0 && ny<N && !visited[ny][nx] && arr[ny][nx]!=1) {
					if (i==2 && dot[2]>0) {
						visited[ny][nx] = true;
						answer++;
						que.offer(new int[] {ny,nx,dot[2]-1,dot[3]});
					}
					if (i==3 && dot[3]>0) {
						visited[ny][nx] = true;
						answer++;
						que.offer(new int[] {ny,nx,dot[2],dot[3]-1});
					}
					if (i<=1) {
						visited[ny][nx] = true;
						answer++;
						que.offer(new int[] {ny,nx,dot[2],dot[3]});
					}
				}
			}
		}
		System.out.println(answer);
	}
}
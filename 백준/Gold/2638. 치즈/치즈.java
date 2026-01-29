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
		// 선언
		int answer = 0;
		int N = nextInt();
		int M = nextInt();
		int[][] arr = new int[N][M];
		int cheeze = 0;
		int num, nx, ny;
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		int[] c;
		int[][] visited = new int[N][M];
		Queue<int[]> dq = new ArrayDeque<>();
		// 할당
		for (int i=0; i<N; i++) {
			for (int j=0; j<M;j++) {
				num = nextInt();
				if (num==1)
					cheeze++;
				arr[i][j] = num;
			}
		}
		// solve
		while (cheeze!=0) {
			answer++;
			dq.offer(new int[]{0,0});
			for (int i=0; i<N;i++) {
				for (int j=0; j<M;j++)  {
					visited[i][j] = 0;
				}
			}
			while (!dq.isEmpty()) {
				c = dq.poll();
				for (int next=0; next<4; next++) {
					ny = c[0] + dy[next];
					nx = c[1] + dx[next];
					if (ny>=0 && nx>=0 && ny<N && nx<M) {
						if (arr[ny][nx]==1) {
							visited[ny][nx]++;
						}
						else if (visited[ny][nx]==0) {
							visited[ny][nx] = -1;
							dq.offer(new int[]{ny,nx});
						}
					}
				}
			}
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					if (arr[i][j]==1 && visited[i][j]>=2) {
						arr[i][j] = 0;
						cheeze--;
					}
				}
			}
		}
		System.out.println(answer);
	}
}
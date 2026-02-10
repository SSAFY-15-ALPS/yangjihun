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
		int M = nextInt();
		int[][] arr = new int[N][M];
		boolean[][] visited;
		int cheeze = 0;
		int time = 0;
		int currentCheeze = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		// 할당
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				arr[i][j] = nextInt();
				if (arr[i][j]==1) currentCheeze++;
			}
		}
		// solution
		int[] dy = {1,-1,0,0};
		int[] dx = {0,0,-1,1};
		int[] cur;
		int ny,nx;
		
		while (currentCheeze!=0) {
			queue.add(new int[] {0,0});
			time++;
			cheeze = currentCheeze;
			visited = new boolean[N][M];
			while (!queue.isEmpty()) {
				cur = queue.poll();
				for (int i=0; i<4; i++) {
					ny = cur[0] + dy[i];
					nx = cur[1] + dx[i];
					if (ny>=0 && ny<N && nx>=0 && nx<M && !visited[ny][nx]) {
						if (arr[ny][nx]==1) {
							arr[ny][nx] = 0;
							currentCheeze--;
						}
						else {
							queue.add(new int[] {ny,nx});
						}
						visited[ny][nx] = true;
					}
				}
			}
		}
		System.out.println(time);
		System.out.println(cheeze);
	}
}
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 선언
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> que = new ArrayDeque<>();
		// 할당
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// solved
		que.add(new int[] {0,0});
		visited[0][0] = true;
		int[] dy = {1,0};
		int[] dx = {0,1};
		int ny,nx;
		int[] current;
		String answer = "No";
		while (!que.isEmpty()) {
			current = que.poll();
			if (current[0]==N-1 && current[1]==M-1) {
				answer = "Yes";
			}
			for (int i=0; i<2; i++) {
				ny = current[0] + dy[i];
				nx = current[1] + dx[i];
				if (ny<0 || nx<0 || ny>=N || nx>=M || visited[ny][nx] || map[ny][nx]==0) continue;
				visited[ny][nx] = true;
				que.add(new int[] {ny, nx});
			}
		}
		System.out.println(answer);
	}
}
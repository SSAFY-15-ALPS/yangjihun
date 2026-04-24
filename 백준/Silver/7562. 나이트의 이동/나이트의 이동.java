import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test=0; test<T; test++) {
			// 선언
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			int[][] visited = new int[N][N];
			int[] knight = new int[2];
			int[] point = new int[2];
			Queue<int[]> que = new ArrayDeque<>();
			// 할당
			for (int i=0; i<N; i++) {
				Arrays.fill(visited[i], -1);
			}
			knight[0] = sc.nextInt();
			knight[1] = sc.nextInt();
			point[0] = sc.nextInt();
			point[1] = sc.nextInt();
			que.add(knight);
			// solve
			int[] current = new int[2];
			int[] dy = {1,2,2,1,-1,-2,-2,-1};
			int[] dx = {-2,-1,1,2,2,1,-1,-2};
			int y,x,ny, nx;
			while (!que.isEmpty()) {
				current = que.poll();
				y = current[0];
				x = current[1];
				if (y==point[0] && x==point[1]) {
					System.out.println(visited[y][x]+1);
					break;
				}
				for (int i=0; i<8; i++) {
					ny = y + dy[i];
					nx = x + dx[i];
					if (ny<0 || nx<0 || ny>=N || nx>=N || visited[ny][nx]!=-1) continue;
					que.add(new int[] {ny, nx});
					visited[ny][nx] = visited[y][x]+1;
				}
			}
		}
	}
}
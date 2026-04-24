import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = 1;
		while(true) {
			// 선언
			int N = sc.nextInt();
			if (N==0) break;
			int[][] map = new int[N][N];
			int[][] visited = new int[N][N];
			Queue<int[]> pq = new PriorityQueue<>((a,b) -> {
				return visited[a[0]][a[1]]-visited[b[0]][b[1]];
			});
			// 할당
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
					visited[i][j] = -1;
				}
			}
			pq.add(new int[] {0,0});
			visited[0][0] = map[0][0];
			// solve
			int[] current = new int[2];
			int[] dy = {1,-1,0,0};
			int[] dx = {0,0,1,-1};
			int ny,nx;
			while (!pq.isEmpty()) {
				current = pq.poll();
				if (current[0]==N-1 && current[1]==N-1) {
					System.out.println("Problem " + test++ + ": " + visited[current[0]][current[1]]);
					break;
				}
				for (int i=0; i<4; i++) {
					ny = current[0] + dy[i];
					nx = current[1] + dx[i];
					if (ny<0 || nx<0 || ny>=N || nx>=N || visited[ny][nx]!=-1) continue;
					visited[ny][nx] = map[ny][nx] + visited[current[0]][current[1]];
					pq.add(new int[] {ny, nx});
				}
			}
		}
	}
}
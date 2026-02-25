import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static boolean[][] visited;
	static int N;
	
	static int nextInt() throws Exception {
		while (st==null || !st.hasMoreTokens()) {
			String line = br.readLine();
			if (line==null) return Integer.MIN_VALUE;
			st = new StringTokenizer(line);
		}
		return Integer.parseInt(st.nextToken());
	}
	
	static int canGo(int size, int cy, int cx, int ty, int tx) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {cy,cx,0});
		int[] dy = {-1,1,0,0};
		int[] dx = {0,0,-1,1};
		visited = new boolean[N][N];
		int[] current;
		while (!queue.isEmpty()) {
			current = queue.poll();
			for (int i=0; i<4; i++) {
				int ny = current[0] + dy[i];
				int nx = current[1] + dx[i];
				if (0<=ny && 0<=nx && N>ny && N>nx && !visited[ny][nx] && size>=map[ny][nx]) {
					if (ny==ty && nx==tx) {
						return current[2] + 1;
					}
					visited[ny][nx] = true;
					queue.add(new int[] {ny,nx,current[2]+1});
				}
			}
		}
		return -1;
	}
	
	static List<int[]> canEat(int size) {
		List<int[]> canEatList = new ArrayList<>(); // 현재 먹을 수 있는 물고기 위치를 저장
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (size > map[i][j] && map[i][j]!=0) {
					canEatList.add(new int[] {i,j});
				}
			}
		}
		return canEatList;
	}
	
	public static void main(String[] args) throws Exception {
		// 정의
		N = nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		int[] start = {0,0};
		// 할당
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				map[i][j] = nextInt();
				if (map[i][j]==9) {
					start = new int[] {i,j};
					map[i][j] = 0;
				}
			}
		}
		// Solution
		/* 아기 상어의 초기 크기는 2
		 * 크기와 같은 수의 물고기를 먹어야 크기+1
		 * 거리가 가장 가까운 물고기를 먹어야 함
		 * 거리가 동일하다면 위에 있어야 하고, 위 중에서는 가장 왼쪽이어야 함
		 * O(N*N(먹을 수 있는 물고기 전체 탐색)
		 */
		int size = 2; // 아기상어 사이즈
		int eat = 0; // 몇 마리 먹었는지
		int[] toGo = {Integer.MAX_VALUE,Integer.MAX_VALUE}; // 갈 곳
		int[] willGo = {0,0};
		int dist;
		int mDist;
		int answer = 0;
		List<int[]> canEatList; // 현재 먹을 수 있는 물고기 위치를 저장
		canEatList = canEat(size);
		while (!canEatList.isEmpty()) {
			dist = Integer.MAX_VALUE;
			for (int i=0; i<canEatList.size(); i++) {
				willGo[0] = canEatList.get(i)[0];
				willGo[1] = canEatList.get(i)[1];
				mDist = canGo(size, start[0], start[1],willGo[0], willGo[1]);
				if (mDist!=-1) { // 갈 수 있다면 비교
					if (dist > mDist) {
						dist = mDist;
						toGo[0] = willGo[0];
						toGo[1] = willGo[1];
					}
					else if (dist == mDist) {
						if (willGo[0] < toGo[0]) {
							toGo[0] = willGo[0];
							toGo[1] = willGo[1];
						}
						else if (willGo[0]==toGo[0] && willGo[1] < toGo[1]){
							toGo[0] = willGo[0];
							toGo[1] = willGo[1];
						}
					}
				}
			}
			if (dist==Integer.MAX_VALUE) break; // 먹을 수 있는 게 없고, 갈 수 있는 게 없다면 종료
			start = new int[] {toGo[0], toGo[1]};
			map[toGo[0]][toGo[1]] = 0;
			answer += dist;
			eat++;
			if (eat==size) {
				size++;
				eat = 0;
			}
			canEatList = canEat(size);
		}
		System.out.println(answer);
	}
}
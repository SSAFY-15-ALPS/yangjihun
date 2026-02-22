import java.util.*;

public class Main {
	static boolean[][] mapMemory;
	static boolean[][] map;
	static int N,M,range;
	static int answer = 0;
	static int count;
	static int[][] q;
	
	static void shoot(int archerCol) {
		int bestR = -1, bestC = -1;
		int bestDist = Integer.MAX_VALUE;
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				if (!map[r][c]) continue;
				
				int dist = (N-r) + Math.abs(archerCol - c);
				if (dist > range) continue;
				
				if (dist<bestDist || (dist==bestDist && c<bestC)) {
					bestDist = dist;
					bestR = r;
					bestC = c;
				}
			}
		}
		if (bestR != -1) q[archerCol] = new int[] {bestR, bestC};
	}
	
	static void simulation(int a, int b, int c) {
		// 배열 복사
		for (int line=0; line<N; line++) {
			map[line] = Arrays.copyOf(mapMemory[line], M);
		}
		count = 0;
		
		for (int i=0; i<N; i++) {
			// q 초기화
			for (int line=0; line<M; line++) {
				Arrays.fill(q[line], -1);
			}
			
			// 3명이 발사
			for (int archer : new int[] {a,b,c}) {
				shoot(archer);
			}
			Set<Integer> targets = new HashSet<>();
			for (int col : new int[] {a,b,c}) {
				if (q[col][0]!=-1) targets.add(q[col][0] * M + q[col][1]);
			}
			for (int enc : targets) {
				int r = enc / M;
				int cc = enc % M;
				if (map[r][cc]) {
					map[r][cc] = false;
					count++;
				}
			}
			// 적 이동
			for (int y=N-1; y>=1; y--) {
				for (int down=0; down<M; down++) {
					map[y][down] = map[y-1][down];
				}
			}
			for (int x=0; x<M; x++) map[0][x] = false;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		range = sc.nextInt();
		int num;
		q = new int[M][2];
		map = new boolean[N][M];
		mapMemory = new boolean[N][M];
		// 할당
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				num = sc.nextInt();
				map[i][j] = num==1 ? true : false;
			}
		}
		for (int i=0; i<N; i++) {
			mapMemory[i] = Arrays.copyOf(map[i], M);
		}
		// Solution
		// 궁수 배치
		for (int a=0; a<M; a++) {
			for (int b=a+1; b<M; b++) {
				for (int c=b+1; c<M; c++) {
					simulation(a,b,c);
					answer = Math.max(answer, count);
				}
			}
		}
		System.out.println(answer);
	}
}
import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int answer = 0;
	
	static int nextInt() throws Exception {
		while (st==null || !st.hasMoreTokens()) {
			String line = br.readLine();
			if (line==null) return Integer.MIN_VALUE;
			st = new StringTokenizer(line);
		}
		return Integer.parseInt(st.nextToken());
	}
	
	static int[][] shiftUpper(int[][] map) {
		for (int j=0; j<N; j++) {
			int[] line = new int[N];
			int idx = 0;
			for (int i=0; i<N; i++) {
				if (map[i][j]!=0) line[idx++] = map[i][j];
			}
			int[] merged = new int[N];
			int w = 0;
			for (int i=0; i<idx; i++) {
				if (i+1 < idx && line[i] == line[i+1]) {
			        merged[w++] = line[i]*2;
			        i++;
			    } else {
			        merged[w++] = line[i];
			    }
			}
			for (int i=0; i<N; i++) {
				map[i][j] = merged[i];
			}
		}
		return map;
	}
	
	static int[][] shiftLower(int[][] map) {
		for (int j=0; j<N; j++) {
			int[] line = new int[N];
			int idx = 0;
			for (int i=N-1; i>=0; i--) {
				if (map[i][j]!=0) line[idx++] = map[i][j];
			}
			int[] merged = new int[N];
			int w = 0;
			for (int i=0; i<idx; i++) {
				if (i+1 < idx && line[i] == line[i+1]) {
			        merged[w++] = line[i]*2;
			        i++;
			    } else {
			        merged[w++] = line[i];
			    }
			}
			for (int i=0; i<N; i++) {
				map[N-i-1][j] = merged[i];
			}
		}
		return map;
	}
	static int[][] shiftRight(int[][] map) {
		for (int i=0; i<N; i++) {
			int[] line = new int[N];
			int idx = 0;
			for (int j=N-1; j>=0; j--) {
				if (map[i][j]!=0) line[idx++] = map[i][j];
			}
			int[] merged = new int[N];
			int w = 0;
			for (int j=0; j<idx; j++) {
				if (j+1 < idx && line[j] == line[j+1]) {
			        merged[w++] = line[j]*2;
			        j++;
			    } else {
			        merged[w++] = line[j];
			    }
			}
			for (int j=0; j<N; j++) {
				map[i][N-j-1] = merged[j];
			}
		}
		return map;
	}
	static int[][] shiftLeft(int[][] map) {
		for (int i=0; i<N; i++) {
			int[] line = new int[N];
			int idx = 0;
			for (int j=0; j<N; j++) {
				if (map[i][j]!=0) line[idx++] = map[i][j];
			}
			int[] merged = new int[N];
			int w = 0;
			for (int j=0; j<idx; j++) {
				if (j+1 < idx && line[j] == line[j+1]) {
			        merged[w++] = line[j]*2;
			        j++;
			    } else {
			        merged[w++] = line[j];
			    }
			}
			for (int j=0; j<N; j++) {
				map[i][j] = merged[j];
			}
		}
		return map;
	}
	
	static void BT(int depth, int[][] dMap) {
		if (depth==5) {
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (answer < dMap[i][j]) {
						answer = dMap[i][j];
					}
				}
			}
			return;
		}
		BT(depth+1, shiftUpper(copy(dMap)));
		BT(depth+1, shiftLower(copy(dMap)));
		BT(depth+1, shiftRight(copy(dMap)));
		BT(depth+1, shiftLeft(copy(dMap)));
		
	}
	
	static int[][] copy(int[][] map) {
		int[][] dMap = new int[N][N];
		for (int i=0; i<N; i++) {
			System.arraycopy(map[i], 0, dMap[i], 0, N);
		}
		return dMap;
	}
	
	public static void main(String[] args) throws Exception {
		// 정의
		N = nextInt();
		int[][] map = new int[N][N];
		// 할당
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				map[i][j] = nextInt();
			}
		}
		BT(0, map);
		System.out.println(answer);
	}
}
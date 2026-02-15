import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int nextInt() throws Exception {
		while(st==null || !st.hasMoreTokens()) {
			String line = br.readLine();
			if (line==null) return Integer.MIN_VALUE;
			st = new StringTokenizer(line);
		}
		return Integer.parseInt(st.nextToken());
	}
	public static void main(String[] args) throws Exception {
		int R = nextInt();
		int C = nextInt();
		int T = nextInt();
		int[][] room = new int[R][C];
		int[][] newRoom = new int[R][C];
		// 할당
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				room[i][j] = nextInt();
			}
		}
		for (int second=0; second<T; second++) {
		newRoom = new int[R][C];
		// 미세먼지 확산
		int[] dy = {1,0,-1,0};
		int[] dx = {0,-1,0,1};
		int nx,ny, waste;
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (room[i][j]==-1) {
					newRoom[i][j] = -1;
					continue;
				}
				if (room[i][j]>0) {
					waste = room[i][j];
					for (int arrow=0; arrow<4; arrow++) {
						ny = i + dy[arrow];
						nx = j + dx[arrow];
						if (ny>=0 && ny<R && nx>=0 && nx<C) {
							if (room[ny][nx]!=-1) {
								newRoom[ny][nx] += room[i][j]/5;
								waste -= room[i][j]/5;
							}

						}
					}
					newRoom[i][j] += waste;
				}
			}
		}
		// 공기청정기
		int[][] air = new int[2][2];
		for (int i=0; i<R; i++) {
			if (newRoom[i][0]==-1) {
				air[0] = new int[] {i,0};
				air[1] = new int[] {i+1,0};
				break;
			}
		}
		newRoom[air[0][0]][0] = -1;
		newRoom[air[1][0]][0] = -1;
		// 위쪽
			for (int y=air[0][0]-1;y>0; y--) newRoom[y][0] = newRoom[y-1][0];
			for (int x=0; x<C-1; x++) newRoom[0][x] = newRoom[0][x+1];
			for (int y=0; y<air[0][0]; y++) newRoom[y][C-1] = newRoom[y+1][C-1];
			for (int x=C-1; x>1; x--) newRoom[air[0][0]][x] = newRoom[air[0][0]][x-1];
			newRoom[air[0][0]][1] = 0;
			// 아래쪽
			for (int y=air[1][0]+1;y<R-1; y++) newRoom[y][0] = newRoom[y+1][0];
			for (int x=0; x<C-1; x++) newRoom[R-1][x] = newRoom[R-1][x+1];
			for (int y=R-1; y>air[1][0]; y--) newRoom[y][C-1] = newRoom[y-1][C-1];
			for (int x=C-1; x>1; x--) newRoom[air[1][0]][x] = newRoom[air[1][0]][x-1];
			newRoom[air[1][0]][1] = 0;
			room = newRoom;
		}
		
		int answer = 0;
		for (int i=0; i<R; i++) {
			for (int j=0; j<C;j++) {
				if (room[i][j]>0)
					answer += room[i][j];
			}
		}
		System.out.println(answer);
	}
}